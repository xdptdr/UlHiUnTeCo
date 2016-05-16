package xdptdr.ulhiunteco.bo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedItemBO {

	@Column(name = "NAME")
	String name;

	public NamedItemBO() {
	}

	public NamedItemBO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
