package xdptdr.ulhiunteco.bz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "A_BZ")
public class ABZ {

	@Id
	@GeneratedValue
	@Column(name = "ID_A")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "B_ID", nullable = false)
	private BBZ b;

	public ABZ() {
	}

	public ABZ(String name, BBZ b) {
		this.name = name;
		this.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BBZ getB() {
		return b;
	}

	public void setB(BBZ b) {
		this.b = b;
	}

}
