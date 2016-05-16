package xdptdr.ulhiunteco.bm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParameterBM extends NamedItemBM {

	@Id
	@GeneratedValue
	@Column(name = "PARAMETER_ID")
	private Long parameterId;
	
	@Column(name = "VALUE")
	String value;

	public ParameterBM() {
		super();
	}

	public ParameterBM(String name, String value) {
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
