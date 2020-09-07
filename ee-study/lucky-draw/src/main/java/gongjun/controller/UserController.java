package gongjun.controller;

import gongjun.model.Setting;
import gongjun.model.User;
import gongjun.service.SettingService;
import gongjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    SettingService settingService;


    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req) {
        //exist 为数据库查询的数据，不为空登录成功
        User exist = userService.login(user);
        //提供一个方法根据用户id获取settingId TODO
        Setting setting = settingService.query(exist.getId());
        exist.setSettingId(setting.getId());
        HttpSession session = req.getSession();
        session.setAttribute("user", exist);
        return null;

    }

    /**
     * 没有做服务器请求参数的校验，实现方式：框架校验和手动校验
     *
     * @param user
     * @param headFile
     * @return
     */
    @PostMapping("/register")
    public Object register(User user,
                           @RequestPart(value = "headFile", required = false) MultipartFile headFile) {//@RequestPart做文件上传的注解
        //将上传的头像保存到服务器特定的文件夹（WEB服务需要加载到）
        //url存放在注册用户的head字段
        //TODO
        userService.register(user, headFile);

        return null;
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }

}
