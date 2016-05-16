package xdptdr.ulhiunteco.bs;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBS extends NamedItemBS {

	@Column(name = "VALUE")
	String value;

	public ParameterBS() {
		super();
	}

	public ParameterBS(String name, String value) {
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
