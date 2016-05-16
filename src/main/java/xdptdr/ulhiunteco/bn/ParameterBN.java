package xdptdr.ulhiunteco.bn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParameterBN extends NamedItemBN {

	@Id
	@GeneratedValue
	@Column(name = "PARAMETER_ID")
	private Long parameterId;
	
	@Column(name = "VALUE")
	String value;

	public ParameterBN() {
		super();
	}

	public ParameterBN(String name, String value) {
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
