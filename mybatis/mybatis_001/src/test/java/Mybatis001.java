import entity.UserEntity;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.ScriptRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static java.lang.System.out;

public class Mybatis001 {

    public static SqlSession session;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        session = sqlSessionFactory.openSession();
        ScriptRunner runner = new ScriptRunner(session.getConnection());
        Reader reader01 = Resources.getResourceAsReader("schema-h2.sql");
        Reader reader02 = Resources.getResourceAsReader("data-h2.sql");
        try (reader01;reader02) {
            runner.runScript(reader01);
            runner.runScript(reader02);
        }
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void test001() throws IOException {
        UserEntity userList = session.selectOne("mapper.UserMapper.selectAll");
        out.println(userList);
    }
}
