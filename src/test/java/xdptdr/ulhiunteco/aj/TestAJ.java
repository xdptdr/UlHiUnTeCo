package xdptdr.ulhiunteco.aj;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAJ extends AbstractTest {

	public TestAJ() {
		super(new Class<?>[] { BookAJ.class });
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

		List<String> chapters1 = new ArrayList<String>();
		chapters1.add(chapterTitle1);
		chapters1.add(chapterTitle2);
		chapters1.add(chapterTitle3);
		List<String> chapters2 = new ArrayList<String>();
		chapters2.add(chapterTitle4);
		chapters2.add(chapterTitle5);
		chapters2.add(chapterTitle5);

		BookAJ book1 = new BookAJ(name1, chapters1);
		BookAJ book2 = new BookAJ(name2, chapters2);

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