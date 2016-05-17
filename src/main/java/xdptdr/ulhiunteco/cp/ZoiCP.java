package xdptdr.ulhiunteco.cp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Parent;

@Embeddable
public class ZoiCP {

	@Parent
	private FooCP foo;

	@ManyToOne
	@JoinColumn(name = "BAR_ID", nullable = false, updatable = false)
	private BarCP bar;

	@Column(name = "DATA", nullable = false, updatable = false)
	private String data;

	public ZoiCP() {
	}

	public ZoiCP(FooCP foo, BarCP bar, String data) {
		this.foo = foo;
		this.bar = bar;
		this.data = data;
	}

	public FooCP getFoo() {
		return foo;
	}

	public void setFoo(FooCP foo) {
		this.foo = foo;
	}

	public BarCP getBar() {
		return bar;
	}

	public void setBar(BarCP bar) {
		this.bar = bar;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bar == null) ? 0 : bar.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoiCP other = (ZoiCP) obj;
		if (bar == null) {
			if (other.bar != null)
				return false;
		} else if (!bar.equals(other.bar))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
