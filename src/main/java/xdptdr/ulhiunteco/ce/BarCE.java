package xdptdr.ulhiunteco.ce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "BAR_CE")
@SecondaryTable(name="FOO_BAR_CE")
public class BarCE {

	@Id
	@GeneratedValue
	@Column(name = "BAR_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne
	@JoinColumn(table = "FOO_BAR_CE", name = "BAR_ID")
	private FooCE foo;

	public BarCE() {
	}

	public BarCE(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FooCE getFoo() {
		return foo;
	}

	public void setFoo(FooCE foo) {
		this.foo = foo;
	}

}
