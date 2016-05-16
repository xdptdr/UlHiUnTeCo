package xdptdr.ulhiunteco.br;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.br.CountryBR;
import xdptdr.ulhiunteco.br.NamedItemBR;
import xdptdr.ulhiunteco.br.ParameterBR;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBR extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private Long parameterId;
	private Long countryId;

	// TABLE_PER_CLASS didn't seem to change anything here, possibly because of MappedSuperclass
	
	public TestBR() {
		super(new Class<?>[] { NamedItemBR.class, ParameterBR.class, CountryBR.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBR parameter = new ParameterBR(parameterName, parameterValue);
			CountryBR country = new CountryBR(countryName, countryPopulation);
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

		ParameterBR parameter = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			parameter = (ParameterBR) session.get(ParameterBR.class, parameterId);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertEquals(parameterName, parameter.getName());
	}

}