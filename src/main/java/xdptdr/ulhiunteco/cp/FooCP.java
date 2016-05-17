package xdptdr.ulhiunteco.cp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "Foo_CP")
public class FooCP {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection
	@JoinTable(name = "ZOI_CP", joinColumns = @JoinColumn(name = "FOO_ID"))
	private Set<ZoiCP> zois = new HashSet<>();

	public FooCP() {
	}

	public FooCP(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ZoiCP> getZois() {
		return zois;
	}

}
