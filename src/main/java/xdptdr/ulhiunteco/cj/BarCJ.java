package xdptdr.ulhiunteco.cj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CJ")
public class BarCJ {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public BarCJ() {
	}

	public BarCJ(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
