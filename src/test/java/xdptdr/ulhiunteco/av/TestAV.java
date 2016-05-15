package xdptdr.ulhiunteco.av;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAV extends AbstractTest {

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

	public TestAV() {
		super(new Class<?>[] { PersonAV.class, BuildingAV.class });
	}

	private void create() {

		PersonAV person1 = new PersonAV(personName1);
		PersonAV person2 = new PersonAV(personName2);
		PersonAV person3 = new PersonAV(personName3);
		PersonAV person4 = new PersonAV(personName4);
		PersonAV person5 = new PersonAV(personName5);
		PersonAV person6 = new PersonAV(personName6);
		BuildingAV building1 = new BuildingAV(buildingName1);
		BuildingAV building2 = new BuildingAV(buildingName2);
		BuildingAV building3 = new BuildingAV(buildingName3);

		AVUtils.bindUses(person1, building1);
		AVUtils.bindUses(person2, building1);
		AVUtils.bindUses(person2, building2);
		AVUtils.bindUses(person3, building1);
		AVUtils.bindUses(person3, building2);
		AVUtils.bindUses(person3, building3);
		AVUtils.bindUses(person4, building2);
		AVUtils.bindUses(person4, building3);
		AVUtils.bindUses(person5, building2);
		AVUtils.bindUses(person6, building3);

		AVUtils.bindCleans(person1, building1);
		AVUtils.bindCleans(person1, building2);
		AVUtils.bindCleans(person1, building3);
		AVUtils.bindCleans(person2, building3);

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

	@Test
	public void testQuery() {

		create();

		BuildingAV gottenBuilding = null;
		boolean gottenPerson1 = false;
		boolean gottenPerson2 = false;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenBuilding = (BuildingAV) session.get(BuildingAV.class, building3Id);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(gottenBuilding);
		Set<PersonAV> gottenCleanedBy = gottenBuilding.getCleanedBy();
		for (PersonAV cleaner : gottenCleanedBy) {
			if (cleaner.getId() == person1Id) {
				gottenPerson1 = true;
			} else if (cleaner.getId() == person2Id) {
				gottenPerson2 = true;
			} else {
				Assert.fail();
			}
		}
		Assert.assertTrue(gottenPerson1);
		Assert.assertTrue(gottenPerson2);

	}

}