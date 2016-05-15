package xdptdr.ulhiunteco.au;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "COLUMNOLOGY_AU")
@SecondaryTable(name = "COLUMNOLOGY_OTHER_AU")
public class ColumnologyAU {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "COLUMN_DEFINITION_AU", columnDefinition = "")
	String columnDefinition;

	@Column(name = "INSERTABLE_AU", insertable = true)
	String insertable;

	@Column(name = "NOT_INSERTABLE_AU", insertable = false)
	String notInsertable;

	@Column(name = "LENGTH5_AU", length = 5)
	String length5;

	@Column(name = "LENGTH50_AU", length = 50)
	String length50;

	@Column(name = "LENGTH500_AU", length = 500)
	String length500;

	@Column(name = "LENGTH5000_AU", length = 5000)
	String length5000;

	@Column(name = "LENGTH50000_AU", length = 50000)
	String length50000;

	@Column(name = "NULLABLE_AU", nullable = true)
	String nullable;

	@Column(name = "NOT_NULLABLE_AU", nullable = false)
	String notNnullable;

	@Column(name = "PRECISION0_AU", precision = 0)
	double precision0;

	@Column(name = "PRECISION1_AU", precision = 1)
	double precision1;

	@Column(name = "PRECISION2_AU", precision = 2)
	double precision2;

	@Column(name = "PRECISION3_AU", precision = 3)
	double precision3;

	@Column(name = "PRECISION4_AU", precision = 4)
	double precision4;

	@Column(name = "SCALE0_AU", scale = 0)
	double scale0;

	@Column(name = "SCALE1_AU", scale = 1)
	double scale1;

	@Column(name = "SCALE2_AU", scale = 2)
	double scale2;

	@Column(name = "SCALE3_AU", scale = 3)
	double scale3;

	@Column(name = "TABLE_AU", table = "COLUMNOLOGY_OTHER_AU")
	String table;

	@Column(name = "UNIQUE_AU", unique = true)
	String unique;

	@Column(name = "NOT_UNIQUE_AU", unique = false)
	String notUnique;

	@Column(name = "UPDATABLE_AU", updatable = true)
	String updatable;

	@Column(name = "NOT_UPDATABLE_AU", updatable = false)
	String notUpdatable;

	public ColumnologyAU() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColumnDefinition() {
		return columnDefinition;
	}

	public void setColumnDefinition(String columnDefinition) {
		this.columnDefinition = columnDefinition;
	}

	public String getInsertable() {
		return insertable;
	}

	public void setInsertable(String insertable) {
		this.insertable = insertable;
	}

	public String getNotInsertable() {
		return notInsertable;
	}

	public void setNotInsertable(String notInsertable) {
		this.notInsertable = notInsertable;
	}

	public String getLength5() {
		return length5;
	}

	public void setLength5(String length5) {
		this.length5 = length5;
	}

	public String getLength50() {
		return length50;
	}

	public void setLength50(String length50) {
		this.length50 = length50;
	}

	public String getLength500() {
		return length500;
	}

	public void setLength500(String length500) {
		this.length500 = length500;
	}

	public String getLength5000() {
		return length5000;
	}

	public void setLength5000(String length5000) {
		this.length5000 = length5000;
	}

	public String getLength50000() {
		return length50000;
	}

	public void setLength50000(String length50000) {
		this.length50000 = length50000;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getNotNnullable() {
		return notNnullable;
	}

	public void setNotNnullable(String notNnullable) {
		this.notNnullable = notNnullable;
	}

	public double getPrecision0() {
		return precision0;
	}

	public void setPrecision0(double precision0) {
		this.precision0 = precision0;
	}

	public double getPrecision1() {
		return precision1;
	}

	public void setPrecision1(double precision1) {
		this.precision1 = precision1;
	}

	public double getPrecision2() {
		return precision2;
	}

	public void setPrecision2(double precision2) {
		this.precision2 = precision2;
	}

	public double getPrecision3() {
		return precision3;
	}

	public void setPrecision3(double precision3) {
		this.precision3 = precision3;
	}

	public double getPrecision4() {
		return precision4;
	}

	public void setPrecision4(double precision4) {
		this.precision4 = precision4;
	}

	public double getScale0() {
		return scale0;
	}

	public void setScale0(double scale0) {
		this.scale0 = scale0;
	}

	public double getScale1() {
		return scale1;
	}

	public void setScale1(double scale1) {
		this.scale1 = scale1;
	}

	public double getScale2() {
		return scale2;
	}

	public void setScale2(double scale2) {
		this.scale2 = scale2;
	}

	public double getScale3() {
		return scale3;
	}

	public void setScale3(double scale3) {
		this.scale3 = scale3;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public String getNotUnique() {
		return notUnique;
	}

	public void setNotUnique(String notUnique) {
		this.notUnique = notUnique;
	}

	public String getUpdatable() {
		return updatable;
	}

	public void setUpdatable(String updatable) {
		this.updatable = updatable;
	}

	public String getNotUpdatable() {
		return notUpdatable;
	}

	public void setNotUpdatable(String notUpdatable) {
		this.notUpdatable = notUpdatable;
	}

}
