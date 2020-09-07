package gongjun.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import gongjun.base.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;

    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 如果session不等与空且其中的user不等于空，继续执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {
            return true;//继续执行controller中的方法
        }
        //处理乱码
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);//浏览器用来解析数据格式的编码
        response.setCharacterEncoding("UTF-8");//和Java文件的编码一致

        response.setStatus(HttpStatus.UNAUTHORIZED.value());//401,前端通过状态码已经处理了，可以不返回以下响应内容

        ResponseResult res = ResponseResult.error("SES0000","用户未登录，请先登录！");
        PrintWriter pw = response.getWriter();
        pw.println(objectMapper.writeValueAsString(res));
        pw.flush();

        return false;
    }
}
