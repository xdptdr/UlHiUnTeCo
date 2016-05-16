package xdptdr.ulhiunteco.bw;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBW extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private Long parameterId;
	private Long countryId;

	// single table inheritance

	public TestBW() {
		super(new Class<?>[] { NamedItemBW.class, ParameterBW.class, CountryBW.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBW parameter = new ParameterBW(parameterName, parameterValue);
			CountryBW country = new CountryBW(countryName, countryPopulation);
			session.save(parameter);
			session.save(country);
			parameterId = (Long) session.getIdentifier(parameter);
			countryId = (Long) session.getIdentifier(country);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(parameterId);
		Assert.assertNotNull(countryId);

	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void testParameterNameQuery() {

		create();

		ParameterBW parameter = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			parameter = (ParameterBW) session.get(ParameterBW.class, parameterId);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertEquals(parameterName, parameter.getName());
	}
	
	@Test
	public void testCastQuery() {

		create();

		NamedItemBW namedItem = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			namedItem = (NamedItemBW) session.get(NamedItemBW.class, parameterId);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertEquals(parameterName, namedItem.getName());
		Assert.assertTrue(namedItem instanceof ParameterBW);
	}

}