package xdptdr.ulhiunteco.ch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CH")
public class BarCH {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "FOO_ID", nullable = false, updatable = false, insertable = false)
	private FooCH foo;

	public BarCH() {
	}

	public BarCH(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCH getFoo() {
		return foo;
	}

	public void setFoo(FooCH foo) {
		this.foo = foo;
	}

}
