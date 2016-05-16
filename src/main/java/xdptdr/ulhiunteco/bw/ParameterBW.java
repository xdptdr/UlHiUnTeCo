package xdptdr.ulhiunteco.bw;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PARAMETER_ID")
public class ParameterBW extends NamedItemBW {

	@Column(name = "VALUE")
	String value;

	public ParameterBW() {
		super();
	}

	public ParameterBW(String name, String value) {
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
