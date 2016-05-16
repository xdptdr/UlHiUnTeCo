package xdptdr.ulhiunteco.bq;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedItemBQ {

	@Id
	@GeneratedValue
	@Column(name = "IID")
	private Long id;

	@Column(name = "NAME")
	String name;

	public NamedItemBQ() {
	}

	public NamedItemBQ(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
