package xdptdr.ulhiunteco.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

public class AbstractTest {

	public static enum Type {
		HSQL, MYSQL, SQLSERVER, IMPOSSIBLE
	}

	public static final String ULHIUNTECO_PROPERTIES = "ulhiunteco.properties";

	public static final String PROPERTY_KEY_TYPE = "ulhiunteco.type";

	public static final String PROPERTY_KEY_HSQL_DRIVER_CLASS = "ulhiunteco.hsql.driver_class";
	public static final String PROPERTY_KEY_HSQL_DIALECT = "ulhiunteco.hsql.dialect";
	public static final String PROPERTY_KEY_HSQL_SCHEMA = "ulhiunteco.hsql.schema";
	public static final String PROPERTY_KEY_HSQL_URL_PREFIX = "ulhiunteco.hsql.url_prefix";
	public static final String PROPERTY_KEY_HSQL_POOL_SIZE = "ulhiunteco.hsql.pool_size";

	public static final String PROPERTY_KEY_MYSQL_DRIVER_CLASS = "ulhiunteco.hsql.driver_class";
	public static final String PROPERTY_KEY_MYSQL_DIALECT = "ulhiunteco.hsql.dialect";
	public static final String PROPERTY_KEY_MYSQL_SCHEMA = "ulhiunteco.mysql.schema";
	public static final String PROPERTY_KEY_MYSQL_SERVER = "ulhiunteco.mysql.server";
	public static final String PROPERTY_KEY_MYSQL_PORT = "ulhiunteco.mysql.port";
	public static final String PROPERTY_KEY_MYSQL_USERNAME = "ulhiunteco.mysql.username";
	public static final String PROPERTY_KEY_MYSQL_PASSWORD = "ulhiunteco.mysql.password";
	public static final String PROPERTY_KEY_MYSQL_POOL_SIZE = "ulhiunteco.mysql.pool_size";

	public static final String PROPERTY_KEY_SQLSERVER_DRIVER_CLASS = "ulhiunteco.sqlserver.driver_class";
	public static final String PROPERTY_KEY_SQLSERVER_DIALECT = "ulhiunteco.sqlserver.dialect";
	public static final String PROPERTY_KEY_SQLSERVER_SCHEMA = "ulhiunteco.sqlserver.schema";
	public static final String PROPERTY_KEY_SQLSERVER_SERVER = "ulhiunteco.sqlserver.server";
	public static final String PROPERTY_KEY_SQLSERVER_INSTANCE = "ulhiunteco.sqlserver.instance";
	public static final String PROPERTY_KEY_SQLSERVER_PORT = "ulhiunteco.sqlserver.port";
	public static final String PROPERTY_KEY_SQLSERVER_USERNAME = "ulhiunteco.sqlserver.username";
	public static final String PROPERTY_KEY_SQLSERVER_PASSWORD = "ulhiunteco.sqlserver.password";
	public static final String PROPERTY_KEY_SQLSERVER_POOL_SIZE = "ulhiunteco.sqlserver.pool_size";

	public static final String DEFAULT_SCHEMA = "ulhiunteco";

	public static final String DEFAULT_HSQL_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	public static final String DEFAULT_HSQL_DIALECT = "org.hibernate.dialect.HSQLDialect";
	public static final String DEFAULT_HSQL_URL_PREFIX = "jdbc:hsqldb:mem:";
	public static final String DEFAULT_HSQL_POOLSIZE = "1";

	public static final String DEFAULT_MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String DEFAULT_MYSQL_DIALECT = "org.hibernate.dialect.MySQLDialect";
	public static final String DEFAULT_MYSQL_SERVER = "localhost";
	public static final String DEFAULT_MYSQL_PORT = "3306";
	public static final String DEFAULT_MYSQL_USERNAME = "root";
	public static final String DEFAULT_MYSQL_POOLSIZE = "1";

	public static final String DEFAULT_SQLSERVER_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DEFAULT_SQLSERVER_DIALECT = "org.hibernate.dialect.SQLServerDialect";
	public static final String DEFAULT_SQLSERVER_SERVER = "localhost";
	public static final String DEFAULT_SQLSERVER_INSTANCE = "SQLEXPRESS";
	public static final String DEFAULT_SQLSERVER_PORT = "1433";
	public static final String DEFAULT_SQLSERVER_USERNAME = "sa";
	public static final String DEFAULT_SQLSERVER_POOLSIZE = "1";

	private Class<?>[] classes;
	private SessionFactory sessionFactory;

	private Type type;

	public AbstractTest(Class<?>[] entityClasses) {
		this.classes = entityClasses;
	}

