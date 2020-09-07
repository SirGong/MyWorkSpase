package gongjun.controller;

import gongjun.model.Setting;
import gongjun.model.User;
import gongjun.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController//返回json数据
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    /**
     * cookie携带Tomcat的session实现，也就是请求头中携带JSESSIONID=XXXX
     * 比如服务器重启，没有登录但携带 JSESSIONID的信息，获取的HTTPSession对象不为空
     * 此时要判断设置的key和值，判断值不为空才是登录
     * 如果不实现连接器，需要实现以上的逻辑
     * 如果实现拦截器，一定要先登录才能访问该接口
     */
    @GetMapping("/query")
    public Object query(HttpSession session){
        //登录以后才能访问接口，从会话中取出user的信息
        User user = (User)session.getAttribute("user");
        Setting setting = settingService.query(user.getId());
        setting.setUser(user);

        return setting;
    }

    @GetMapping("/update")
    public Object update(Integer batchNumber,HttpSession session){
        //从session中获取到已经登录的用户
        User user = (User) session.getAttribute("user");
        settingService.update(user.getId(),batchNumber);
        return null;
    }
}
