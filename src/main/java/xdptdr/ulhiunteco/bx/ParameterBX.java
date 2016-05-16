package xdptdr.ulhiunteco.bx;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBX extends NamedItemBX {

	@Column(name = "VALUE")
	String value;

	public ParameterBX() {
		super();
	}

	public ParameterBX(String name, String value) {
		super(name);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
