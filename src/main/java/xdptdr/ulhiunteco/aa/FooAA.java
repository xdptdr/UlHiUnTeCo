package xdptdr.ulhiunteco.aa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FooAA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;

	public FooAA() {
	}

	public FooAA(String name) {
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
