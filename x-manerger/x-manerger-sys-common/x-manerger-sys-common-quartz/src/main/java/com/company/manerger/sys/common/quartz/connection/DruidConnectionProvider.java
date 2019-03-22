package com.company.manerger.sys.common.quartz.connection;

import com.alibaba.druid.pool.DruidDataSource;
import org.quartz.SchedulerException;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.quartz.utils.ConnectionProvider;
import org.quartz.utils.PropertiesParser;

/**
 * @description: Druid连接池的Quartz扩展类
 */
public class DruidConnectionProvider implements ConnectionProvider {

       /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Constants.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /** The JDBC database driver. */
    public static final String DB_DRIVER = "driver";

    /** The JDBC database URL. */
    public static final String DB_URL = "URL";

    /** The database user name. */
    public static final String DB_USER = "user";

    /** The database user password. */
    public static final String DB_PASSWORD = "password";

    /** The maximum number of database connections to have in the pool.  Default is 10. */
    public static final String DB_MAX_CONNECTIONS = "maxConnections";

    /**
     * The maximum number of prepared statements that will be cached per connection in the pool.
     * Depending upon your JDBC Driver this may significantly help performance, or may slightly
     * hinder performance.
     * Default is 120, as Quartz uses over 100 unique statements. 0 disables the feature.
     */
    public static final String DB_MAX_CACHED_STATEMENTS_PER_CONNECTION = "maxCachedStatementsPerConnection";

    /**
     * The database sql query to execute every time a connection is returned
     * to the pool to ensure that it is still valid.
     */
    public static final String DB_VALIDATION_QUERY = "validationQuery";

    /**
     * The number of seconds between tests of idle connections - only enabled
     * if the validation query property is set.  Default is 50 seconds.
     */
    public static final String DB_IDLE_VALIDATION_SECONDS = "idleConnectionValidationSeconds";

    /**
     * Whether the database sql query to validate connections should be executed every time
     * a connection is retrieved from the pool to ensure that it is still valid.  If false,
     * then validation will occur on check-in.  Default is false.
     */
    public static final String DB_VALIDATE_ON_CHECKOUT = "validateOnCheckout";

    /** Discard connections after they have been idle this many seconds.  0 disables the feature. Default is 0.*/
    private static final String DB_DISCARD_IDLE_CONNECTIONS_SECONDS = "discardIdleConnectionsSeconds";

    /** Default maximum number of database connections in the pool. */
    public static final int DEFAULT_DB_MAX_CONNECTIONS = 10;

    /** Default maximum number of database connections in the pool. */
    public static final int DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION = 120;


    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Data members.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    //JDBC驱动
    public String driver;
    //JDBC连接串
    public String URL;
    //数据库用户名
    public String user;
    //数据库用户密码
    public String password;
    //数据库最大连接数
    public int maxConnections;
    //数据库SQL查询每次连接返回执行到连接池，以确保它仍然是有效的。
    public String validationQuery;
    private boolean validateOnCheckout;
    private int idleConnectionValidationSeconds;
    public String maxCachedStatementsPerConnection;
    private String discardIdleConnectionsSeconds;

    private DruidDataSource datasource;

    public DruidConnectionProvider(){

    }
    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Constructors.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    public DruidConnectionProvider(String dbDriver, String dbURL,
                                     String dbUser, String dbPassword, int maxConnections,
                                     String dbValidationQuery) throws SQLException, SchedulerException {
        initialize(
                dbDriver, dbURL, dbUser, dbPassword,
                maxConnections, DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION, dbValidationQuery, false, 50, 0);
    }

