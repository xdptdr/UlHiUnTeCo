package xdptdr.ulhiunteco.bo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AttributeOverride(name = "name", column = @Column(name = "PARAMETER_NAME"))
public class ParameterBO extends NamedItemBO {

	@Id
	@GeneratedValue
	@Column(name = "PARAMETER_ID")
	private Long parameterId;

	@Column(name = "VALUE")
	String value;

	public ParameterBO() {
		super();
	}

	public ParameterBO(String name, String value) {
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
