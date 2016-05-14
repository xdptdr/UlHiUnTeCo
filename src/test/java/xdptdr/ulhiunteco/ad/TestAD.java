package xdptdr.ulhiunteco.ad;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.ad.BookAD;
import xdptdr.ulhiunteco.ad.PublisherAD;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAD extends AbstractTest {

	public TestAD() {
		super(new Class<?>[] { BookAD.class, PublisherAD.class });
	}

	/**
	 * Demonstrates that inserting only the books works now, thanks to the CascadeType
	 */
	@Test
	public void testInsertBookOnly() {

		String bookName1 = "bookName1";
		String bookName2 = "bookName2";
		String bookName3 = "bookName3";
		String bookName4 = "bookName4";
		String publisherName1 = "publisherName1";
		String publisherName2 = "publisherName2";

		PublisherAD publisher1 = new PublisherAD(publisherName1);
		PublisherAD publisher2 = new PublisherAD(publisherName2);
		BookAD book1 = new BookAD(bookName1, publisher1);
		BookAD book2 = new BookAD(bookName2, publisher1);
		BookAD book3 = new BookAD(bookName3, publisher2);
		BookAD book4 = new BookAD(bookName4, publisher2);

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

	/**
	 * Demonstrates that inserting the publishers still works too
	 */
	@Test
	public void testInsertBookAndPublisher() {

		String bookName1 = "bookName1";
		String bookName2 = "bookName2";
		String bookName3 = "bookName3";
		String bookName4 = "bookName4";
		String publisherName1 = "publisherName1";
		String publisherName2 = "publisherName2";

		PublisherAD publisher1 = new PublisherAD(publisherName1);
		PublisherAD publisher2 = new PublisherAD(publisherName2);
		BookAD book1 = new BookAD(bookName1, publisher1);
		BookAD book2 = new BookAD(bookName2, publisher1);
		BookAD book3 = new BookAD(bookName3, publisher2);
		BookAD book4 = new BookAD(bookName4, publisher2);

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
			session.saveOrUpdate(publisher1);
			session.saveOrUpdate(publisher2);
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
