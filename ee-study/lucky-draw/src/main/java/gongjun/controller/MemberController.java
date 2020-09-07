package gongjun.controller;

import gongjun.model.Member;
import gongjun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Object add(@RequestBody Member member, HttpSession session){
        memberService.add(member,session);
        return member.getId();//将自增主键返回给前端
    }

    @PostMapping("/update")
    public Object updateMember(@RequestBody Member member,HttpSession session){
        memberService.updateMember(member,session);
        return null;
    }

    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable("id") Integer id){
        memberService.delete(id);
        return null;
    }
}
