package xdptdr.ulhiunteco.aq;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAQ extends AbstractTest {

	/**
	 * @author xdptdr
	 */

	public TestAQ() {
		super(new Class<?>[] { BookAQ.class, ChapterAQ.class });
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

		Set<ChapterAQ> chapters1 = new HashSet<ChapterAQ>();
		BookAQ book1 = new BookAQ(name1, chapters1);
		
		Set<ChapterAQ> chapters2 = new HashSet<ChapterAQ>();
		BookAQ book2 = new BookAQ(name2, chapters2);
		chapters1.add(new ChapterAQ(chapterTitle1, book1));
		chapters1.add(new ChapterAQ(chapterTitle2, book1));
		chapters1.add(new ChapterAQ(chapterTitle3, book1));
		chapters2.add(new ChapterAQ(chapterTitle4, book2));
		chapters2.add(new ChapterAQ(chapterTitle5, book2));
		chapters2.add(new ChapterAQ(chapterTitle5, book2));


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