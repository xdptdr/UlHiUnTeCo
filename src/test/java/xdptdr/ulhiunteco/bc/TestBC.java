package xdptdr.ulhiunteco.bc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.bc.CityBC;
import xdptdr.ulhiunteco.bc.IsBornInBC;
import xdptdr.ulhiunteco.bc.PersonBC;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBC extends AbstractTest {

	private String personName1 = "personName1";
	private String cityName1 = "cityName1";
	private String cityName2 = "cityName2";
	private Long person1Id;
	private Long city1Id;
	private Long city2Id;

	private Long isbornin1PkPersonId;
	private Long isbornin1PkCityId;
	private Integer isbornin1BirthYear;

	private Long isbornin2PkPersonId;
	private Long isbornin2PkCityId;
	private Integer isbornin2BirthYear;

	Integer person1City1BirthYear = 1987;
	Integer person1City2BirthYear = 1924;

	public TestBC() {
		super(new Class<?>[] { PersonBC.class, CityBC.class, IsBornInBC.class });
	}

	private void create() {

		// one person born in two cities at different dates
		// person1 is born in city1 in 1987 and in city2 in 1924

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			// first the employees

			PersonBC person1 = new PersonBC(personName1);
			CityBC city1 = new CityBC(cityName1);
			CityBC city2 = new CityBC(cityName2);
			session.save(person1);
			session.save(city1);
			session.save(city2);

			IsBornInBC isbornin1 = new IsBornInBC(person1, city1, person1City1BirthYear);
			IsBornInBC isbornin2 = new IsBornInBC(person1, city2, person1City2BirthYear);
			session.save(isbornin1);
			session.save(isbornin2);

			person1Id = person1.getId();
			city1Id = city1.getId();
			city2Id = city2.getId();

			isbornin1PkPersonId = isbornin1.getPk().getPersonId();
			isbornin1PkCityId = isbornin1.getPk().getCityId();
			isbornin1BirthYear = isbornin1.getBirthYear();

			isbornin2PkPersonId = isbornin2.getPk().getPersonId();
			isbornin2PkCityId = isbornin2.getPk().getCityId();
			isbornin2BirthYear = isbornin2.getBirthYear();

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(person1Id);
		Assert.assertNotNull(city1Id);
		Assert.assertNotNull(city2Id);
		Assert.assertEquals(person1Id, isbornin1PkPersonId);
		Assert.assertEquals(city1Id, isbornin1PkCityId);
		Assert.assertEquals(person1City1BirthYear, isbornin1BirthYear);
		Assert.assertEquals(person1Id, isbornin2PkPersonId);
		Assert.assertEquals(city2Id, isbornin2PkCityId);
		Assert.assertEquals(person1City2BirthYear, isbornin2BirthYear);
	}

	@Test
	public void testCreate() {
		create();
	}

}