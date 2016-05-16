package xdptdr.ulhiunteco.bv;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBV extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private Long parameterId;
	private Long countryId;

	// single table inheritance

	public TestBV() {
		super(new Class<?>[] { NamedItemBV.class, ParameterBV.class, CountryBV.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBV parameter = new ParameterBV(parameterName, parameterValue);
			CountryBV country = new CountryBV(countryName, countryPopulation);
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

		ParameterBV parameter = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			parameter = (ParameterBV) session.get(ParameterBV.class, parameterId);

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

		NamedItemBV namedItem = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			namedItem = (NamedItemBV) session.get(NamedItemBV.class, parameterId);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertEquals(parameterName, namedItem.getName());
		Assert.assertTrue(namedItem instanceof ParameterBV);
	}

}