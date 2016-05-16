package xdptdr.ulhiunteco.bk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Table(name = "NAMED_ITEM_BK")
public abstract class NamedItemBK {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	String name;

	public NamedItemBK() {
	}

	public NamedItemBK(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
