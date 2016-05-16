package xdptdr.ulhiunteco.bh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UWHCN")
@Table(name = "USER_WITH_HQL_CUSTOM_NAME_BH")
public class UserWithHQLCustomName {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public UserWithHQLCustomName() {
	}

	public UserWithHQLCustomName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
