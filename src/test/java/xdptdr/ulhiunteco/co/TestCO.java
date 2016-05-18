package xdptdr.ulhiunteco.co;

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

public class TestCO extends AbstractTest {

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

	public TestCO() {
		super(new Class<?>[] { BarCO.class, FooCO.class, ZoiCO.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCO foo1 = new FooCO(foo1Name);
			FooCO foo2 = new FooCO(foo2Name);
			BarCO bar1 = new BarCO(bar1Name);
			BarCO bar2 = new BarCO(bar2Name);

			session.save(foo1);
			session.save(foo2);
			session.save(bar1);
			session.save(bar2);

			ZoiCO zoi11 = new ZoiCO(foo1, bar1, zoi11Data);
			ZoiCO zoi12 = new ZoiCO(foo1, bar2, zoi12Data);
			ZoiCO zoi21 = new ZoiCO(foo2, bar1, zoi21Data);
			ZoiCO zoi22 = new ZoiCO(foo2, bar2, zoi22Data);

			session.save(zoi11);
			session.save(zoi12);
			session.save(zoi21);
			session.save(zoi22);

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
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_CO"));
		tableOutputStream.println(dumpTable("ulhiunteco.BAR_CO"));
		tableOutputStream.println(dumpTable("ulhiunteco.ZOI_CO"));
	}

}