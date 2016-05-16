package xdptdr.ulhiunteco.br;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NamedItemBR {

	@Id
	@GeneratedValue
	@Column(name = "IID")
	private Long id;

	@Column(name = "NAME")
	String name;

	public NamedItemBR() {
	}

	public NamedItemBR(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