    /**
     * Create a connection pool using the given properties.
     *
     * <p>
     * The properties passed should contain:
     * <UL>
     * <LI>{@link #DB_DRIVER}- The database driver class name
     * <LI>{@link #DB_URL}- The database URL
     * <LI>{@link #DB_USER}- The database user
     * <LI>{@link #DB_PASSWORD}- The database password
     * <LI>{@link #DB_MAX_CONNECTIONS}- The maximum # connections in the pool,
     * optional
     * <LI>{@link #DB_VALIDATION_QUERY}- The sql validation query, optional
     * </UL>
     * </p>
     *
     * @param config
     *            configuration properties
     */
    public DruidConnectionProvider(Properties config) throws SchedulerException, SQLException {
        PropertiesParser cfg = new PropertiesParser(config);
        initialize(
                cfg.getStringProperty(DB_DRIVER),
                cfg.getStringProperty(DB_URL),
                cfg.getStringProperty(DB_USER, ""),
                cfg.getStringProperty(DB_PASSWORD, ""),
                cfg.getIntProperty(DB_MAX_CONNECTIONS, DEFAULT_DB_MAX_CONNECTIONS),
                cfg.getIntProperty(DB_MAX_CACHED_STATEMENTS_PER_CONNECTION, DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION),
                cfg.getStringProperty(DB_VALIDATION_QUERY),
                cfg.getBooleanProperty(DB_VALIDATE_ON_CHECKOUT, false),
                cfg.getIntProperty(DB_IDLE_VALIDATION_SECONDS, 50),
                cfg.getIntProperty(DB_DISCARD_IDLE_CONNECTIONS_SECONDS, 0));
    }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Interface.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * Create the underlying C3PO ComboPooledDataSource with the
     * default supported properties.
     * @throws SchedulerException
     */
    private void initialize(
            String dbDriver,
            String dbURL,
            String dbUser,
            String dbPassword,
            int maxConnections,
            int maxStatementsPerConnection,
            String dbValidationQuery,
            boolean validateOnCheckout,
            int idleValidationSeconds,
            int maxIdleSeconds) throws SQLException, SchedulerException {
        if (dbURL == null) {
            throw new SQLException(
                    "DBPool could not be created: DB URL cannot be null");
        }

        if (dbDriver == null) {
            throw new SQLException(
                    "DBPool '" + dbURL + "' could not be created: " +
                            "DB driver class name cannot be null!");
        }

        if (maxConnections < 0) {
            throw new SQLException(
                    "DBPool '" + dbURL + "' could not be created: " +
                            "Max connections must be greater than zero!");
        }

        datasource = new DruidDataSource();
        try{
            datasource.setDriverClassName(dbDriver);
        } catch (Exception e) {
            try {
                throw new SchedulerException("Problem setting driver class name on datasource: " + e.getMessage(), e);
            } catch (SchedulerException e1) {
            }
        }
        datasource.setUrl(dbURL);
        datasource.setUsername(dbUser);
        datasource.setPassword(dbPassword);
        datasource.setMaxActive(maxConnections);
        datasource.setMinIdle(1);
        datasource.setMaxWait(0);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(DEFAULT_DB_MAX_CONNECTIONS);
        if (dbValidationQuery != null) {
            datasource.setValidationQuery(dbValidationQuery);
            if(!validateOnCheckout)
                datasource.setTestOnReturn(true);
            else
                datasource.setTestOnBorrow(true);
            datasource.setValidationQueryTimeout(idleValidationSeconds);
        }
    }

    /**
     * Get the C3PO ComboPooledDataSource created during initialization.
     *
     * <p>
     * This can be used to set additional data source properties in a
     * subclass's constructor.
     * </p>
     */
    protected DruidDataSource getDataSource() {
        return datasource;
    }

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    public void shutdown() throws SQLException {
        datasource.close();
    }

    public void initialize() throws SQLException {
        // do nothing, already initialized during constructor call
        try {
            initialize(this.driver,this.URL,this.user,this.password,this.maxConnections,
                    DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION, this.validationQuery, false, 50, 0);
        }catch (SchedulerException e){

        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isValidateOnCheckout() {
        return validateOnCheckout;
    }

    public void setValidateOnCheckout(boolean validateOnCheckout) {
        this.validateOnCheckout = validateOnCheckout;
    }

    public int getIdleConnectionValidationSeconds() {
        return idleConnectionValidationSeconds;
    }

    public void setIdleConnectionValidationSeconds(int idleConnectionValidationSeconds) {
        this.idleConnectionValidationSeconds = idleConnectionValidationSeconds;
    }

    public String getMaxCachedStatementsPerConnection() {
        return maxCachedStatementsPerConnection;
    }

    public void setMaxCachedStatementsPerConnection(String maxCachedStatementsPerConnection) {
        this.maxCachedStatementsPerConnection = maxCachedStatementsPerConnection;
    }

    public String getDiscardIdleConnectionsSeconds() {
        return discardIdleConnectionsSeconds;
    }

    public void setDiscardIdleConnectionsSeconds(String discardIdleConnectionsSeconds) {
        this.discardIdleConnectionsSeconds = discardIdleConnectionsSeconds;
    }

    public DruidDataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DruidDataSource datasource) {
        this.datasource = datasource;
    }
}
