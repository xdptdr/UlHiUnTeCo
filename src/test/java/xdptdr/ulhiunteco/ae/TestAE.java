package xdptdr.ulhiunteco.ae;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.ae.BookAE;
import xdptdr.ulhiunteco.ae.PublisherAE;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAE extends AbstractTest {

	public TestAE() {
		super(new Class<?>[] { BookAE.class, PublisherAE.class });
	}

	/**
	 * Same with a dedicated join table
	 */
	@Test
	public void testInsertBookOnly() {

		String bookName1 = "bookName1";
		String bookName2 = "bookName2";
		String bookName3 = "bookName3";
		String bookName4 = "bookName4";
		String publisherName1 = "publisherName1";
		String publisherName2 = "publisherName2";

		PublisherAE publisher1 = new PublisherAE(publisherName1);
		PublisherAE publisher2 = new PublisherAE(publisherName2);
		BookAE book1 = new BookAE(bookName1, publisher1);
		BookAE book2 = new BookAE(bookName2, publisher1);
		BookAE book3 = new BookAE(bookName3, publisher2);
		BookAE book4 = new BookAE(bookName4, publisher2);

		Long book1Id = null;
		Long book2Id = null;
		Long book3Id = null;
		Long book4Id = null;
		Long publisher1Id = null;
		Long publisher2Id = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(book1);
			session.saveOrUpdate(book2);
			session.saveOrUpdate(book3);
			session.saveOrUpdate(book4);
			book1Id = book1.getBookId();
			book2Id = book1.getBookId();
			book3Id = book1.getBookId();
			book4Id = book1.getBookId();
			publisher1Id = publisher1.getPublisherId();
			publisher2Id = publisher1.getPublisherId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(book1Id);
		Assert.assertNotNull(book2Id);
		Assert.assertNotNull(book3Id);
		Assert.assertNotNull(book4Id);
		Assert.assertNotNull(publisher1Id);
		Assert.assertNotNull(publisher2Id);
	}

}