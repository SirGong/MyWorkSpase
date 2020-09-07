package servlet;

import bean.CityInfo;
import bean.ProvinceInfo;
import mapper.ProvinceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@WebServlet("/prov")
public class ProvinceServlet extends HttpServlet {
    private ProvinceMapper pm;

    public void init() throws ServletException {
        InputStream in = ProvinceServlet.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = ssf.openSession();
        pm = session.getMapper(ProvinceMapper.class);
    }

    // 获取所有省的信息
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<ProvinceInfo> list = pm.findAllProvince();
        String jsonStr = "[";
        for(ProvinceInfo pi:list){
            jsonStr+="{";
            jsonStr+="\"id\":\""+pi.getProvinceId()+"\",";
            jsonStr+="\"name\":\""+pi.getProvince()+"\"";
            jsonStr+="},";
        }
        jsonStr = jsonStr.substring(0,jsonStr.length()-1);
        jsonStr+="]";
        out.print(jsonStr);
        out.flush();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(222);
        int provinceId = Integer.parseInt(request.getParameter("id"));
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<ProvinceInfo> list = pm.findAllProvince();
        Set<CityInfo> set = null;
        for(ProvinceInfo pi:list){
            if(provinceId==pi.getProvinceId()){
                set = pi.getCitySet();
                break;
            }
        }


        String jsonStr = "[";
        System.out.println(set);
        for(CityInfo ci:set){
            jsonStr+="{";
            jsonStr+="\"id\":\""+ci.getCityId()+"\",";
            jsonStr+="\"name\":\""+ci.getCity()+"\"";
            jsonStr+="},";
        }
        jsonStr = jsonStr.substring(0,jsonStr.length()-1);
        jsonStr+="]";
        System.out.println(jsonStr);
        out.print(jsonStr);
        out.flush();



    }
}
