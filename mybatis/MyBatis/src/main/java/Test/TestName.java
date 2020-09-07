package Test;


import bean.UserInfo2;
import mapper.User2Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestName {
    public static void a() {
        //第一步：加载配置文件(读取配置文件)  相对路径  InputStream(输入流类)
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        //第二步：创建会话工厂（管理会话）
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        //创建会话
        SqlSession session = ssf.openSession();
        //请求
        User2Mapper um = session.getMapper(User2Mapper.class);
        //获取到执行操作
        List<UserInfo2> list = um.find1();
        for (UserInfo2 ui : list) {
            System.out.println(ui);
        }
        //关闭会话
        session.close();
    }

    public static void b() {
        //第一步：加载配置文件(读取配置文件)  相对路径  InputStream(输入流类)
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        //第二步：创建会话工厂（管理会话）
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        //创建会话
        SqlSession session = ssf.openSession();
        //请求
        User2Mapper um = session.getMapper(User2Mapper.class);
        //获取到执行操作
        List<UserInfo2> list = um.find2();
        for (UserInfo2 ui : list) {
            System.out.println(ui);
        }
        //关闭会话
        session.close();
    }
}
