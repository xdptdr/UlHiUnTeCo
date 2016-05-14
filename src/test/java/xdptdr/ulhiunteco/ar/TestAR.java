package xdptdr.ulhiunteco.ar;

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

public class TestAR extends AbstractTest {

	/**
	 * @author xdptdr
	 */

	public TestAR() {
		super(new Class<?>[] { BookAR.class, ChapterAR.class });
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

		Set<ChapterAR> chapters1 = new HashSet<ChapterAR>();
		BookAR book1 = new BookAR(name1, chapters1);
		
		Set<ChapterAR> chapters2 = new HashSet<ChapterAR>();
		BookAR book2 = new BookAR(name2, chapters2);
		chapters1.add(new ChapterAR(chapterTitle1));
		chapters1.add(new ChapterAR(chapterTitle2));
		chapters1.add(new ChapterAR(chapterTitle3));
		chapters2.add(new ChapterAR(chapterTitle4));
		chapters2.add(new ChapterAR(chapterTitle5));
		chapters2.add(new ChapterAR(chapterTitle5));


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