package cn.jeeweb.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hexin on 2018/8/14.
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
public class DataSourceConfig {
    private String dbUrl = "jdbc:mysql://localhost:3306/jeeweb_mybatis?useUnicode=true&characterEncoding=utf-8";
    private String username = "root";
    private String password="123456";
    private String dbType="mysql";
    private String driverClassName="com.mysql.jdbc.Driver";
    private int initialSize=5;
    private int minIdle=5;
    private int maxActive=5;
    private int maxWait=60000;
    private int timeBetweenEvictionRunsMillis=60000;
    private int minEvictableIdleTimeMillis=300000;
    private String validationQuery="SELECT 'x'";
    private boolean testWhileIdle=true;
    private boolean testOnBorrow=false;
    private boolean testOnReturn=false;
    private boolean poolPreparedStatements=true;
    private int maxPoolPreparedStatementPerConnectionSize=20;
    private String filters="stat";

    /**
     * 注册DruidServlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/admin/sys/monitor/druid/*");
        return servletRegistrationBean;
    }

    /**
     * 注册DruidFilter拦截
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean druidFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<String, String>();
        //设置忽略请求
        initParams.put("exclusions", "/static/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

    /**
     * 配置DataSource
     * @return
     * @throws SQLException
     */
    @Bean(initMethod = "init",destroyMethod = "close",name = "dataSource")
    @Primary
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDbType(dbType);
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setUseGlobalDataSourceStat(true);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setFilters(filters);
        return druidDataSource;
    }

    @Value("${connection.url}")
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Value("${connection.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    @Value("${connection.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Value("${connection.driverClassName}")
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Value(value = "${druid.initialSize}")
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    @Value(value = "${druid.minIdle}")
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    @Value(value = "${druid.maxActive}")
    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    @Value(value = "${druid.maxWait}")
    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

}
