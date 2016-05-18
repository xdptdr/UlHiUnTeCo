package xdptdr.ulhiunteco.ab;

import java.io.PrintStream;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.ab.FooAB;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * <p>
 * AAAA is a simple refinment of AA
 * </p>
 * 
 * <p>
 * {@link javax.persistence.Table} and {@link javax.persistence.Column}
 * annotations are used to use custom table and column names for the entity
 * table and fields
 * </p>
 * 
 * @author xdptdr
 *
 */

public class TestAB extends AbstractTest {

	public TestAB() {
		super(new Class<?>[] { FooAB.class });
	}

	/**
	 * Inserts a single entity then checks that its resulting ID is not null
	 */

	private final static String fooName = "fooName";
	private Long fooId = null;

	public void create() {

		FooAB foo = new FooAB(fooName);

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(foo);
			fooId = foo.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(fooId);
	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_AB"));
	}
}
