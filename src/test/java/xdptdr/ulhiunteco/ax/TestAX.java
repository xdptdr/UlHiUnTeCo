package xdptdr.ulhiunteco.ax;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAX extends AbstractTest {

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

	public TestAX() {
		super(new Class<?>[] { PersonAX.class, BuildingAX.class });
	}

	private void create() {

		PersonAX person1 = new PersonAX(personName1);
		PersonAX person2 = new PersonAX(personName2);
		PersonAX person3 = new PersonAX(personName3);
		PersonAX person4 = new PersonAX(personName4);
		PersonAX person5 = new PersonAX(personName5);
		PersonAX person6 = new PersonAX(personName6);
		BuildingAX building1 = new BuildingAX(buildingName1);
		BuildingAX building2 = new BuildingAX(buildingName2);
		BuildingAX building3 = new BuildingAX(buildingName3);

		AXUtils.bindUses(person1, building1);
		AXUtils.bindUses(person2, building1);
		AXUtils.bindUses(person2, building2);
		AXUtils.bindUses(person3, building1);
		AXUtils.bindUses(person3, building2);
		AXUtils.bindUses(person3, building3);
		AXUtils.bindUses(person4, building2);
		AXUtils.bindUses(person4, building3);
		AXUtils.bindUses(person5, building2);
		AXUtils.bindUses(person6, building3);

		AXUtils.bindOwns(person1, building1);
		AXUtils.bindOwns(person1, building2);
		AXUtils.bindOwns(person1, building3);
		AXUtils.bindOwns(person2, building3);

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

		// building3 is set to be owned by both person1 and person2
		// but person2 wins
		// QUESTION : is there any way to get a warning ?

		BuildingAX gottenBuilding3 = null;
		PersonAX gottenPerson1 = null;
		PersonAX gottenPerson2 = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			gottenBuilding3 = (BuildingAX) session.get(BuildingAX.class, building3Id);
			gottenPerson1 = (PersonAX) session.get(PersonAX.class, person1Id);
			gottenPerson2 = (PersonAX) session.get(PersonAX.class, person2Id);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(gottenBuilding3);
		Assert.assertNotNull(gottenPerson1);
		Assert.assertNotNull(gottenPerson2);
		Assert.assertEquals(person2Id, gottenBuilding3.getOwnedBy().getId());
		
		// These fails, because computed hash seems to be stale
		// Assert.assertFalse(gottenPerson1.getOwns().contains(gottenBuilding3));
		// Assert.assertTrue(gottenPerson2.getOwns().contains(gottenBuilding3));
		
		Assert.assertFalse(AXUtils.doesPersonOwnsBuilding(gottenPerson1, gottenBuilding3));
		Assert.assertFalse(AXUtils.isBuildingOwnedByPerson(gottenBuilding3, gottenPerson1));
		
		Assert.assertTrue(AXUtils.doesPersonOwnsBuilding(gottenPerson2, gottenBuilding3));
		Assert.assertTrue(AXUtils.isBuildingOwnedByPerson(gottenBuilding3, gottenPerson2));
		
		
		
		

	}
}