package xdptdr.ulhiunteco.br;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBR extends NamedItemBR {

	@Column(name = "VALUE")
	String value;

	public ParameterBR() {
		super();
	}

	public ParameterBR(String name, String value) {
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
