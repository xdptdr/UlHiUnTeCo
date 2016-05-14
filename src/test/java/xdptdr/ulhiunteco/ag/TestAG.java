package xdptdr.ulhiunteco.ag;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAG extends AbstractTest {

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

	public TestAG() {
		super(new Class<?>[] { BookAG.class, PublisherAG.class });
	}

	private void create() {

		PublisherAG publisher1 = new PublisherAG(publisherName1);
		PublisherAG publisher2 = new PublisherAG(publisherName2);
		BookAG book1 = new BookAG(bookName1, publisher1);
		BookAG book2 = new BookAG(bookName2, publisher1);
		BookAG book3 = new BookAG(bookName3, publisher2);
		BookAG book4 = new BookAG(bookName4, publisher2);

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

		BookAG gottenBook = null;
		String gottenPublisherName = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenBook = (BookAG) session.get(BookAG.class, book1Id);
			gottenPublisherName = gottenBook.getPublisher().getName();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(gottenPublisherName);
	}

	@Test
	public void testFetchLate() {

		create();

		BookAG gottenBook = null;
		String gottenPublisherName = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			gottenBook = (BookAG) session.get(BookAG.class, book1Id);
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