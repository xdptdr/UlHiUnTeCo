package xdptdr.ulhiunteco.co;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ZOI_CO")
public class ZoiCO {

	@Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "FOO_ID")
		Long fooId;

		@Column(name = "BAR_ID")
		Long barId;

		public Id() {
		}

		public Id(Long fooId, Long barId) {
			this.fooId = fooId;
			this.barId = barId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((barId == null) ? 0 : barId.hashCode());
			result = prime * result + ((fooId == null) ? 0 : fooId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (barId == null) {
				if (other.barId != null)
					return false;
			} else if (!barId.equals(other.barId))
				return false;
			if (fooId == null) {
				if (other.fooId != null)
					return false;
			} else if (!fooId.equals(other.fooId))
				return false;
			return true;
		}

	}

	@EmbeddedId
	private Id id = new Id();

	@ManyToOne
	@JoinColumn(name = "FOO_ID", insertable = false, updatable = false)
	private FooCO foo;

	@ManyToOne
	@JoinColumn(name = "BAR_ID", insertable = false, updatable = false)
	private BarCO bar;

	@Column(name = "DATA")
	private String data;

	public ZoiCO() {
	}

	public ZoiCO(FooCO foo, BarCO bar, String data) {
		this.foo = foo;
		this.bar = bar;
		this.data = data;
		this.id.fooId = foo.getId();
		this.id.barId = bar.getId();
		foo.getZois().add(this);
		bar.getZois().add(this);
	}

	public FooCO getFoo() {
		return foo;
	}

	public void setFoo(FooCO foo) {
		this.foo = foo;
	}

	public BarCO getBar() {
		return bar;
	}

	public void setBar(BarCO bar) {
		this.bar = bar;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
