package xdptdr.ulhiunteco.cc;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "FOO_CC")
public class FooCC {

	@Id
	@GeneratedValue
	@Column(name = "ID_FOO")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private BarCC bar;

	public FooCC() {
	}

	public FooCC(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BarCC getBar() {
		return bar;
	}

	public void setBar(BarCC bar) {
		this.bar = bar;
	}

}
