package xdptdr.ulhiunteco.bt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NamedItemBT {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	String name;

	public NamedItemBT() {
	}

	public NamedItemBT(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
