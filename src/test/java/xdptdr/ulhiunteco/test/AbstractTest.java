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
	public static final String PROPERTY_KEY_MYSQL_POOL_SIZE = "ulhiunteco.hsql.pool_size";

	private static final String DEFAULT_SCHEMA = "ulhiunteco";

	private static final String DEFAULT_HSQL_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private static final String DEFAULT_HSQL_DIALECT = "org.hibernate.dialect.HSQLDialect";
	private static final String DEFAULT_HSQL_URL_PREFIX = "jdbc:hsqldb:mem:";
	private static final String DEFAULT_HSQL_POOLSIZE = "1";

	private static final String DEFAULT_MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DEFAULT_MYSQL_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private static final String DEFAULT_MYSQL_SERVER = "localhost";
	private static final String DEFAULT_MYSQL_PORT = "3306";
	private static final String DEFAULT_MYSQL_USERNAME = "root";
	private static final String DEFAULT_MYSQL_POOLSIZE = "1";

	private Class<?>[] classes;
	private SessionFactory sessionFactory;

	public AbstractTest(Class<?>[] entityClasses) {
		this.classes = entityClasses;
	}

	@Before
	public void setUp() {

		Configuration configuration = new Configuration();
		if (classes != null) {
			for (Class<?> entityClass : classes) {
				configuration.addAnnotatedClass(entityClass);
			}
		}
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		loadUserProperties(configuration);
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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

			String type = ulhiuntecoProperties.getProperty(PROPERTY_KEY_TYPE);

			if ("hsql".equals(type)) {

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

			} else if ("mysql".equals(type)) {

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

		} catch (IOException e) {
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

}
