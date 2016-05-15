package xdptdr.ulhiunteco.au;

import java.net.MalformedURLException;

import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAU extends AbstractTest {

	public TestAU() {
		super(new Class<?>[] { ColumnologyAU.class });
	}

	@Test(expected=PropertyValueException.class)
	public void testCreate() throws MalformedURLException {

		Long tatId = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			ColumnologyAU cau = new ColumnologyAU();
			session.saveOrUpdate(cau);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(tatId);
	}
	
	@Test
	public void testCreateNotNull() throws MalformedURLException {

		Long cauId = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			ColumnologyAU cau = new ColumnologyAU();
			cau.setNotNnullable("hello");
			session.saveOrUpdate(cau);
			cauId=cau.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(cauId);
	}

}