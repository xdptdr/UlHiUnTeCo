package xdptdr.ulhiunteco.ca;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "B_CA")
public class BCA {

	@Id
	@GeneratedValue
	@Column(name = "ID_B")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy="a")
	private Set<ACA> acas = new HashSet<>();

	public BCA() {
	}

	public BCA(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ACA> getAcas() {
		return acas;
	}

	public void setAcas(Set<ACA> acas) {
		this.acas = acas;
	}

	public void addAca(ACA a) {
		a.setB(this);
		acas.add(a);
	}
}
