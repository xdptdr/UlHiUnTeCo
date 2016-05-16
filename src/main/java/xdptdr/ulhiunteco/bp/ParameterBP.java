package xdptdr.ulhiunteco.bp;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBP extends NamedItemBP {

	@Column(name = "VALUE")
	String value;

	public ParameterBP() {
		super();
	}

	public ParameterBP(String name, String value) {
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
