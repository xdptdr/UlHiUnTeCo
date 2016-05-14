package xdptdr.ulhiunteco.ac;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransientObjectException;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.ac.BookAC;
import xdptdr.ulhiunteco.ac.PublisherAC;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAC extends AbstractTest {

	public TestAC() {
		super(new Class<?>[] { BookAC.class, PublisherAC.class });
	}

	/**
	 * Demonstrates that inserting only the books fails
	 */
	@Test(expected = TransientObjectException.class)
	public void testInsertBookOnly() {

		String bookName1 = "bookName1";
		String bookName2 = "bookName2";
		String bookName3 = "bookName3";
		String bookName4 = "bookName4";
		String publisherName1 = "publisherName1";
		String publisherName2 = "publisherName2";

		PublisherAC publisher1 = new PublisherAC(publisherName1);
		PublisherAC publisher2 = new PublisherAC(publisherName2);
		BookAC book1 = new BookAC(bookName1, publisher1);
		BookAC book2 = new BookAC(bookName2, publisher1);
		BookAC book3 = new BookAC(bookName3, publisher2);
		BookAC book4 = new BookAC(bookName4, publisher2);

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
	 * Demonstrates that the publishers must be inserted too
	 */
	@Test
	public void testInsertBookAndPublisher() {

		String bookName1 = "bookName1";
		String bookName2 = "bookName2";
		String bookName3 = "bookName3";
		String bookName4 = "bookName4";
		String publisherName1 = "publisherName1";
		String publisherName2 = "publisherName2";

		PublisherAC publisher1 = new PublisherAC(publisherName1);
		PublisherAC publisher2 = new PublisherAC(publisherName2);
		BookAC book1 = new BookAC(bookName1, publisher1);
		BookAC book2 = new BookAC(bookName2, publisher1);
		BookAC book3 = new BookAC(bookName3, publisher2);
		BookAC book4 = new BookAC(bookName4, publisher2);

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
