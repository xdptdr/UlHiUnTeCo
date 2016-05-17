package xdptdr.ulhiunteco.ci;

import java.util.Collection;
import java.util.Collections;
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
@Table(name = "FOO_CI")
public class FooCI {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "foo")
	private Set<BarCI> bars = new HashSet<>();

	public FooCI() {
	}

	public FooCI(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<BarCI> getBars() {
		return Collections.unmodifiableCollection(bars);
	}

	public void addBar(BarCI bar) {
		this.bars.add(bar);
	}

}
