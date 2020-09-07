package gongjun.controller;

import gongjun.model.Award;
import gongjun.model.User;
import gongjun.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/award")
public class AwardController {
    @Autowired
    private AwardService awardService;

    @PostMapping("/add")
    public Object add(@RequestBody Award award, HttpSession session) {//插入时请求数据不带 id
        User user = (User) session.getAttribute("user");
        award.setSettingId(user.getSettingId());
        awardService.add(award);
        return award.getId();//数据库插入时生成的id要返回给前端
    }

    @PostMapping("/update")
    public Object update(@RequestBody Award award) {//修改时是根据 id 去修改的
        awardService.update(award);
        return null;
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable("id") Integer id){
        awardService.delete(id);

        return null;
    }
}
