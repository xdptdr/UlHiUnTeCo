package xdptdr.ulhiunteco.bf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ON_FIELDS_BF")
public class UserOnFieldsBF {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PREFIX")
	private String valuePrefix;

	public UserOnFieldsBF() {
	}

	public UserOnFieldsBF(String name, String prefix) {
		this.name = name;
		this.valuePrefix = prefix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return valuePrefix + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValuePrefix() {
		return valuePrefix;
	}

	public void setValuePrefix(String valuePrefix) {
		this.valuePrefix = valuePrefix;
	}

}
