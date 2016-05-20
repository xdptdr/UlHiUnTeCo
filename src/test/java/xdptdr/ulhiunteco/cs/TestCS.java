package xdptdr.ulhiunteco.cs;

import java.io.PrintStream;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;
import xdptdr.ulhiunteco.test.interception.InterceptionAssertor;
import xdptdr.ulhiunteco.test.interception.InterceptionUtils;
import xdptdr.ulhiunteco.test.interception.UlhiuntecoInterceptor;
import xdptdr.ulhiunteco.test.interception.events.HibernateEvent;
import xdptdr.ulhiunteco.test.interception.events.TransactionEvent;
import xdptdr.ulhiunteco.test.interception.events.TransactionEvent.TransactionEventType;

public class TestCS extends AbstractTest {

	private UlhiuntecoInterceptor interceptor;

	public TestCS() {
		super(new Class<?>[] { FooCS.class });
	}

	private final String fooName = "fooName";
	Long fooId = null;

	@Override
	protected void customizeSetup(Configuration configuration) {
		interceptor = new UlhiuntecoInterceptor();
		configuration.setInterceptor(interceptor);
	}

	public void create() {

		FooCS foo = new FooCS(fooName);

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(foo);
			fooId = foo.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(fooId);
	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void testInterceptor() {

		create();

		Assert.assertEquals(9, interceptor.getEvents().size());

		TransactionEvent txe = InterceptionUtils.getFirst(new TransactionEvent(TransactionEventType.AFTER_BEGIN, null),
				interceptor.getEvents());

		HibernateEvent[] expectedEvents = new HibernateEvent[] {
				new TransactionEvent(TransactionEventType.AFTER_BEGIN, txe.getTransaction()),
				new TransactionEvent(TransactionEventType.BEFORE_COMPLETION, txe.getTransaction()),
				new TransactionEvent(TransactionEventType.AFTER_COMPLETION, txe.getTransaction()) };

		InterceptionAssertor.subsequence(expectedEvents, interceptor.getEvents());
		
		System.out.println(InterceptionUtils.getString(interceptor.getEvents(),"\n"));

	}

	@Test
	public void dumpTables() throws SQLException {

		create();

		PrintStream tableOutputStream = getTableOutputStream();
		tableOutputStream.println(dumpTable("ulhiunteco.foocs"));
	}

}
