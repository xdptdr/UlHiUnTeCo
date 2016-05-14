package xdptdr.ulhiunteco.aa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * <p>AA is the most basic persistence case. It inserts a single entity in the
 * database that has a String parameter and an automatically generated id.</p>
 * 
 * <p>This demonstrates basic usage of {@linkplain javax.persistence.Entity},
 * {@linkplain javax.persistence.Id} and
 * {@linkplain javax.persistence.GeneratedValue} annotations</p>
 * 
 * @author xdptdr
 *
 */

public class TestAA extends AbstractTest {

	public TestAA() {
		super(new Class<?>[] { PersonAA.class });
	}

	/**
	 * Inserts a single entity then checks that its resulting ID is not null
	 */

	@Test
	public void test() {

		String name1 = "name1";
		PersonAA person1 = new PersonAA(name1);

		Long person1Id = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(person1);
			person1Id = person1.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(person1Id);
	}

}
