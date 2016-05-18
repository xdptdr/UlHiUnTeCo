package xdptdr.ulhiunteco.cr;

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

public class TestCR extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String zoi1Name = "zoi1Name";
	private String zoi2Name = "zoi2Name";
	private String bar1Name = "bar1Name";
	private String bar2Name = "bar2Name";

	private Long foo1Id;
	private Long foo2Id;
	private Long zoi1Id;
	private Long zoi2Id;
	private Long bar1Id;
	private Long bar2Id;

	public TestCR() {
		super(new Class<?>[] { BarCR.class, FooCR.class, ZoiCR.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCR foo1 = new FooCR(foo1Name);
			FooCR foo2 = new FooCR(foo2Name);

			ZoiCR zoi1 = new ZoiCR(zoi1Name);
			ZoiCR zoi2 = new ZoiCR(zoi2Name);

			BarCR bar1 = new BarCR(bar1Name);
			BarCR bar2 = new BarCR(bar2Name);

			foo1.addZoiBar(zoi1, bar1);
			foo1.addZoiBar(zoi2, bar2);
			foo2.addZoiBar(zoi1, bar1);
			foo2.addZoiBar(zoi2, bar2);

			session.save(foo1);
			session.save(foo2);
			session.save(zoi1);
			session.save(zoi2);
			session.save(bar1);
			session.save(bar2);

			foo1Id = (Long) session.getIdentifier(foo1);
			foo2Id = (Long) session.getIdentifier(foo2);
			zoi1Id = (Long) session.getIdentifier(zoi1);
			zoi2Id = (Long) session.getIdentifier(zoi2);
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
		Assert.assertNotNull(zoi1Id);
		Assert.assertNotNull(zoi2Id);
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
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_CR"));
		tableOutputStream.println(dumpTable("ulhiunteco.BAR_CR"));
		tableOutputStream.println(dumpTable("ulhiunteco.ZOI_CR"));
		tableOutputStream.println(dumpTable("ulhiunteco.FOO_ZOI_BAR_CR"));
	}

}