package xdptdr.ulhiunteco.az;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAZ extends AbstractTest {

	private String classroomName1 = "classroomName1";
	private String courseName1 = "courseName1";
	private String dayName1 = "dayName1";
	private Long classroom1Id;
	private Long day1Id;
	private Long course1Id;
	private Long meet1PkClassroom1Id;
	private Long meet1PkCourse1Id;
	private Long meet1PkDay1Id;

	public TestAZ() {
		super(new Class<?>[] { ClassroomAZ.class, CourseAZ.class, DayAZ.class, MeetsAZ.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ClassroomAZ classroom1 = new ClassroomAZ(classroomName1);
			DayAZ day1 = new DayAZ(dayName1);
			CourseAZ course1 = new CourseAZ(courseName1);
			session.save(classroom1);
			session.save(day1);
			session.save(course1);
			MeetsAZ meet1 = new MeetsAZ(classroom1, course1, day1);
			session.save(meet1);
			classroom1Id = classroom1.getId();
			day1Id = day1.getId();
			course1Id = course1.getId();
			meet1PkClassroom1Id = meet1.getPk().getClassroomId();
			meet1PkCourse1Id = meet1.getPk().getCourseId();
			meet1PkDay1Id = meet1.getPk().getDayId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(classroom1Id);
		Assert.assertNotNull(day1Id);
		Assert.assertNotNull(course1Id);
		Assert.assertEquals(classroom1Id, meet1PkClassroom1Id);
		Assert.assertEquals(course1Id, meet1PkCourse1Id);
		Assert.assertEquals(day1Id, meet1PkDay1Id);
	}

	@Test
	public void testCreate() {
		create();
	}

}