package xdptdr.ulhiunteco.bb;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBB extends AbstractTest {

	private String employeeName1 = "employeeName1";
	private String employeeName2 = "employeeName2";
	private String employeeName3 = "employeeName3";
	private String employeeName4 = "employeeName4";
	private String employeeName5 = "employeeName5";
	private String employeeName6 = "employeeName6";
	private String employeeName7 = "employeeName7";
	private String employeeName8 = "employeeName8";
	private String employeeName9 = "employeeName9";
	private String employeeName10 = "employeeName10";
	private String employeeName11 = "employeeName11";
	private String employeeName12 = "employeeName12";
	private Long employee1Id;
	private Long employee2Id;
	private Long employee3Id;
	private Long employee4Id;
	private Long employee5Id;
	private Long employee6Id;
	private Long employee7Id;
	private Long employee8Id;
	private Long employee9Id;
	private Long employee10Id;
	private Long employee11Id;
	private Long employee12Id;

	private Long manages1PkSubordinateId;
	private Long manages1PkManagerId;

	private Long manages2PkSubordinateId;
	private Long manages2PkManagerId;

	private Long manages3PkSubordinateId;
	private Long manages3PkManagerId;

	private Long manages4PkSubordinateId;
	private Long manages4PkManagerId;

	private Long manages5PkSubordinateId;
	private Long manages5PkManagerId;

	private Long manages6PkSubordinateId;
	private Long manages6PkManagerId;

	private Long manages7PkSubordinateId;
	private Long manages7PkManagerId;

	private Long manages8PkSubordinateId;
	private Long manages8PkManagerId;

	private Long manages9PkSubordinateId;
	private Long manages9PkManagerId;

	private Long manages10PkSubordinateId;
	private Long manages10PkManagerId;

	public TestBB() {
		super(new Class<?>[] { EmployeeBB.class, ManagesBB.class });
	}

	private void create() {

		// one manager which manages two employees
		// 1 manages 2 and 3

		// two manager which manage the same employee
		// 4 and 5 manage 6

		// one manager which manages a manager which manages an employee and
		// which also manages that employee
		// 7 manages 8
		// 8 manages 9
		// 7 manages 9

		// one manager which manages itself
		// 10 manages 10

		// a manager that manages his subordinate
		// 11 manages 12
		// 12 manages 11

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			// first the employees

			EmployeeBB employee1 = new EmployeeBB(employeeName1);
			EmployeeBB employee2 = new EmployeeBB(employeeName2);
			EmployeeBB employee3 = new EmployeeBB(employeeName3);
			EmployeeBB employee4 = new EmployeeBB(employeeName4);
			EmployeeBB employee5 = new EmployeeBB(employeeName5);
			EmployeeBB employee6 = new EmployeeBB(employeeName6);
			EmployeeBB employee7 = new EmployeeBB(employeeName7);
			EmployeeBB employee8 = new EmployeeBB(employeeName8);
			EmployeeBB employee9 = new EmployeeBB(employeeName9);
			EmployeeBB employee10 = new EmployeeBB(employeeName10);
			EmployeeBB employee11 = new EmployeeBB(employeeName11);
			EmployeeBB employee12 = new EmployeeBB(employeeName12);
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);
			session.save(employee5);
			session.save(employee6);
			session.save(employee7);
			session.save(employee8);
			session.save(employee9);
			session.save(employee10);
			session.save(employee11);
			session.save(employee12);

			// 1 manages 2 and 3
			ManagesBB manages1 = new ManagesBB(employee1, employee2);
			ManagesBB manages2 = new ManagesBB(employee1, employee3);
			session.save(manages1);
			session.save(manages2);

			// 4 and 5 manage 6
			ManagesBB manages3 = new ManagesBB(employee4, employee6);
			ManagesBB manages4 = new ManagesBB(employee5, employee6);
			session.save(manages3);
			session.save(manages4);

			// 7 manages 8 manages 9
			// 7 manages 9
			ManagesBB manages5 = new ManagesBB(employee7, employee8);
			ManagesBB manages6 = new ManagesBB(employee8, employee9);
			ManagesBB manages7 = new ManagesBB(employee7, employee9);
			session.save(manages5);
			session.save(manages6);
			session.save(manages7);

			// 10 manages 10
			ManagesBB manages8 = new ManagesBB(employee10, employee10);
			session.save(manages8);

			// 11 manages 12 manages 11 manages 12 ...
			ManagesBB manages9 = new ManagesBB(employee11, employee12);
			ManagesBB manages10 = new ManagesBB(employee12, employee11);
			session.save(manages9);
			session.save(manages10);

			employee1Id = employee1.getId();
			employee2Id = employee2.getId();
			employee3Id = employee3.getId();
			employee4Id = employee4.getId();
			employee5Id = employee5.getId();
			employee6Id = employee6.getId();
			employee7Id = employee7.getId();
			employee8Id = employee8.getId();
			employee9Id = employee9.getId();
			employee10Id = employee10.getId();
			employee11Id = employee11.getId();
			employee12Id = employee12.getId();

			manages1PkManagerId = manages1.getPk().getManagerId();
			manages1PkSubordinateId = manages1.getPk().getSubordinateId();

			manages2PkManagerId = manages2.getPk().getManagerId();
			manages2PkSubordinateId = manages2.getPk().getSubordinateId();

			manages3PkManagerId = manages3.getPk().getManagerId();
			manages3PkSubordinateId = manages3.getPk().getSubordinateId();

			manages4PkManagerId = manages4.getPk().getManagerId();
			manages4PkSubordinateId = manages4.getPk().getSubordinateId();

			manages5PkManagerId = manages5.getPk().getManagerId();
			manages5PkSubordinateId = manages5.getPk().getSubordinateId();

			manages6PkManagerId = manages6.getPk().getManagerId();
			manages6PkSubordinateId = manages6.getPk().getSubordinateId();

			manages7PkManagerId = manages7.getPk().getManagerId();
			manages7PkSubordinateId = manages7.getPk().getSubordinateId();

			manages8PkManagerId = manages8.getPk().getManagerId();
			manages8PkSubordinateId = manages8.getPk().getSubordinateId();

			manages9PkManagerId = manages9.getPk().getManagerId();
			manages9PkSubordinateId = manages9.getPk().getSubordinateId();

			manages10PkManagerId = manages10.getPk().getManagerId();
			manages10PkSubordinateId = manages10.getPk().getSubordinateId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(employee1Id);
		Assert.assertNotNull(employee2Id);
		Assert.assertNotNull(employee3Id);
		Assert.assertNotNull(employee4Id);
		Assert.assertNotNull(employee5Id);
		Assert.assertNotNull(employee6Id);
		Assert.assertNotNull(employee7Id);
		Assert.assertNotNull(employee8Id);
		Assert.assertNotNull(employee9Id);
		Assert.assertNotNull(employee10Id);
		Assert.assertNotNull(employee11Id);
		Assert.assertNotNull(employee12Id);
		Assert.assertEquals(employee1Id, manages1PkManagerId);
		Assert.assertEquals(employee2Id, manages1PkSubordinateId);
		Assert.assertEquals(employee1Id, manages2PkManagerId);
		Assert.assertEquals(employee3Id, manages2PkSubordinateId);
		Assert.assertEquals(employee4Id, manages3PkManagerId);
		Assert.assertEquals(employee6Id, manages3PkSubordinateId);
		Assert.assertEquals(employee5Id, manages4PkManagerId);
		Assert.assertEquals(employee6Id, manages4PkSubordinateId);
		Assert.assertEquals(employee7Id, manages5PkManagerId);
		Assert.assertEquals(employee8Id, manages5PkSubordinateId);
		Assert.assertEquals(employee8Id, manages6PkManagerId);
		Assert.assertEquals(employee9Id, manages6PkSubordinateId);
		Assert.assertEquals(employee7Id, manages7PkManagerId);
		Assert.assertEquals(employee9Id, manages7PkSubordinateId);
		Assert.assertEquals(employee10Id, manages8PkManagerId);
		Assert.assertEquals(employee10Id, manages8PkSubordinateId);
		Assert.assertEquals(employee11Id, manages9PkManagerId);
		Assert.assertEquals(employee12Id, manages9PkSubordinateId);
		Assert.assertEquals(employee12Id, manages10PkManagerId);
		Assert.assertEquals(employee11Id, manages10PkSubordinateId);
	}

	@Test
	public void testCreate() {
		create();
	}

}