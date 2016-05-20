package xdptdr.ulhiunteco.test.interception.events;

import java.util.Iterator;

public class FlushEvent extends HibernateEvent {
	public static enum FlushEventType {
		PRE, POST
	};

	private FlushEventType type;
	@SuppressWarnings("rawtypes")
	private Iterator entities;

	public FlushEvent(FlushEventType type, @SuppressWarnings("rawtypes") Iterator entities) {
		this.type = type;
		this.entities = entities;
	}

	public FlushEventType getType() {
		return type;
	}

	@SuppressWarnings("rawtypes")
	public Iterator getEntities() {
		return entities;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof FlushEvent) {
			if (((FlushEvent) other).getType() != this.getType() && ((FlushEvent) other).getType() != null) {
				return false;
			}
			if (((FlushEvent) other).getEntities() != this.getEntities()
					&& ((FlushEvent) other).getEntities() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

}