package xdptdr.ulhiunteco.cd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CD")
public class BarCD {

	@Id
	@GeneratedValue
	@Column(name = "ID_BAR")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(mappedBy="bar")
	private FooCD foo;

	public BarCD() {
	}

	public BarCD(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCD getFoo() {
		return foo;
	}

	public void setFoo(FooCD foo) {
		this.foo = foo;
	}

}
