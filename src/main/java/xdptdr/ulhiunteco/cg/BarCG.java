package xdptdr.ulhiunteco.cg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CG")
public class BarCG {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "FOO_ID", nullable = false, updatable = false, insertable = false)
	private FooCG foo;

	public BarCG() {
	}

	public BarCG(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCG getFoo() {
		return foo;
	}

	public void setFoo(FooCG foo) {
		this.foo = foo;
	}

}
