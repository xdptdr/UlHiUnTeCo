package xdptdr.ulhiunteco.cd;

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

public class TestCD extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar2Name = "bar2Name";
	private Long foo2Id;
	private Long bar2Id;

	public TestCD() {
		super(new Class<?>[] { FooCD.class, BarCD.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCD foo1 = new FooCD(foo1Name);
			FooCD foo2 = new FooCD(foo2Name);
			BarCD bar2 = new BarCD(bar2Name);
			foo2.setBar(bar2);
			bar2.setFoo(foo2);
			session.save(foo1);
			session.save(foo2);
			foo2Id = (Long) session.getIdentifier(foo2);
			bar2Id = (Long) session.getIdentifier(bar2);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(foo2Id);
		Assert.assertNotNull(bar2Id);
		Assert.assertNotEquals(foo2Id, bar2Id);
	}

	@Test
	public void testCreate() {
		create();
	}
	
	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_CD"));
		tableOutputStream.println(dumpTable("ulhiunteco.BAR_CD"));
	}

}