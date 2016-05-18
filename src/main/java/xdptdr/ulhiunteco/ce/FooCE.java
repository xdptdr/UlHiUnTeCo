package xdptdr.ulhiunteco.ce;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FOO_CE")
public class FooCE {

	@Id
	@GeneratedValue
	@Column(name = "FOO_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinTable(name = "FOO_BAR_CE", joinColumns = @JoinColumn(name = "FOO_ID"), inverseJoinColumns = @JoinColumn(name = "BAR_ID"))
	private BarCE bar;

	public FooCE() {
	}

	public FooCE(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BarCE getBar() {
		return bar;
	}

	public void setBar(BarCE bar) {
		this.bar = bar;
	}

}
