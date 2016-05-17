package xdptdr.ulhiunteco.cq;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestCQ extends AbstractTest {

	private String foo1Name = "foo1Name";
	private String foo2Name = "foo2Name";
	private String bar1Name = "bar1Name";
	private String bar2Name = "bar2Name";

	private Long foo1Id;
	private Long foo2Id;
	private Long bar1Id;
	private Long bar2Id;

	private Long key11 = 7L;
	private Long key12 = 13L;
	private Long key21 = 17L;
	private Long key22 = 23L;

	public TestCQ() {
		super(new Class<?>[] { BarCQ.class, FooCQ.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			FooCQ foo1 = new FooCQ(foo1Name);
			FooCQ foo2 = new FooCQ(foo2Name);

			BarCQ bar1 = new BarCQ(bar1Name);
			BarCQ bar2 = new BarCQ(bar2Name);

			foo1.addBar(key11, bar1);
//			foo1.addBar(key12, bar2);
//			foo2.addBar(key21, bar1);
			foo2.addBar(key22, bar2);

			session.save(bar1);
			session.save(bar2);
			session.save(foo1);
			session.save(foo2);

//			foo1Id = (Long) session.getIdentifier(foo1);
//			foo2Id = (Long) session.getIdentifier(foo2);
//			bar1Id = (Long) session.getIdentifier(bar1);
//			bar2Id = (Long) session.getIdentifier(bar2);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

//		Assert.assertNotNull(foo1Id);
//		Assert.assertNotNull(foo2Id);
//		Assert.assertNotNull(bar1Id);
//		Assert.assertNotNull(bar2Id);
	}

	@Test
	public void testCreate() {
		create();
	}

}