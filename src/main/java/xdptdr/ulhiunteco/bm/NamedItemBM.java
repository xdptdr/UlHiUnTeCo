package xdptdr.ulhiunteco.bm;

import javax.persistence.Column;

public abstract class NamedItemBM {

	@Column(name = "NAME")
	String name;

	public NamedItemBM() {
	}

	public NamedItemBM(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
