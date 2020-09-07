package gongjun.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import gongjun.config.interceptor.LoginInterceptor;
import gongjun.config.web.RequestResponseBodyMethodProcessorWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//和之前的@ControllerAdvice实现ResponseBodyAdvice接口，完成统一处理返回数据包装，无法解决数据为null包装的自定义数据问题
//现在的这种方式，可以解决包装的数据为null包装的自定义数据问题
@Configuration
public class SysConfig implements WebMvcConfigurer, InitializingBean {

    @Resource
    private RequestMappingHandlerAdapter adapter;

    @Autowired
    private ObjectMapper objectMapper;//SpringMVC初始化操作时就会注册的对象

    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        for (int i = 0; i < handlers.size(); i++) {
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                handlers.set(i, new RequestResponseBodyMethodProcessorWrapper(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器
        registry.addInterceptor(new LoginInterceptor(objectMapper)).addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/logout");
        //添加有个前端静态资源请求的拦截器，如非登录页面（/index.html）
        //拦截（/*.html  排除/index.html）如果没有登录，从定向到index.html
    }

    //添加后台路径前缀映射
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //c->true：不管三七二十一，后台controller统一添加前缀，true/false表示是否添加
        configurer.addPathPrefix("api", c -> true);
    }
}


