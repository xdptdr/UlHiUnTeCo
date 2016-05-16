package xdptdr.ulhiunteco.bg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_UUID_HEX_BG")
@GenericGenerator(name = "bg_uuid.hex", strategy = "uuid.hex")
public class UserUUIDHexBF {

	@Id
	@GeneratedValue(generator = "bg_uuid.hex")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public UserUUIDHexBF() {
	}

	public UserUUIDHexBF(String name) {
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
