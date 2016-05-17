package xdptdr.ulhiunteco.cc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.cc.BarCC;
import xdptdr.ulhiunteco.cc.FooCC;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestCC extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar2Name = "bar2Name";
	private Long foo2Id;
	private Long bar2Id;

	public TestCC() {
		super(new Class<?>[] { FooCC.class, BarCC.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCC foo1 = new FooCC(foo1Name);
			FooCC foo2 = new FooCC(foo2Name);
			BarCC bar2 = new BarCC(bar2Name);
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
		Assert.assertEquals(foo2Id, bar2Id);
	}

	@Test
	public void testCreate() {
		create();
	}

}