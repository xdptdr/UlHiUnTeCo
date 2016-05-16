package xdptdr.ulhiunteco.cb;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "B_CB")
public class BCB {

	@Id
	@GeneratedValue
	@Column(name = "ID_B")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "a")
	private Set<ACB> as = new HashSet<>();

	public BCB() {
	}

	public BCB(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ACB> getAs() {
		return as;
	}

	public void setAs(Set<ACB> acas) {
		this.as = acas;
	}

	public void addA(ACB a) {
		a.setB(this);
		as.add(a);
	}
}
