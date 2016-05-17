package xdptdr.ulhiunteco.cg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "FOO_CG")
public class FooCG {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FOO_ID", nullable = false)
	@OrderColumn
	@ListIndexBase(value = 0)
	private List<BarCG> bars = new ArrayList<>();

	public FooCG() {
	}

	public FooCG(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<BarCG> getBars() {
		return Collections.unmodifiableCollection(bars);
	}

	public void addBar(BarCG bar) {
		this.bars.add(bar);
	}

}
