package xdptdr.ulhiunteco.bh;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class NamingStrategyBH extends ImprovedNamingStrategy {

	private static final long serialVersionUID = 1L;

	@Override
	public String classToTableName(String className) {
		return super.classToTableName(className);
	}

	@Override
	public String tableName(String tableName) {
		return super.tableName(tableName);
	}

	@Override
	public String columnName(String columnName) {
		return super.columnName(columnName);
	}

	@Override
	public String propertyToColumnName(String propertyName) {
		return super.propertyToColumnName(propertyName);
	}

}
