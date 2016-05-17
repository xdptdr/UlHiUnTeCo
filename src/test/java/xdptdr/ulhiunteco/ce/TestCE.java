package xdptdr.ulhiunteco.ce;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestCE extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar2Name = "bar2Name";
	private Long foo2Id;
	private Long bar2Id;

	public TestCE() {
		super(new Class<?>[] { FooCE.class, BarCE.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCE foo1 = new FooCE(foo1Name);
			FooCE foo2 = new FooCE(foo2Name);
			BarCE bar2 = new BarCE(bar2Name);
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

}