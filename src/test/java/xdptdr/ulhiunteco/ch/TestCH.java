package xdptdr.ulhiunteco.ch;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestCH extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar2Name = "bar2Name";
	private Long foo2Id;
	private Long bar2Id;

	public TestCH() {
		super(new Class<?>[] { FooCH.class, BarCH.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCH foo1 = new FooCH(foo1Name);
			FooCH foo2 = new FooCH(foo2Name);
			BarCH bar2 = new BarCH(bar2Name);
			foo2.addBar(bar2);
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

}