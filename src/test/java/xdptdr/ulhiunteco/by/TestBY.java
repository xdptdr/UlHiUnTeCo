package xdptdr.ulhiunteco.by;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBY extends AbstractTest {

	private String itemName = "itemName";
	private String imageName = "imageName";
	private Integer imageSize = 7;
	private String imageDescription = "imageDescription";

	public TestBY() {
		super(new Class<?>[] { ImageBY.class, ItemBY.class });
	}

	private void create() {

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			ItemBY item = new ItemBY(itemName);
			// item.getCollectionOfImages().add(new ImageBY(imageName,
			// imageSize));
			item.getListOfImageNames().add(imageName);
			item.getMapOfImageNamesToDescriptions().put(imageName, imageDescription);
			item.getSetOfImageNames().add(imageName);
			item.getSetOfImages().add(new ImageBY(imageName, imageSize));
			item.getSortedSetOfImageNames().add(imageName);
			session.save(item);

			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Test
	public void testCreate() {
		create();
	}

}