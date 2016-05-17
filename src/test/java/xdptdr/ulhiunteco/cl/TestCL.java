package xdptdr.ulhiunteco.cl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.cl.BarCL;
import xdptdr.ulhiunteco.cl.FooCL;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestCL extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar1Name = "bar1Name";
	private String bar2Name = "bar2Name";

	private Long foo1Id;
	private Long foo2Id;
	private Long bar1Id;
	private Long bar2Id;

	public TestCL() {
		super(new Class<?>[] { BarCL.class, FooCL.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCL foo1 = new FooCL(foo1Name);
			FooCL foo2 = new FooCL(foo2Name);
			BarCL bar1 = new BarCL(bar1Name);
			BarCL bar2 = new BarCL(bar2Name);
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

}