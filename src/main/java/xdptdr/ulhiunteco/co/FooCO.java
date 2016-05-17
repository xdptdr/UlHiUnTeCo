package xdptdr.ulhiunteco.co;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Foo_CO")
public class FooCO {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "foo")
	private Set<ZoiCO> zois = new HashSet<>();

	public FooCO() {
	}

	public FooCO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ZoiCO> getZois() {
		return zois;
	}

	public Long getId() {
		return id;
	}

}
