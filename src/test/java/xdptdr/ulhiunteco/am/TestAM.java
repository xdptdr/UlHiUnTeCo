package xdptdr.ulhiunteco.am;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAM extends AbstractTest {

	public TestAM() {
		super(new Class<?>[] { BookAM.class });
	}

	@Test
	public void testCreate() {

		String name1 = "name1";
		String name2 = "name2";

		String chapterTitleKey1 = "chKey1";
		String chapterTitleKey2 = "chKey2";
		String chapterTitleKey3 = "chKey3";
		String chapterTitleKey4 = "chKey4";
		String chapterTitleKey5 = "chKey5";
		String chapterTitleKey6 = "chKey6";

		String chapterTitle1 = "chapterTitle1";
		String chapterTitle2 = "chapterTitle2";
		String chapterTitle3 = "chapterTitle3";
		String chapterTitle4 = "chapterTitle4";
		String chapterTitle5 = "chapterTitle5";

		Map<String, String> chapters1 = new HashMap<String, String>();
		chapters1.put(chapterTitleKey1, chapterTitle1);
		chapters1.put(chapterTitleKey2, chapterTitle2);
		chapters1.put(chapterTitleKey3, chapterTitle3);

		Map<String, String> chapters2 = new HashMap<String, String>();
		chapters2.put(chapterTitleKey4, chapterTitle4);
		chapters2.put(chapterTitleKey5, chapterTitle5);
		chapters2.put(chapterTitleKey6, chapterTitle5);

		BookAM book1 = new BookAM(name1, chapters1);
		BookAM book2 = new BookAM(name2, chapters2);

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