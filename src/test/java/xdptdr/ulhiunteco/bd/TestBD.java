package xdptdr.ulhiunteco.bd;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBD extends AbstractTest {

	private static final String message2Text = "message2";
	private static final String message1Text = "message1";
	private Long message1Id;

	public TestBD() {
		super(new Class<?>[] { MessageBD.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			MessageBD message1 = new MessageBD(message1Text);
			message1.setNextMessage(new MessageBD(message2Text));
			session.save(message1);
			message1Id = message1.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testCreate() {
		create();
	}

	@Test
	public void testQuery() {

		create();
		
		String gottenMessage1Text;
		String gottenMessage2Text;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			MessageBD message1 = (MessageBD) session.get(MessageBD.class, message1Id);
			gottenMessage1Text = message1.getText();
			gottenMessage2Text = message1.getNextMessage().getText();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		Assert.assertEquals(message1Text, gottenMessage1Text);
		Assert.assertEquals(message2Text, gottenMessage2Text);
	}

}