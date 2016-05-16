package xdptdr.ulhiunteco.be;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBE extends AbstractTest {

	private String userName1 = "userName1";
	private String billingStreet1 = "billingStreet1";
	private String billingZipcode1 = "billingZipcode1";
	private String billingCity1 = "billingCity1";
	private String homeStreet1 = "homeStreet1";
	private String homeZipCode1 = "homeZipCode1";
	private String homeCity1 = "homeCity1";

	private String userName2 = "userName2";
	private String billingStreet2 = "billingStreet2";
	private String billingZipcode2 = "billingZipcode2";
	private String billingCity2 = "billingCity2";
	private String homeStreet2 = "homeStreet2";
	private String homeZipCode2 = "homeZipCode2";
	private String homeCity2 = "homeCity2";

	private Long user1Id;
	private Long user2Id;

	public TestBE() {
		super(new Class<?>[] { UserBE.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			UserBE user1 = new UserBE(userName1, billingStreet1, billingZipcode1, billingCity1, homeStreet1,
					homeZipCode1, homeCity1);
			UserBE user2 = new UserBE(userName2, billingStreet2, billingZipcode2, billingCity2, homeStreet2,
					homeZipCode2, homeCity2);
			session.save(user1);
			session.save(user2);
			user1Id = (Long) session.getIdentifier(user1);
			user2Id = (Long) session.getIdentifier(user2);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(user1Id);
		Assert.assertNotNull(user2Id);
		Assert.assertNotEquals(user1Id, user2Id);
	}

	@Test
	public void testCreate() {
		create();
	}

}