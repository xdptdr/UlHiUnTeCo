package xdptdr.ulhiunteco.ay;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAY extends AbstractTest {

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

	public TestAY() {
		super(new Class<?>[] { PersonAY.class, BuildingAY.class });
	}

	private void create() {

		PersonAY person1 = new PersonAY(personName1);
		PersonAY person2 = new PersonAY(personName2);
		PersonAY person3 = new PersonAY(personName3);
		PersonAY person4 = new PersonAY(personName4);
		PersonAY person5 = new PersonAY(personName5);
		PersonAY person6 = new PersonAY(personName6);
		BuildingAY building1 = new BuildingAY(buildingName1);
		BuildingAY building2 = new BuildingAY(buildingName2);
		BuildingAY building3 = new BuildingAY(buildingName3);

		AYUtils.bindUses(person1, building1);
		AYUtils.bindUses(person2, building1);
		AYUtils.bindUses(person2, building2);
		AYUtils.bindUses(person3, building1);
		AYUtils.bindUses(person3, building2);
		AYUtils.bindUses(person3, building3);
		AYUtils.bindUses(person4, building2);
		AYUtils.bindUses(person4, building3);
		AYUtils.bindUses(person5, building2);
		AYUtils.bindUses(person6, building3);

		AYUtils.bindOwns(person1, building1);
		AYUtils.bindOwns(person1, building2);
		AYUtils.bindOwns(person1, building3);
		AYUtils.bindOwns(person2, building3);

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

	// There are several possible constraints on the schema:
	// C1: minCard(Person, Uses) = 0
	// C2: minCard(Person, Uses) = 1
	// C3: minCard(Building, Uses) = 0
	// C4: minCard(Building, Uses) = 1
	// C5: minCard(Person, Owns) = 0
	// C6: minCard(Person, Owns) = 1
	// C7: mincard(Building, Owns) = 0
	// C8: mincard(Building, Owns) = 1
	
	// It is obvious that C1 and C2 for example can't be enforced at the same time
	// So we can have C1, C2, or (not C1 and not C2)
	// If we state that with must have C1, this means that it is possible that some persons do not use any building
	// Checking this requires simply inserting a person in the database and checking that it succeeds
	// C1 does not need to be specified explicitly
    // C2 can be tested by performing the same operation and checking that it fails
	
	// In this example, it is said that
	// - participiation of building in the 'uses' relationship is optional,
	// - but participation of building in the 'owns' relationship is mandatory

	
	
}