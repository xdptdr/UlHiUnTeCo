package xdptdr.ulhiunteco.test.interception.events;

import java.io.Serializable;

public class CollectionEvent extends HibernateEvent {

	public static enum CollectionEventType {
		RECREATE, UPDATE, REMOVE
	}

	private CollectionEventType type;
	private Object collection;
	private Serializable key;;

	public CollectionEvent(CollectionEventType recreate, Object collection, Serializable key) {
		this.type = recreate;
		this.collection = collection;
		this.key = key;
	}

	public CollectionEventType getType() {
		return type;
	}

	public Object getCollection() {
		return collection;
	}

	public Serializable getKey() {
		return key;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof CollectionEvent) {
			if (((CollectionEvent) other).getType() != this.getType() && ((CollectionEvent) other).getType() != null) {
				return false;
			}
			if (((CollectionEvent) other).getCollection() != this.getCollection()
					&& ((CollectionEvent) other).getCollection() != null) {
				return false;
			}
			if (((CollectionEvent) other).getKey() != this.getKey() && ((CollectionEvent) other).getKey() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
