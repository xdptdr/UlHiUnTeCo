package xdptdr.ulhiunteco.bl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParameterBL extends NamedItemBL {

	@Id
	@GeneratedValue
	@Column(name = "PARAMETER_ID")
	private Long parameterId;
	
	@Column(name = "VALUE")
	String value;

	public ParameterBL() {
		super();
	}

	public ParameterBL(String name, String value) {
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
