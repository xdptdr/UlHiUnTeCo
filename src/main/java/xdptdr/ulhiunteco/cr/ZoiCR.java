package xdptdr.ulhiunteco.cr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ZOI_CR")
public class ZoiCR {
	
	@Id
	@GeneratedValue
	@Column(name = "ZOI_ID")
	private Long zoiId;

	@Column(name = "NAME")
	private String name;

	public ZoiCR() {
	}

	public ZoiCR(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((zoiId == null) ? 0 : zoiId.hashCode());
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
		ZoiCR other = (ZoiCR) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (zoiId == null) {
			if (other.zoiId != null)
				return false;
		} else if (!zoiId.equals(other.zoiId))
			return false;
		return true;
	}
	
	

}
