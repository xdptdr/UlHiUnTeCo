package xdptdr.ulhiunteco.bj;

import java.io.PrintStream;
import java.sql.SQLException;
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

public class TestBJ extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private Long parameterId;
	private Long countryId;

	public TestBJ() {
		super(new Class<?>[] { NamedItemBJ.class, ParameterBJ.class, CountryBJ.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBJ parameter = new ParameterBJ(parameterName, parameterValue);
			CountryBJ country = new CountryBJ(countryName, countryPopulation);
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

				Query query = session.createQuery("from NamedItemBJ where DTYPE = ?");
				query.setParameter(0, "ParameterBJ");

				results = query.list();

				tx.commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}

			Assert.assertTrue(results.size() > 0);
			for (Object result : results) {
				Assert.assertTrue(result instanceof ParameterBJ);
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

				Query query = session.createQuery("from NamedItemBJ where DTYPE = ?");
				query.setParameter(0, "CountryBJ");

				results = query.list();

				tx.commit();
			} finally {
				if (session != null) {
					session.close();
				}
			}

			Assert.assertTrue(results.size() > 0);
			for (Object result : results) {
				Assert.assertTrue(result instanceof CountryBJ);
			}
		}

	}

	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.NAMED_ITEM_BJ"));
	}
}