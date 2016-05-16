package xdptdr.ulhiunteco.bp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBP extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private Long parameterId;
	private Long countryId;

	// it's possible to rename the inherited columns to differents values for different classes
	// that's not confusing !
	
	public TestBP() {
		super(new Class<?>[] { ParameterBP.class, CountryBP.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBP parameter = new ParameterBP(parameterName, parameterValue);
			CountryBP country = new CountryBP(countryName, countryPopulation);
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
	public void testQuery() {

		create();

		ParameterBP parameter = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			parameter = (ParameterBP) session.get(ParameterBP.class, parameterId);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertEquals(parameterName, parameter.getName());
	}

}