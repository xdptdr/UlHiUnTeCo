package xdptdr.ulhiunteco.af;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAF extends AbstractTest {

	private final static String bookName1 = "bookName1";
	private final static String bookName2 = "bookName2";
	private final static String bookName3 = "bookName3";
	private final static String bookName4 = "bookName4";
	private final static String publisherName1 = "publisherName1";
	private final static String publisherName2 = "publisherName2";

	private Long book1Id = null;
	private Long book2Id = null;
	private Long book3Id = null;
	private Long book4Id = null;
	private Long publisher1Id = null;
	private Long publisher2Id = null;

	public TestAF() {
		super(new Class<?>[] { BookAF.class, PublisherAF.class });
	}

	private void create() {

		PublisherAF publisher1 = new PublisherAF(publisherName1);
		PublisherAF publisher2 = new PublisherAF(publisherName2);
		BookAF book1 = new BookAF(bookName1, publisher1);
		BookAF book2 = new BookAF(bookName2, publisher1);
		BookAF book3 = new BookAF(bookName3, publisher2);
		BookAF book4 = new BookAF(bookName4, publisher2);

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

	@Test
	public void testFetchEarly() {

		create();

		BookAF gottenBook = null;
		String gottenPublisherName = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenBook = (BookAF) session.get(BookAF.class, book1Id);
			gottenPublisherName = gottenBook.getPublisher().getName();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(gottenPublisherName);
	}

	@Test(expected = LazyInitializationException.class)
	public void testFetchLate() {

		create();

		BookAF gottenBook = null;
		String gottenPublisherName = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenBook = (BookAF) session.get(BookAF.class, book1Id);
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		gottenPublisherName = gottenBook.getPublisher().getName();

		Assert.assertNotNull(gottenPublisherName);
	}

}