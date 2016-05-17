package xdptdr.ulhiunteco.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
@Table(name = "Foo_CN")
public class FooCN {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FOO_BAR_CN", joinColumns = @JoinColumn(name = "FOO_ID"), inverseJoinColumns = @JoinColumn(name = "BAR_ID"))
	@OrderColumn(name = "POSITION")
	@ListIndexBase(value = 0)
	private List<BarCN> bars = new ArrayList<>();

	public FooCN() {
	}

	public FooCN(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BarCN> getBars() {
		return Collections.unmodifiableList(bars);
	}

	public void addBar(BarCN bar) {
		if (!bars.contains(bar)) {
			bars.add(bar);
			bar.addFoo(this);
		}
	}

}
