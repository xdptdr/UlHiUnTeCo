package xdptdr.ulhiunteco.bl;

import javax.persistence.Column;

public abstract class NamedItemBL {

	@Column(name = "NAME")
	String name;

	public NamedItemBL() {
	}

	public NamedItemBL(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
