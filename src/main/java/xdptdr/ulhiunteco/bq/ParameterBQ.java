package xdptdr.ulhiunteco.bq;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ParameterBQ extends NamedItemBQ {

	@Column(name = "VALUE")
	String value;

	public ParameterBQ() {
		super();
	}

	public ParameterBQ(String name, String value) {
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
