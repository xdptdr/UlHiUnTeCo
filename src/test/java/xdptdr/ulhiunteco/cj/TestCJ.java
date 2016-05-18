package xdptdr.ulhiunteco.cj;

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

public class TestCJ extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar1Name = "bar1Name";
	private String bar2Name = "bar2Name";

	private Long foo1Id;
	private Long foo2Id;
	private Long bar1Id;
	private Long bar2Id;

	public TestCJ() {
		super(new Class<?>[] { BarCJ.class, FooCJ.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCJ foo1 = new FooCJ(foo1Name);
			FooCJ foo2 = new FooCJ(foo2Name);
			BarCJ bar1 = new BarCJ(bar1Name);
			BarCJ bar2 = new BarCJ(bar2Name);
			foo1.addBar(bar1);
			foo1.addBar(bar2);
			foo2.addBar(bar1);
			foo2.addBar(bar2);
			session.save(foo1);
			session.save(foo2);
			foo1Id = (Long) session.getIdentifier(foo1);
			foo2Id = (Long) session.getIdentifier(foo2);
			bar1Id = (Long) session.getIdentifier(bar1);
			bar2Id = (Long) session.getIdentifier(bar2);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(foo1Id);
		Assert.assertNotNull(foo2Id);
		Assert.assertNotNull(bar1Id);
		Assert.assertNotNull(bar2Id);
	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_CJ"));
		tableOutputStream.println(dumpTable("ulhiunteco.BAR_CJ"));
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_BAR_CJ"));
	}

}