package xdptdr.ulhiunteco.cf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOO_CF")
public class FooCF {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "foo")
	private Collection<BarCF> bars = new ArrayList<>();

	public FooCF() {
	}

	public FooCF(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<BarCF> getBars() {
		return Collections.unmodifiableCollection(bars);
	}

	public void addBar(BarCF bar) {
		this.bars.add(bar);
	}

}
