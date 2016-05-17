package xdptdr.ulhiunteco.cd;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FOO_CD")
public class FooCD {

	@Id
	@GeneratedValue
	@Column(name = "ID_FOO")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "BAR_ID")
	private BarCD bar;

	public FooCD() {
	}

	public FooCD(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BarCD getBar() {
		return bar;
	}

	public void setBar(BarCD bar) {
		this.bar = bar;
	}

}
