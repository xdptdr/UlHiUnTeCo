package xdptdr.ulhiunteco.ci;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CI")
public class BarCI {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinTable(name = "FOO_BAR_CI", joinColumns = @JoinColumn(name = "BAR_ID"), inverseJoinColumns = @JoinColumn(name = "FOO_ID"))
	private FooCI foo;

	public BarCI() {
	}

	public BarCI(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCI getFoo() {
		return foo;
	}

	public void setFoo(FooCI foo) {
		this.foo = foo;
	}

}
