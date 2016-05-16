package xdptdr.ulhiunteco.bh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "USER_BH")
public class UserGeneratedProperties {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SQL_ALWAYS_GENERATED_DATA")
	@Generated(GenerationTime.ALWAYS)
	private String sqlAlwaysGeneratedData;

	@Column(name = "SQL_INSERT_GENERATED_DATA")
	@Generated(GenerationTime.INSERT)
	private String sqlInsertGeneratedData;

	@Column(name = "SQL_NEVER_GENERATED_DATA")
	@Generated(GenerationTime.NEVER)
	private String sqlNeverGeneratedData;

	@Column(name = "DATA_WITH_SQL_DEFAULT", columnDefinition = "varchar default 'hello'")
	@Generated(GenerationTime.INSERT)
	private String dataWithSqlDefault;

	public UserGeneratedProperties() {
	}

	public UserGeneratedProperties(String name) {
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

	public String getSqlAlwaysGeneratedData() {
		return sqlAlwaysGeneratedData;
	}

	public void setSqlAlwaysGeneratedData(String sqlAlwaysGeneratedData) {
		this.sqlAlwaysGeneratedData = sqlAlwaysGeneratedData;
	}

	public String getSqlInsertGeneratedData() {
		return sqlInsertGeneratedData;
	}

	public void setSqlInsertGeneratedData(String sqlInsertGeneratedData) {
		this.sqlInsertGeneratedData = sqlInsertGeneratedData;
	}

	public String getSqlNeverGeneratedData() {
		return sqlNeverGeneratedData;
	}

	public void setSqlNeverGeneratedData(String sqlNeverGeneratedData) {
		this.sqlNeverGeneratedData = sqlNeverGeneratedData;
	}

}
