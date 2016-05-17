package xdptdr.ulhiunteco.cm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CM")
public class BarCM {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "bars")
	private Set<FooCM> foos = new HashSet<>();

	public BarCM() {
	}

	public BarCM(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addFoo(FooCM foo) {
		if (!foos.contains(foo)) {
			foos.add(foo);
			foo.addBar(this);
		}
	}

}
