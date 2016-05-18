package xdptdr.ulhiunteco.bf;

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

public class TestBF extends AbstractTest {

	private String fooOnGettersName = "fooOnGettersName";
	private String fooOnGettersPrefix = "fooOnGettersPrefix";

	private String fooOnFieldsName = "fooOnFieldsName";
	private String fooOnFieldsPrefix = "fooOnFieldsPrefix";

	private Long fooOnGettersId;
	private Long fooOnFieldsId;

	public TestBF() {
		super(new Class<?>[] { FooOnGettersBF.class, FooOnFieldsBF.class });
	}

	private void create() {

		FooOnGettersBF fooOnGetters = null;
		FooOnFieldsBF fooOnFields = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			fooOnGetters = new FooOnGettersBF(fooOnGettersName, fooOnGettersPrefix);
			fooOnFields = new FooOnFieldsBF(fooOnFieldsName, fooOnFieldsPrefix);
			session.save(fooOnGetters);
			session.save(fooOnFields);
			fooOnGettersId = (Long) session.getIdentifier(fooOnGetters);
			fooOnFieldsId = (Long) session.getIdentifier(fooOnFields);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(fooOnGettersId);
		Assert.assertNotNull(fooOnFieldsId);
		Assert.assertEquals(fooOnFields.getName(), fooOnFieldsPrefix + fooOnFieldsName);
	}

	@Test
	public void testCreate() {
		create();
	}

	/*
	 * Demonstrate that although we write the same code for insertion and query
	 * prefix has been applied twice on fooOnGetters, but once on fooOnFields
	 * Therefore, Hibernate did use the getter for fooOnGetters but not for
	 * fooOnFields when persisting the data
	 */
	@Test
	public void testQuery() {
		create();

		FooOnGettersBF gottenFooOnGetters = null;
		FooOnFieldsBF gottenFooOnFields = null;
		String gottenFooOnGettersName = null;
		String gottenFooOnFieldsName = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenFooOnGetters = (FooOnGettersBF) session.get(FooOnGettersBF.class, fooOnGettersId);
			gottenFooOnGettersName = gottenFooOnGetters.getName();
			gottenFooOnFields = (FooOnFieldsBF) session.get(FooOnFieldsBF.class, fooOnFieldsId);
			gottenFooOnFieldsName = gottenFooOnFields.getName();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(fooOnGettersId);
		Assert.assertNotNull(fooOnFieldsId);
		Assert.assertEquals(fooOnGettersPrefix + fooOnGettersPrefix + fooOnGettersName, gottenFooOnGettersName);
		Assert.assertEquals(fooOnFieldsPrefix + fooOnFieldsName, gottenFooOnFieldsName);
	}
	
	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_ON_GETTERS_BF"));
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_ON_FIELDS_BF"));
	}

}