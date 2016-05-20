package xdptdr.ulhiunteco.test.interception;

import java.util.List;

import xdptdr.ulhiunteco.test.interception.events.HibernateEvent;

public class InterceptionUtils {

	@SuppressWarnings("unchecked")
	public static <T extends HibernateEvent> T getFirst(T wanted, List<HibernateEvent> events) {
		for (HibernateEvent event : events) {
			if (event.MatchNotNull(wanted)) {
				return (T) event;
			}
		}
		throw new AssertionError("No such event");

	}

	public static String getString(List<HibernateEvent> events, String separator) {

		if (separator == null) {
			separator = ", ";
		}

		StringBuffer buf = new StringBuffer();
		boolean sep = false;
		for (HibernateEvent event : events) {
			if (sep) {
				buf.append(separator);
			}
			buf.append(event.toString());
			sep = true;
		}
		return buf.toString();
	}

	public static String getString(HibernateEvent[] events, String separator) {

		if (separator == null) {
			separator = ", ";
		}

		StringBuffer buf = new StringBuffer();
		boolean sep = false;
		for (HibernateEvent event : events) {
			if (sep) {
				buf.append(separator);
			}
			buf.append(event.toString());
			sep = true;
		}
		return buf.toString();
	}

}
