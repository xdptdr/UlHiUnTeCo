package xdptdr.ulhiunteco.bp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedItemBP {

	@Id
	@GeneratedValue
	@Column(name = "IID")
	private Long id;

	@Column(name = "NAME")
	String name;

	public NamedItemBP() {
	}

	public NamedItemBP(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
