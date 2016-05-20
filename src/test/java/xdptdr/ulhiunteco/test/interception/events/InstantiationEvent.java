package xdptdr.ulhiunteco.test.interception.events;

import java.io.Serializable;

import org.hibernate.EntityMode;

public class InstantiationEvent extends HibernateEvent {

	private String entityName;
	private EntityMode entityMode;
	private Serializable id;
	private Object result;

	public InstantiationEvent(String entityName, EntityMode entityMode, Serializable id, Object result) {
		this.entityName = entityName;
		this.entityMode = entityMode;
		this.id = id;
		this.result = result;
	}

	public String getEntityName() {
		return entityName;
	}

	public EntityMode getEntityMode() {
		return entityMode;
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
		if (other instanceof InstantiationEvent) {
			if (((InstantiationEvent) other).getEntityName() != this.getEntityName()
					&& ((InstantiationEvent) other).getEntityName() != null) {
				return false;
			}
			if (((InstantiationEvent) other).getEntityMode() != this.getEntityMode()
					&& ((InstantiationEvent) other).getEntityMode() != null) {
				return false;
			}
			if (((InstantiationEvent) other).getId() != this.getId() && ((InstantiationEvent) other).getId() != null) {
				return false;
			}
			if (((InstantiationEvent) other).getResult() != this.getResult()
					&& ((InstantiationEvent) other).getResult() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
