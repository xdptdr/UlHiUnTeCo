package xdptdr.ulhiunteco.cj;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Foo_CJ")
public class FooCJ {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FOO_BAR_CJ", joinColumns = @JoinColumn(name = "FOO_ID"), inverseJoinColumns = @JoinColumn(name = "BAR_ID"))
	private Set<BarCJ> bars = new HashSet<>();

	public FooCJ() {
	}

	public FooCJ(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BarCJ> getBars() {
		return Collections.unmodifiableSet(bars);
	}

	public void addBar(BarCJ bar) {
		this.bars.add(bar);
	}

}
