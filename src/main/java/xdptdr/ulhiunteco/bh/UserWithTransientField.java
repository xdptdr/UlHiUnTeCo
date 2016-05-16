package xdptdr.ulhiunteco.bh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_BH")
public class UserWithTransientField {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Transient
	private String javaOnly;

	public UserWithTransientField() {
	}

	public UserWithTransientField(String name, String javaOnly) {
		this.name = name;
		this.javaOnly = javaOnly;
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

	protected String getJavaOnly() {
		return javaOnly;
	}

	protected void setJavaOnly(String javaOnly) {
		this.javaOnly = javaOnly;
	}

}
