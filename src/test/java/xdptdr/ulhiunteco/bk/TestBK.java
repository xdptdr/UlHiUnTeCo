package xdptdr.ulhiunteco.bk;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBK extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private Long parameterId;
	private Long countryId;

	public TestBK() {
		super(new Class<?>[] { NamedItemBK.class, ParameterBK.class, CountryBK.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBK parameter = new ParameterBK(parameterName, parameterValue);
			CountryBK country = new CountryBK(countryName, countryPopulation);
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
	public void testQueryOnDTYPE() {

		// DTYPE is the default discriminator column name used by hibernate

		create();

		{
			@SuppressWarnings("rawtypes")
			List results = null;

			Session session = null;
			Transaction tx = null;
			try {
				session = getSessionFactory().openSession();
				tx = session.beginTransaction();

				Query query = session.createQuery("from NamedItemBK where DTYPE = ?");
				query.setParameter(0, "ParameterBK");

				results = query.list();

				tx.commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}

			Assert.assertTrue(results.size() > 0);
			for (Object result : results) {
				Assert.assertTrue(result instanceof ParameterBK);
			}
		}

		{
			@SuppressWarnings("rawtypes")
			List results = null;

			Session session = null;
			Transaction tx = null;
			try {
				session = getSessionFactory().openSession();
				tx = session.beginTransaction();

				Query query = session.createQuery("from NamedItemBK where DTYPE = ?");
				query.setParameter(0, "CountryBK");

				results = query.list();

				tx.commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}

			Assert.assertTrue(results.size() > 0);
			for (Object result : results) {
				Assert.assertTrue(result instanceof CountryBK);
			}
		}

	}

}