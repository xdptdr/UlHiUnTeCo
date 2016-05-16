package xdptdr.ulhiunteco.bf;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBF extends AbstractTest {

	private String userOnGettersName = "userOnGettersName";
	private String userOnGettersPrefix = "userOnGettersPrefix";

	private String userOnFieldsName = "userOnFieldsName";
	private String userOnFieldsPrefix = "userOnFieldsPrefix";

	private Long userOnGettersId;
	private Long userOnFieldsId;

	public TestBF() {
		super(new Class<?>[] { UserOnGettersBF.class, UserOnFieldsBF.class });
	}

	private void create() {

		UserOnGettersBF userOnGetters = null;
		UserOnFieldsBF userOnFields = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			userOnGetters = new UserOnGettersBF(userOnGettersName, userOnGettersPrefix);
			userOnFields = new UserOnFieldsBF(userOnFieldsName, userOnFieldsPrefix);
			session.save(userOnGetters);
			session.save(userOnFields);
			userOnGettersId = (Long) session.getIdentifier(userOnGetters);
			userOnFieldsId = (Long) session.getIdentifier(userOnFields);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(userOnGettersId);
		Assert.assertNotNull(userOnFieldsId);
		Assert.assertEquals(userOnFields.getName(), userOnFieldsPrefix + userOnFieldsName);
	}

	@Test
	public void testCreate() {
		create();
	}

	/*
	 * Demonstrate that although we write the same code for insertion and query
	 * prefix has been applied twice on userOnGetters, but once on userOnFields
	 * Therefore, Hibernate did use the getter for userOnGetters but not for
	 * userOnFields when persisting the data
	 */
	@Test
	public void testQuery() {
		create();

		UserOnGettersBF gottenUserOnGetters = null;
		UserOnFieldsBF gottenUserOnFields = null;
		String gottenUserOnGettersName = null;
		String gottenUserOnFieldsName = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenUserOnGetters = (UserOnGettersBF) session.get(UserOnGettersBF.class, userOnGettersId);
			gottenUserOnGettersName = gottenUserOnGetters.getName();
			gottenUserOnFields = (UserOnFieldsBF) session.get(UserOnFieldsBF.class, userOnFieldsId);
			gottenUserOnFieldsName = gottenUserOnFields.getName();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		Assert.assertNotNull(userOnGettersId);
		Assert.assertNotNull(userOnFieldsId);
		Assert.assertEquals(userOnGettersPrefix + userOnGettersPrefix + userOnGettersName, gottenUserOnGettersName);
		Assert.assertEquals(userOnFieldsPrefix + userOnFieldsName, gottenUserOnFieldsName);
	}

}