package xdptdr.ulhiunteco.bg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_HILO_BG")
@GenericGenerator(name="bg_hilo", strategy="hilo")
public class UserHiloBF {

	@Id
	@GeneratedValue(generator = "bg_hilo")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public UserHiloBF() {
	}

	public UserHiloBF(String name) {
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
