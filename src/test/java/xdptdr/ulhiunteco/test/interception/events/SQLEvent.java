package xdptdr.ulhiunteco.test.interception.events;

public class SQLEvent extends HibernateEvent {

	private String sql;

	public SQLEvent(String sql) {
		this.sql = sql;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public boolean MatchNotNull(HibernateEvent other) {
		if (other == null) {
			return false;
		}
		if (other instanceof SQLEvent) {
			if (((SQLEvent) other).getSql() != this.getSql() && ((SQLEvent) other).getSql() != null) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " [" + sql + "]";
	}

}
