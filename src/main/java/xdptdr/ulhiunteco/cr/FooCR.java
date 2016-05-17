package xdptdr.ulhiunteco.cr;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOO_CR")
public class FooCR {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long fooId;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "ZOI_ID")
	@JoinTable(name = "FOO_ZOI_BAR_CR", joinColumns = @JoinColumn(name = "FOO_ID"), inverseJoinColumns = @JoinColumn(name = "BAR_ID"))
	private Map<ZoiCR, BarCR> zoibars = new HashMap<ZoiCR, BarCR>();

	public FooCR() {
	}

	public FooCR(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addZoiBar(ZoiCR zoi, BarCR bar) {
		zoibars.put(zoi, bar);
	}

}
