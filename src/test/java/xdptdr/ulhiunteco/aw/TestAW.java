package xdptdr.ulhiunteco.aw;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAW extends AbstractTest {

	private static final String personName1 = "personName1";
	private static final String personName2 = "personName2";
	private static final String personName3 = "personName3";
	private static final String personName4 = "personName4";
	private static final String personName5 = "personName5";
	private static final String personName6 = "personName6";
	private static final String buildingName1 = "buildingName1";
	private static final String buildingName2 = "buildingName2";
	private static final String buildingName3 = "buildingName3";

	private Long person1Id = null;
	private Long person2Id = null;
	private Long person3Id = null;
	private Long person4Id = null;
	private Long person5Id = null;
	private Long person6Id = null;
	private Long building1Id = null;
	private Long building2Id = null;
	private Long building3Id = null;

	public TestAW() {
		super(new Class<?>[] { PersonAW.class, BuildingAW.class });
	}

	private void create() {

		PersonAW person1 = new PersonAW(personName1);
		PersonAW person2 = new PersonAW(personName2);
		PersonAW person3 = new PersonAW(personName3);
		PersonAW person4 = new PersonAW(personName4);
		PersonAW person5 = new PersonAW(personName5);
		PersonAW person6 = new PersonAW(personName6);
		BuildingAW building1 = new BuildingAW(buildingName1);
		BuildingAW building2 = new BuildingAW(buildingName2);
		BuildingAW building3 = new BuildingAW(buildingName3);

		AWUtils.bindUses(person1, building1);
		AWUtils.bindUses(person2, building1);
		AWUtils.bindUses(person2, building2);
		AWUtils.bindUses(person3, building1);
		AWUtils.bindUses(person3, building2);
		AWUtils.bindUses(person3, building3);
		AWUtils.bindUses(person4, building2);
		AWUtils.bindUses(person4, building3);
		AWUtils.bindUses(person5, building2);
		AWUtils.bindUses(person6, building3);

		AWUtils.bindOwns(person1, building1);
		AWUtils.bindOwns(person1, building2);
		// building3 is own by both person1 and person2
		AWUtils.bindOwns(person1, building3);
		AWUtils.bindOwns(person2, building3);

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.save(person1);
			session.save(person2);
			session.save(person3);
			session.save(person4);
			session.save(person5);
			session.save(person6);
			session.save(building1);
			session.save(building2);
			session.save(building3);

			person1Id = person1.getId();
			person2Id = person2.getId();
			person3Id = person3.getId();
			person4Id = person4.getId();
			person5Id = person5.getId();
			person6Id = person6.getId();

			building1Id = building1.getId();
			building2Id = building2.getId();
			building3Id = building3.getId();

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(person1Id);
		Assert.assertNotNull(person2Id);
		Assert.assertNotNull(person3Id);
		Assert.assertNotNull(person4Id);
		Assert.assertNotNull(person5Id);
		Assert.assertNotNull(person6Id);
		Assert.assertNotNull(building1Id);
		Assert.assertNotNull(building2Id);
		Assert.assertNotNull(building3Id);

	}

	@Test
	public void testCreate() {
		create();
	}
}