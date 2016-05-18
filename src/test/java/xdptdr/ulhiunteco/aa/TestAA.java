package xdptdr.ulhiunteco.aa;

import java.io.PrintStream;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * <p>
 * AA is the most basic persistence case. It inserts a single entity in the
 * database that has a String parameter and an automatically generated id.
 * </p>
 * 
 * <p>
 * This demonstrates basic usage of {@linkplain javax.persistence.Entity},
 * {@linkplain javax.persistence.Id} and
 * {@linkplain javax.persistence.GeneratedValue} annotations
 * </p>
 * 
 * @author xdptdr
 *
 */

public class TestAA extends AbstractTest {

	public TestAA() {
		super(new Class<?>[] { FooAA.class });
	}

	/**
	 * Inserts a single entity then checks that its resulting ID is not null
	 */

	private final String fooName = "fooName";
	Long fooId = null;

	public void create() {

		FooAA foo = new FooAA(fooName);

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(foo);
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
		tableOutputStream.println(dumpTable("ulhiunteco.fooaa"));
	}

}
