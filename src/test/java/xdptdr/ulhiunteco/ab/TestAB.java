package xdptdr.ulhiunteco.ab;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.ab.PersonAB;
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

public class TestAB extends AbstractTest {

	public TestAB() {
		super(new Class<?>[] { PersonAB.class });
	}

	/**
	 * Inserts a single entity then checks that its resulting ID is not null
	 */

	@Test
	public void test() {

		String name1 = "name1";
		PersonAB person1 = new PersonAB(name1);

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
