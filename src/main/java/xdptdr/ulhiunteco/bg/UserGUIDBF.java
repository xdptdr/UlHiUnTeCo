package xdptdr.ulhiunteco.bg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_GUID_BG")
@GenericGenerator(name="bg_guid", strategy="guid")
public class UserGUIDBF {

	@Id
	@GeneratedValue(generator = "bg_guid")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public UserGUIDBF() {
	}

	public UserGUIDBF(String name) {
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
