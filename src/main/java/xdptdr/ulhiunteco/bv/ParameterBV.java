package xdptdr.ulhiunteco.bv;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBV extends NamedItemBV {

	@Column(name = "VALUE")
	String value;

	public ParameterBV() {
		super();
	}

	public ParameterBV(String name, String value) {
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
