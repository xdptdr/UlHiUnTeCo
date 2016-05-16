package xdptdr.ulhiunteco.bj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETER_BJ")
public class ParameterBJ extends NamedItemBJ {

	@Column(name = "VALUE")
	String value;

	public ParameterBJ() {
		super();
	}

	public ParameterBJ(String name, String value) {
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
