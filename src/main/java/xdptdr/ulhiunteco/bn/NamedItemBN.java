package xdptdr.ulhiunteco.bn;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedItemBN {

	@Column(name = "NAME")
	String name;

	public NamedItemBN() {
	}

	public NamedItemBN(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
