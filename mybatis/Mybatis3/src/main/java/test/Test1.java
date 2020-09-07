package test;

import bean.EmpInfo;
import mapper.EmpMapper;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void a(){
        InputStream in = ResolverUtil.Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = ssf.openSession();
        EmpMapper em = session.getMapper(EmpMapper.class);
        EmpInfo ei = new EmpInfo();
        ei.setSal(1500.0);
        ei.setJob("SALESMAN");
        List<EmpInfo> list = em.findAllEmp(ei);
        for(EmpInfo ee:list){
            System.out.println(ee);
        }
    }

    public static  void b(){
        InputStream in = ResolverUtil.Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = ssf.openSession();
        EmpMapper em = session.getMapper(EmpMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("id",3);
        List<EmpInfo> list = em.findAllEmp2(map);
        for(EmpInfo e:list){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        b();
    }
}
