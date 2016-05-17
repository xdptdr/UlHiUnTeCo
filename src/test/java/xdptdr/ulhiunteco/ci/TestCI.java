package xdptdr.ulhiunteco.ci;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestCI extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar2Name = "bar2Name";
	private Long foo2Id;
	private Long bar2Id;

	public TestCI() {
		super(new Class<?>[] { FooCI.class, BarCI.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCI foo1 = new FooCI(foo1Name);
			FooCI foo2 = new FooCI(foo2Name);
			BarCI bar2 = new BarCI(bar2Name);
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