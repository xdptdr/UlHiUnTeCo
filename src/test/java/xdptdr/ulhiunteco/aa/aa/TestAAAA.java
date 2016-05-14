package xdptdr.ulhiunteco.aa.aa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * <p>
 * AAAA is a simple refinment of AA
 * </p>
 * 
 * <p>
 * {@link javax.persistence.Table} and {@link javax.persistence.Column}
 * annotations are used to use custom table and column names for the entity
 * table and fields
 * </p>
 * 
 * @author xdptdr
 *
 */

public class TestAAAA extends AbstractTest {

	public TestAAAA() {
		super(new Class<?>[] { PersonAAAA.class });
	}

	/**
	 * Inserts a single entity then checks that its resulting ID is not null
	 */

	@Test
	public void test() {

		String name1 = "name1";
		PersonAAAA person1 = new PersonAAAA(name1);

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
