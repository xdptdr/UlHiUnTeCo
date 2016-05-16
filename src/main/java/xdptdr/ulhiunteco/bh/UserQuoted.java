package xdptdr.ulhiunteco.bh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_QUOTED_BH")
public class UserQuoted {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "`SELECT`")
	private String name;

	public UserQuoted() {
	}

	public UserQuoted(String name) {
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
