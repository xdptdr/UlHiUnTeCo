package xdptdr.ulhiunteco.test.interception;

import java.util.List;

import xdptdr.ulhiunteco.test.interception.events.HibernateEvent;

public class InterceptionAssertor {

	public static void subsequence(HibernateEvent[] expectedEvents, List<HibernateEvent> actualEvents) {
		if (expectedEvents == null || expectedEvents.length == 0) {
			return;
		}

		if (actualEvents == null || actualEvents.size() < expectedEvents.length) {
			throw new AssertionError("Too few actual events");
		}

		int pos = 0;
		for (HibernateEvent event : actualEvents) {
			if (event.MatchNotNull(expectedEvents[pos])) {
				++pos;
			}
		}
		if (pos != expectedEvents.length) {

			throw new AssertionError(
					"Subsequence did not match: expected : {" + InterceptionUtils.getString(expectedEvents, ", ")
							+ "} ; actual : {" + InterceptionUtils.getString(actualEvents, ", ") + "}");
		}

	}

}
