package xdptdr.ulhiunteco.bg;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestBG extends AbstractTest {

	private final static String userIdentityName = "userIdentityName";
	private final static String userIncrementName = "userIncrementName";
	private final static String userTableName = "userTableName";
	private final static String userHiloName = "userHiloName";
	private final static String userSeqHiloName = "userSeqHiloName";
	private final static String userSequenceName = "userSequenceName";
	private final static String userSelectName = "userSelectName";
	private final static String userGUIDName = "userGUIDName";
	private final static String userUUIDHexName = "userUUIDHexName";

	private Long userIdentityId;
	private Long userIncrementId;
	private Long userTableId;
	private Long userHiloId;
	private Long userSeqHiloId;
	private Long userSequenceId;
	private Long userSelectId;
	private Long userGUIDId;
	private Long userUUIDHexId;

	public TestBG() {
		super(null);
	}

	@Override
	protected void customizeSetup(Configuration configuration) {
		DBType type = getType();

		if (type == DBType.MYSQL) {
			configuration.addAnnotatedClass(UserIdentityBF.class);
			configuration.addAnnotatedClass(UserIncrementBF.class);
			configuration.addAnnotatedClass(UserTableBF.class);
			configuration.addAnnotatedClass(UserHiloBF.class);
			configuration.addAnnotatedClass(UserSeqHiloBF.class);
		}
		if (type == DBType.IMPOSSIBLE) {
			configuration.addAnnotatedClass(UserSequenceBF.class);
			configuration.addAnnotatedClass(UserSelectBF.class);
			configuration.addAnnotatedClass(UserGUIDBF.class);
			configuration.addAnnotatedClass(UserUUIDHexBF.class);
		}

	}

	private void create() {

		DBType type = getType();

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			UserIdentityBF userIdentity = null;
			UserIncrementBF userIncrement = null;
			UserTableBF userTable = null;
			UserHiloBF userHilo = null;
			UserSeqHiloBF userSeqHilo = null;
			UserSequenceBF userSequence = null;
			UserSelectBF userSelect = null;
			UserGUIDBF userGUID = null;
			UserUUIDHexBF userUUIDHex = null;

			if (type == DBType.MYSQL) {
				userIdentity = new UserIdentityBF(userIdentityName);
				userIncrement = new UserIncrementBF(userIncrementName);
				userTable = new UserTableBF(userTableName);
				userHilo = new UserHiloBF(userHiloName);
				userSeqHilo = new UserSeqHiloBF(userSeqHiloName);
			}
			if (type == DBType.IMPOSSIBLE) {
				userSequence = new UserSequenceBF(userSequenceName);
				userSelect = new UserSelectBF(userSelectName);
				userGUID = new UserGUIDBF(userGUIDName);
				userUUIDHex = new UserUUIDHexBF(userUUIDHexName);
			}

			if (type == DBType.MYSQL) {
				session.save(userIdentity);
				session.save(userIncrement);
				session.save(userTable);
				session.save(userHilo);
				session.save(userSeqHilo);
			}
			if (type == DBType.IMPOSSIBLE) {
				session.save(userSequence);
				session.save(userSelect);
				session.save(userGUID);
				session.save(userUUIDHex);
			}

			if (type == DBType.MYSQL) {
				userIdentityId = (Long) session.getIdentifier(userIdentity);
				userIncrementId = (Long) session.getIdentifier(userIncrement);
				userTableId = (Long) session.getIdentifier(userTable);
				userHiloId = (Long) session.getIdentifier(userHilo);
				userSeqHiloId = (Long) session.getIdentifier(userSeqHilo);
			}
			if (type == DBType.IMPOSSIBLE) {
				userSequenceId = (Long) session.getIdentifier(userSequence);
				userSelectId = (Long) session.getIdentifier(userSelect);
				userGUIDId = (Long) session.getIdentifier(userGUID);
				userUUIDHexId = (Long) session.getIdentifier(userUUIDHex);
			}
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (type == DBType.MYSQL) {
			Assert.assertNotNull(userIdentityId);
			Assert.assertNotNull(userIncrementId);
			Assert.assertNotNull(userTableId);
			Assert.assertNotNull(userHiloId);
			Assert.assertNotNull(userSeqHiloId);
		}
		if (type == DBType.IMPOSSIBLE) {
			Assert.assertNotNull(userSequenceId);
			Assert.assertNotNull(userSelectId);
			Assert.assertNotNull(userGUIDId);
			Assert.assertNotNull(userUUIDHexId);
		}
	}

	@Test
	public void testCreate() {
		create();
	}

}