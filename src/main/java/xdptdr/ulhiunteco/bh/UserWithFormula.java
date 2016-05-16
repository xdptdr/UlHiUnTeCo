package xdptdr.ulhiunteco.bh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "USER_BH")
public class UserWithFormula {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BIRTH_YEAR")
	private Integer birthYear;

	private Integer age;

	public UserWithFormula() {
	}

	public UserWithFormula(String name, Integer birthYear) {
		this.name = name;
		this.birthYear = birthYear;
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

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	@Formula(value = "BIRTH_YEAR+BIRTH_YEAR")
	public Integer getAge() {
		return age;
	}

}
