package xdptdr.ulhiunteco.as;

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

public class TestAS extends AbstractTest {

	/**
	 * @author xdptdr
	 */

	public TestAS() {
		super(new Class<?>[] { BookAS.class, ChapterAS.class });
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

		Set<ChapterAS> chapters1 = new HashSet<ChapterAS>();
		BookAS book1 = new BookAS(name1, chapters1);

		Set<ChapterAS> chapters2 = new HashSet<ChapterAS>();
		BookAS book2 = new BookAS(name2, chapters2);
		chapters1.add(new ChapterAS(chapterTitle1));
		chapters1.add(new ChapterAS(chapterTitle2));
		chapters1.add(new ChapterAS(chapterTitle3));
		chapters2.add(new ChapterAS(chapterTitle4));
		chapters2.add(new ChapterAS(chapterTitle5));
		chapters2.add(new ChapterAS(chapterTitle5));

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