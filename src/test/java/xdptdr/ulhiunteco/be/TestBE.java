package xdptdr.ulhiunteco.be;

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

public class TestBE extends AbstractTest {

	private String fooName1 = "fooName1";
	private String fooName2 = "fooName2";

	private Long foo1Id;
	private Long foo2Id;

	public TestBE() {
		super(new Class<?>[] { FooBE.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			FooBE foo1 = new FooBE(fooName1);
			FooBE foo2 = new FooBE(fooName2);
			session.save(foo1);
			session.save(foo2);
			foo1Id = (Long) session.getIdentifier(foo1);
			foo2Id = (Long) session.getIdentifier(foo2);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(foo1Id);
		Assert.assertNotNull(foo2Id);
		Assert.assertNotEquals(foo1Id, foo2Id);
	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_BE"));
	}

}