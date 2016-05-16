package xdptdr.ulhiunteco.bt;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBT extends NamedItemBT {

	@Column(name = "VALUE")
	String value;

	public ParameterBT() {
		super();
	}

	public ParameterBT(String name, String value) {
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
