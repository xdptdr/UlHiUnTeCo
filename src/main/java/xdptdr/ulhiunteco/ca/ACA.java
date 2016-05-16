package xdptdr.ulhiunteco.ca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "A_CA")
public class ACA {

	@Id
	@GeneratedValue
	@Column(name = "ID_A")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "B_ID", nullable = false)
	private BCA b;

	public ACA() {
	}

	public ACA(String name, BCA b) {
		this.name = name;
		this.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BCA getB() {
		return b;
	}

	public void setB(BCA b) {
		this.b = b;
	}

}
