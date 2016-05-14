package xdptdr.ulhiunteco.at;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAT extends AbstractTest {

	/**
	 * @author xdptdr
	 */

	public static class Foo implements Serializable {

		private static final long serialVersionUID = 3141592L;

		private String str;

		public Foo() {
		}

		public Foo(String str) {
			this.str = str;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

	}

	public TestAT() {
		super(new Class<?>[] { TypologyAT.class });
	}

	@Test
	public void testCreate() throws MalformedURLException {

		Long tatId = null;

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();

			BigDecimal a = new BigDecimal(5);
			byte[] c = new byte[] { 0 };
			BigInteger b = new BigInteger(c);
			Blob d = Hibernate.getLobCreator(session).createBlob(new byte[] { 0 });
			boolean e = false;
			byte f = 0;
			Calendar g = Calendar.getInstance();
			Calendar h = g;

			char[] i = new char[] { 'a' };
			Character j = new Character(i[0]);
			Character[] j2 = new Character[] { j };
			Class<?> k = this.getClass();
			Clob l = Hibernate.getLobCreator(session).createClob("string");
			Currency m = Currency.getInstance(Locale.JAPAN);
			Date n = h.getTime();
			Double o = 3.14D;
			Float p = 3.14F;
			byte[] q = new byte[] { 0 };
			Integer r = 7;
			Locale s = Locale.JAPAN;
			Long t = 7L;
			byte[] u = new byte[] { 0 };
			String v = "string";
			String w = "string";
			NClob x = Hibernate.getLobCreator(session).createNClob("string");
			String y = "string";
			Boolean z = true;
			Serializable aa = new Foo("string");
			Short ab = 7;
			String ac = "string";
			String ad = "string";
			Date ae = n;
			Date af = n;
			TimeZone ag = TimeZone.getDefault();
			Boolean ah = true;
			URL ai = new URL("https://github.com/xdptdr/UlHiUnTeCo");
			UUID aj = UUID.randomUUID();
			UUID ak = aj;
			Byte[] al = new Byte[] { new Byte(q[0]) };
			Boolean am = true;
			TypologyAT tat = new TypologyAT(a, b, c, d, e, f, g, h, i, j, j2, k, l, m, n, o, p, q, r, s, t, u, v, w, x,
					y, z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am);

			session.saveOrUpdate(tat);
			tatId = tat.getId();
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		Assert.assertNotNull(tatId);
	}

}