package xdptdr.ulhiunteco.test.interception.events;

public class IsTransientEvent extends HibernateEvent {

	private Object entity;

	public IsTransientEvent(Object entity) {
		this.entity = entity;
	}

	public Object getEntity() {
		return entity;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof IsTransientEvent) {
			if (((IsTransientEvent) other).getEntity() != this.getEntity()
					&& ((IsTransientEvent) other).getEntity() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
