package xdptdr.ulhiunteco.cn;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CN")
public class BarCN {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "bars")
	private Collection<FooCN> foos = new ArrayList<>();

	public BarCN() {
	}

	public BarCN(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addFoo(FooCN foo) {
		if (!foos.contains(foo)) {
			foos.add(foo);
			foo.addBar(this);
		}
	}

}
