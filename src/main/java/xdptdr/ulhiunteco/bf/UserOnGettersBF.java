package xdptdr.ulhiunteco.bf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ON_GETTERS_BF")
public class UserOnGettersBF {

	private Long id;

	private String name;

	private String valuePrefix;

	public UserOnGettersBF() {
	}

	public UserOnGettersBF(String name, String prefix) {
		this.name = name;
		this.valuePrefix = prefix;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return valuePrefix + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PREFIX")
	public String getValuePrefix() {
		return valuePrefix;
	}

	public void setValuePrefix(String valuePrefix) {
		this.valuePrefix = valuePrefix;
	}

}
