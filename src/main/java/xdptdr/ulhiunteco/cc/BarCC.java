package xdptdr.ulhiunteco.cc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "BAR_CC")
public class BarCC {

	@Id
	@GeneratedValue(generator = "barForeign")
	@GenericGenerator(name = "barForeign", strategy = "foreign", parameters = @Parameter(name = "property", value = "foo"))
	@Column(name = "ID_BAR")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne
	private FooCC foo;

	public BarCC() {
	}

	public BarCC(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCC getFoo() {
		return foo;
	}

	public void setFoo(FooCC foo) {
		this.foo = foo;
	}

}
