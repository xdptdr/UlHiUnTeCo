package xdptdr.ulhiunteco.cp;

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

public class TestCP extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar1Name = "bar1Name";
	private String bar2Name = "bar2Name";

	private Long foo1Id;
	private Long foo2Id;
	private Long bar1Id;
	private Long bar2Id;
	private String zoi11Data = "zoi11Data";
	private String zoi12Data = "zoi12Data";
	private String zoi21Data = "zoi21Data";
	private String zoi22Data = "zoi22Data";

	public TestCP() {
		super(new Class<?>[] { BarCP.class, FooCP.class, ZoiCP.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCP foo1 = new FooCP(foo1Name);
			FooCP foo2 = new FooCP(foo2Name);
			BarCP bar1 = new BarCP(bar1Name);
			BarCP bar2 = new BarCP(bar2Name);

			
			
			ZoiCP zoi11 = new ZoiCP(foo1, bar1, zoi11Data);
			ZoiCP zoi12 = new ZoiCP(foo1, bar2, zoi12Data);
			foo1.getZois().add(zoi11);
			foo1.getZois().add(zoi12);
			
			ZoiCP zoi21 = new ZoiCP(foo2, bar1, zoi21Data);
			ZoiCP zoi22 = new ZoiCP(foo2, bar2, zoi22Data);
			foo2.getZois().add(zoi21);
			foo2.getZois().add(zoi22);
			
			session.save(foo1);
			session.save(foo2);
			session.save(bar1);
			session.save(bar2);
			

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
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_CP"));
		tableOutputStream.println(dumpTable("ulhiunteco.BAR_CP"));
		tableOutputStream.println(dumpTable("ulhiunteco.ZOI_CP"));
	}

}