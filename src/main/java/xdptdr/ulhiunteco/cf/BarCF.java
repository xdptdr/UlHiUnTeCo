package xdptdr.ulhiunteco.cf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CF")
public class BarCF {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name="FOO_ID")
	private FooCF foo;

	public BarCF() {
	}

	public BarCF(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCF getFoo() {
		return foo;
	}

	public void setFoo(FooCF foo) {
		this.foo = foo;
	}

}
