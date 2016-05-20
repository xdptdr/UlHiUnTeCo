package xdptdr.ulhiunteco.test.interception.events;

import java.io.Serializable;

public class GetEntityEvent extends HibernateEvent {

	private String entityName;
	private Serializable id;
	private Object result;

	public GetEntityEvent(String entityName, Serializable id, Object result) {
		this.entityName = entityName;
		this.id = id;
		this.result = result;
	}

	public String getEntityName() {
		return entityName;
	}

	public Serializable getId() {
		return id;
	}

	public Object getResult() {
		return result;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof GetEntityEvent) {
			if (((GetEntityEvent) other).getEntityName() != this.getEntityName()
					&& ((GetEntityEvent) other).getEntityName() != null) {
				return false;
			}
			if (((GetEntityEvent) other).getId() != this.getId() && ((GetEntityEvent) other).getId() != null) {
				return false;
			}
			if (((GetEntityEvent) other).getResult() != this.getResult()
					&& ((GetEntityEvent) other).getResult() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
