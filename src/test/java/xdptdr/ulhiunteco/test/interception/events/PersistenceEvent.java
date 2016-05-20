package xdptdr.ulhiunteco.test.interception.events;

import java.io.Serializable;

import org.hibernate.type.Type;

public class PersistenceEvent extends HibernateEvent {
	public static enum PersistenceEventType {
		SAVE, LOAD, FIND_DIRTY, FLUSH_DIRTY, DELETE
	}

	private PersistenceEventType type;
	private Object entity;
	private Serializable id;
	private Object[] state;
	private String[] propertyNames;
	private Type[] types;
	private Object[] previousState;
	private int[] result;;

	public PersistenceEvent(PersistenceEventType type, Object entity, Serializable id, Object[] state,
			Object[] previousState, String[] propertyNames, Type[] types, int[] result) {
		this.type = type;
		this.entity = entity;
		this.id = id;
		this.state = state;
		this.previousState = previousState;
		this.propertyNames = propertyNames;
		this.types = types;
		this.result = result;
	}

	public PersistenceEventType getType() {
		return type;
	}

	public Object getEntity() {
		return entity;
	}

	public Serializable getId() {
		return id;
	}

	public Object[] getState() {
		return state;
	}

	public Object[] getPreviousState() {
		return previousState;
	}

	public String[] getPropertyNames() {
		return propertyNames;
	}

	public Type[] getTypes() {
		return types;
	}

	public int[] getResult() {
		return result;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof PersistenceEvent) {
			if (((PersistenceEvent) other).getType() != this.getType()
					&& ((PersistenceEvent) other).getType() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getEntity() != this.getEntity()
					&& ((PersistenceEvent) other).getEntity() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getId() != this.getId() && ((PersistenceEvent) other).getId() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getState() != this.getState()
					&& ((PersistenceEvent) other).getState() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getPropertyNames() != this.getPropertyNames()
					&& ((PersistenceEvent) other).getPropertyNames() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getTypes() != this.getTypes()
					&& ((PersistenceEvent) other).getTypes() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getPreviousState() != this.getPreviousState()
					&& ((PersistenceEvent) other).getPreviousState() != null) {
				return false;
			}
			if (((PersistenceEvent) other).getResult() != this.getResult()
					&& ((GetEntityEvent) other).getResult() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
