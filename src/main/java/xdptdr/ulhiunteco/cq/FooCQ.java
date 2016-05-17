package xdptdr.ulhiunteco.cq;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Foo_CQ")
public class FooCQ {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long fooId;

	@Column(name = "NAME")
	private String name;

	@MapKey(name = "barId")
	@OneToMany
	private Map<Long, BarCQ> bars = new HashMap<Long, BarCQ>();

	public FooCQ() {
	}

	public FooCQ(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addBar(Long key, BarCQ bar) {
		bars.put(key, bar);
	}

}
