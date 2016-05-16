package xdptdr.ulhiunteco.bu;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PBU")
public class ParameterBU extends NamedItemBU {

	@Column(name = "VALUE")
	String value;

	public ParameterBU() {
		super();
	}

	public ParameterBU(String name, String value) {
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
