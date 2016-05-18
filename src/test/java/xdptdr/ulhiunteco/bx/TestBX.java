package xdptdr.ulhiunteco.bx;

import java.io.PrintStream;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBX extends AbstractTest {

	private String parameterName = "parameterName";
	private String parameterValue = "parameterValue";
	private String countryName = "countryName";
	private Integer countryPopulation = 7;
	private String moleculeName = "moleculeName";
	private Integer moleculeMolarMass = 314;

	private Long parameterId;
	private Long countryId;
	private Long moleculeId;

	// single table inheritance with a secondary table

	public TestBX() {
		super(new Class<?>[] { NamedItemBX.class, ParameterBX.class, CountryBX.class, MoleculeBX.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ParameterBX parameter = new ParameterBX(parameterName, parameterValue);
			CountryBX country = new CountryBX(countryName, countryPopulation);
			MoleculeBX molecule = new MoleculeBX(moleculeName, moleculeMolarMass);
			session.save(parameter);
			session.save(country);
			session.save(molecule);
			parameterId = (Long) session.getIdentifier(parameter);
			countryId = (Long) session.getIdentifier(country);
			moleculeId = (Long) session.getIdentifier(molecule);
			moleculeId = (Long) session.getIdentifier(molecule);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(parameterId);
		Assert.assertNotNull(countryId);
		Assert.assertNotNull(moleculeId);

	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.NAMED_ITEM_BX"));
		tableOutputStream.println(dumpTable("ulhiunteco.MOLECULE_BX"));
		tableOutputStream.println(dumpTable("ulhiunteco.hibernate_sequences"));
	}

}