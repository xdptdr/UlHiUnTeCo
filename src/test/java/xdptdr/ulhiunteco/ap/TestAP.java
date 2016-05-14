package xdptdr.ulhiunteco.ap;

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

public class TestAP extends AbstractTest {

	/**
	 * @author xdptdr
	 */

	public TestAP() {
		super(new Class<?>[] { BookAP.class, ChapterAP.class });
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

		Set<ChapterAP> chapters1 = new HashSet<ChapterAP>();
		chapters1.add(new ChapterAP(chapterTitle1));
		chapters1.add(new ChapterAP(chapterTitle2));
		chapters1.add(new ChapterAP(chapterTitle3));
		Set<ChapterAP> chapters2 = new HashSet<ChapterAP>();
		chapters2.add(new ChapterAP(chapterTitle4));
		chapters2.add(new ChapterAP(chapterTitle5));
		chapters2.add(new ChapterAP(chapterTitle5));

		BookAP book1 = new BookAP(name1, chapters1);
		BookAP book2 = new BookAP(name2, chapters2);

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