	@Before
	public void setUp() {

		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		loadUserProperties(configuration);
		if (classes != null) {
			for (Class<?> entityClass : classes) {
				configuration.addAnnotatedClass(entityClass);
			}
		}
		customizeSetup(configuration);
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	protected void customizeSetup(Configuration configuration) {
	}

	private void loadUserProperties(Configuration configuration) {

		String schema = DEFAULT_SCHEMA;
		String jdbcConnectionURL = DEFAULT_HSQL_URL_PREFIX + DEFAULT_SCHEMA;
		String poolSize = DEFAULT_HSQL_POOLSIZE;
		String dialect = DEFAULT_HSQL_DIALECT;
		String driverClass = DEFAULT_HSQL_DRIVER_CLASS;

		try {

			InputStream ras = this.getClass().getClassLoader().getResourceAsStream(ULHIUNTECO_PROPERTIES);
			if (ras == null) {
				throw new IOException();
			}

			Properties ulhiuntecoProperties = new Properties();
			ulhiuntecoProperties.load(ras);

			type = Type.valueOf(ulhiuntecoProperties.getProperty(PROPERTY_KEY_TYPE).trim().toUpperCase());

			switch (type) {
			case HSQL: {
				driverClass = ulhiuntecoProperties.getProperty(PROPERTY_KEY_HSQL_DRIVER_CLASS);
				if (driverClass == null) {
					driverClass = DEFAULT_HSQL_DRIVER_CLASS;
				}

				dialect = ulhiuntecoProperties.getProperty(PROPERTY_KEY_HSQL_DIALECT);
				if (dialect == null) {
					dialect = DEFAULT_HSQL_DIALECT;
				}

				schema = ulhiuntecoProperties.getProperty(PROPERTY_KEY_HSQL_SCHEMA);
				if (schema == null) {
					schema = DEFAULT_SCHEMA;
				}

				String hsqlUrlPrefix = ulhiuntecoProperties.getProperty(PROPERTY_KEY_HSQL_URL_PREFIX);
				if (hsqlUrlPrefix == null) {
					hsqlUrlPrefix = DEFAULT_HSQL_URL_PREFIX;
				}
				jdbcConnectionURL = hsqlUrlPrefix + schema;

				poolSize = ulhiuntecoProperties.getProperty(PROPERTY_KEY_HSQL_POOL_SIZE);
				if (poolSize == null) {
					poolSize = DEFAULT_HSQL_POOLSIZE;
				}
			}
				break;
			case MYSQL: {
				driverClass = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_DRIVER_CLASS);
				if (driverClass == null) {
					driverClass = DEFAULT_MYSQL_DRIVER_CLASS;
				}

				dialect = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_DIALECT);
				if (dialect == null) {
					dialect = DEFAULT_MYSQL_DIALECT;
				}

				String server = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_SERVER);
				String port = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_PORT);
				schema = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_SCHEMA);
				String username = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_USERNAME);
				String password = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_PASSWORD);

				if (server == null) {
					server = DEFAULT_MYSQL_SERVER;
				}
				if (port == null) {
					port = DEFAULT_MYSQL_PORT;
				}
				if (schema == null) {
					schema = DEFAULT_SCHEMA;
				}
				if (username == null) {
					username = DEFAULT_MYSQL_USERNAME;
				}

				jdbcConnectionURL = "jdbc:mysql://" + server + ":" + port + "/" + schema + "?user=" + username;

				if (password != null) {
					jdbcConnectionURL += "&password=" + password;
				}

				poolSize = ulhiuntecoProperties.getProperty(PROPERTY_KEY_MYSQL_POOL_SIZE);
				if (poolSize == null) {
					poolSize = DEFAULT_MYSQL_POOLSIZE;
				}
			}
				break;
			case SQLSERVER: {
				driverClass = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_DRIVER_CLASS);
				if (driverClass == null) {
					driverClass = DEFAULT_SQLSERVER_DRIVER_CLASS;
				}

				dialect = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_DIALECT);
				if (dialect == null) {
					dialect = DEFAULT_SQLSERVER_DIALECT;
				}

				String server = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_SERVER);
				String port = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_PORT);
				String instance = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_INSTANCE);
				schema = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_SCHEMA);
				String username = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_USERNAME);
				String password = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_PASSWORD);

				if (server == null) {
					server = DEFAULT_SQLSERVER_SERVER;
				}
				if (instance == null) {
					instance = DEFAULT_SQLSERVER_INSTANCE;
				}
				if (port == null) {
					port = DEFAULT_SQLSERVER_PORT;
				}
				if (schema == null) {
					schema = DEFAULT_SCHEMA;
				}
				if (username == null) {
					username = DEFAULT_SQLSERVER_USERNAME;
				}

				jdbcConnectionURL = "jdbc:sqlserver://" + server + "\\" + instance + ":" + port + ";databaseName="
						+ schema;

				if (username != null) {
					configuration.setProperty("hibernate.connection.username", username);
				}
				if (password != null) {
					configuration.setProperty("hibernate.connection.password", password);
				}

				poolSize = ulhiuntecoProperties.getProperty(PROPERTY_KEY_SQLSERVER_POOL_SIZE);
				if (poolSize == null) {
					poolSize = DEFAULT_SQLSERVER_POOLSIZE;
				}
			}
				break;
			case IMPOSSIBLE:
				throw new IllegalArgumentException("Impossible type is not supported");
			}

		} catch (IOException | IllegalArgumentException | NullPointerException e) {
			System.err.println("Couldn't load " + ULHIUNTECO_PROPERTIES);
		}

		configuration.setProperty("hibernate.connection.url", jdbcConnectionURL);

		configuration.setProperty("hibernate.connection.pool_size", poolSize);

		configuration.setProperty("hibernate.dialect", dialect);

		configuration.setProperty("hibernate.connection.driver_class", driverClass);

	}

	@After
	public void tearDown() {
		sessionFactory.close();
	}

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Type getType() {
		return type;
	}
}
