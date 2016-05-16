package xdptdr.ulhiunteco.bh;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_BH")
public class UserBasic {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Basic(optional = true)
	@Column(nullable = true)
	String fooOptionalNullable;

	@Basic(optional = true)
	@Column(nullable = false)
	String fooOptionalNotNullable;

	@Basic(optional = false)
	@Column(nullable = true)
	String fooNotOptionalNullable;

	@Basic(optional = false)
	@Column(nullable = false)
	String fooNotOptionalNotNullable;

	@Basic(fetch = FetchType.EAGER)

	String fooEager;

	@Basic(fetch = FetchType.LAZY)
	String fooLazy;

	public UserBasic() {
	}

	public UserBasic(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
