package Test;

import bean.EmpInfo;
import mapper.DeptMapper;
import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void a(){
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        EmpMapper em = session.getMapper(EmpMapper.class);
        EmpInfo ei = em.findAllEmp(7369);
        System.out.println(ei);
        System.out.println(ei.getDi());
        session.close();
    }
    public static void b(){
        InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = ssf.openSession();
        DeptMapper em = session.getMapper(DeptMapper.class);
        em.findByDeptNo(10);
        session.close();
    }
    public static void main(String[] args) {
        a();

    }
}
