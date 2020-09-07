package test;

import bean.UserInfo;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserInfoTest {
    SqlSessionFactory sqlSessionFactory;

    /**
     * 返回sqlSessionFactory对象
     */
    @Before
    public void initSqlSessionFactory(){
        String resources = "config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserInfo> allUser = userDao.findAllUser();
        System.out.println(allUser);
        sqlSession.close();
    }
    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        UserInfo userById = userDao.findUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
}
