package xdptdr.ulhiunteco.ah;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAH extends AbstractTest {

	public TestAH() {
		super(new Class<?>[] { BookAH.class });
	}

	@Test
	public void testCreate() {

		String name1 = "name1";
		String name2 = "name2";

		String chapterTitle1 = "chapterTitle1";
		String chapterTitle2 = "chapterTitle2";
		String chapterTitle3 = "chapterTitle3";
		String chapterTitle4 = "chapterTitle4";
		String chapterTitle5 = "chapterTitle5";

		Set<String> chapters1 = new HashSet<String>();
		chapters1.add(chapterTitle1);
		chapters1.add(chapterTitle2);
		chapters1.add(chapterTitle3);
		Set<String> chapters2 = new HashSet<String>();
		chapters2.add(chapterTitle4);
		chapters2.add(chapterTitle5);

		BookAH book1 = new BookAH(name1, chapters1);
		BookAH book2 = new BookAH(name2, chapters2);

		Long book1Id = null;
		Long book2Id = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(book1);
			session.saveOrUpdate(book2);
			book1Id = book1.getId();
			book2Id = book1.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(book1Id);
		Assert.assertNotNull(book2Id);
	}

}