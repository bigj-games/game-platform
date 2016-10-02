package org.bigj.blackjack.config;

import org.bigj.blackjack.service.MessageService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

/**
 * Created by arthan on 08.09.2016. Project game-platform
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.bigj.blackjack")
public class BlackjackConfiguration {

    @Bean
    public MessageService messageService() {
        return new MessageService();
    }

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        final String dbUrlTemplate = "jdbc:postgresql://{0}:{1}{2}";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        String username;
        String password;
        String url;

        String databaseUrl = System.getenv("DATABASE_URL");
        if (databaseUrl != null) {
            URI dbUri = new URI(databaseUrl);
            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
            url = MessageFormat.format(dbUrlTemplate, dbUri.getHost(), dbUri.getPort(), dbUri, dbUri.getPath());
        } else {
            username = "postgres";
            password = "postgres";
            url = "jdbc:postgresql://localhost:5432/bigj";
        }

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws URISyntaxException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setTypeAliasesPackage("org.bigj.blackjack.domain.entity");
        return sessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory().getObject());
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.bigj.blackjack.domain.mapper");
        return mapperScannerConfigurer;
    }
}
