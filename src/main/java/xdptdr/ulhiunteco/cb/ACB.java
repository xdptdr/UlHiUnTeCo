package xdptdr.ulhiunteco.cb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "A_CB")
public class ACB {

	@Id
	@GeneratedValue
	@Column(name = "ID_A")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "B_ID", nullable = false)
	private BCB b;

	public ACB() {
	}

	public ACB(String name, BCB b) {
		this.name = name;
		this.b = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BCB getB() {
		return b;
	}

	public void setB(BCB b) {
		this.b = b;
	}

}
