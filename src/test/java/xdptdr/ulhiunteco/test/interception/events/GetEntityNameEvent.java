package xdptdr.ulhiunteco.test.interception.events;

public class GetEntityNameEvent extends HibernateEvent {

	private Object object;
	private String result;

	public GetEntityNameEvent(Object object, String result) {
		this.object = object;
		this.result = result;
	}

	public Object getObject() {
		return object;
	}

	public String getResult() {
		return result;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof GetEntityNameEvent) {
			if (((GetEntityNameEvent) other).getObject() != this.getObject()
					&& ((GetEntityNameEvent) other).getObject() != null) {
				return false;
			}
			if (((GetEntityNameEvent) other).getResult() != this.getResult()
					&& ((GetEntityNameEvent) other).getResult() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " [" + result + "]";
	}
}
