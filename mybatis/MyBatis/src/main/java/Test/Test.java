package Test;

import bean.PageInfo;
import bean.UserInfo;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Test {

    public void a() {
        //第一步：加载配置文件(读取配置文件)  相对路径  InputStream(输入流类)
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        //第二步：创建会话工厂（管理会话）
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        //创建会话
        SqlSession session = ssf.openSession();
        //请求
        UserMapper um = session.getMapper(UserMapper.class);
        //获取到执行操作
        List<UserInfo> list = um.findAllUser();
        for (UserInfo ui : list) {
            System.out.println(ui);
        }
        //关闭会话
        session.close();
    }

    public static void b() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        UserMapper um = session.getMapper(UserMapper.class);
        um.deleteUser(5);
        //进行手动提交
        session.commit();
        session.close();
    }

    public static void c() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        UserMapper um = session.getMapper(UserMapper.class);
        UserInfo ui = new UserInfo("袁传晟", "男", 20, "黑龙江", "123");
        um.saveUser(ui);
        session.commit();
        session.close();
    }

    public static void d() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        UserMapper um = session.getMapper(UserMapper.class);
        UserInfo ui = new UserInfo(63, "小黑狗", "女", 25, "狗村");
        um.updateUser(ui);
        session.commit();
        session.close();
    }

    public static void e() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        Map<String, Integer> map = new HashMap<>();
        map.put("page", 10);
        map.put("size", 10);
        UserMapper um = session.getMapper(UserMapper.class);
        um.findUser1(map);
        session.commit();
        session.close();
    }

    public static void f() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        Integer page = (3 - 1) * 10;
        Integer size = 10;
        PageInfo pi = new PageInfo(page, size);
        UserMapper um = session.getMapper(UserMapper.class);
        um.findUser2(pi);
        session.commit();
        session.close();
    }

    public static void g() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        UserMapper um = session.getMapper(UserMapper.class);
        um.searchUser("%张%");
        session.commit();
        session.close();
    }

    public static void h() {
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        UserMapper um = session.getMapper(UserMapper.class);
        um.findByUserId(20);
        session.commit();
        session.close();
    }
}
