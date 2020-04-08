package com.cd.test.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author ChuD
 * @date 2020-03-16 16:05
 */
public class MybatisTest {
    DataSource dataSource;

    @Test
    public void codeAnalysis() throws IOException {
        /// with xml
        String resource = "mybatis-config.xml";
//        String resource = "com/cd/test/mybatis/mybatis-config.xml";
//        String resource = "D:\\idea-workspace\\test\\src\\test\\java\\com\\cd\\test\\mybatis\\mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.addMapper(UserMapper.class);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Map map = mapper.selectUser("U45517");
            System.out.println(map);
        }



        /// without xml
        /*TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);*/
    }

    @Before
    public void initDataSource() {
//        DataSourceFactory dataSourceFactory = new DataSourceFactory();
    }

}
