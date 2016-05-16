package xdptdr.ulhiunteco.bz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "B_BZ")
public class BBZ {

	@Id
	@GeneratedValue
	@Column(name = "ID_B")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public BBZ() {
	}

	public BBZ(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
