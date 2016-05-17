package xdptdr.ulhiunteco.cm;

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
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "Foo_CM")
public class FooCM {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FOO_BAR_CM", joinColumns = @JoinColumn(name = "FOO_ID"), inverseJoinColumns = @JoinColumn(name = "BAR_ID"))
	@OrderColumn(name = "POSITION")
	@ListIndexBase(value = 0)
	private Set<BarCM> bars = new HashSet<>();

	public FooCM() {
	}

	public FooCM(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BarCM> getBars() {
		return Collections.unmodifiableSet(bars);
	}

	public void addBar(BarCM bar) {
		if (!bars.contains(bar)) {
			bars.add(bar);
			bar.addFoo(this);
		}
	}

}
