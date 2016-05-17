package xdptdr.ulhiunteco.cq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CQ")
public class BarCQ {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long barId;

	@Column(name = "NAME")
	private String name;

	public BarCQ() {
	}

	public BarCQ(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barId == null) ? 0 : barId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BarCQ other = (BarCQ) obj;
		if (barId == null) {
			if (other.barId != null)
				return false;
		} else if (!barId.equals(other.barId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
