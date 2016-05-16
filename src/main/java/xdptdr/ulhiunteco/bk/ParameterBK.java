package xdptdr.ulhiunteco.bk;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBK extends NamedItemBK {

	@Column(name = "VALUE")
	String value;

	public ParameterBK() {
		super();
	}

	public ParameterBK(String name, String value) {
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
