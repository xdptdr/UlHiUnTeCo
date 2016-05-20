package xdptdr.ulhiunteco.test.interception.events;

import java.lang.reflect.Method;

public abstract class HibernateEvent {

	@Override
	public String toString() {
		try {
			Method getTypeMethod = this.getClass().getMethod("getType");
			if (getTypeMethod != null) {
				return this.getClass().getCanonicalName() + " [" + getTypeMethod.invoke(this) + "]";
			} else {
				return this.getClass().getCanonicalName();
			}
		} catch (Exception ex) {
			return this.getClass().getCanonicalName();
		}
	}

	public abstract boolean MatchNotNull(HibernateEvent other);

}
