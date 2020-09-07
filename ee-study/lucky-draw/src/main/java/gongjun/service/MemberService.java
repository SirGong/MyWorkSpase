package gongjun.service;

import gongjun.mapper.MemberMapper;
import gongjun.model.Member;
import gongjun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> query(Member member) {
        //根据非主键字段进行查询
        List<Member> members = memberMapper.selectByCondition(member);
        return members;
    }

    //完成抽奖人员的添加
    @Transactional
    public void add(Member member,HttpSession session) {
        User user = (User) session.getAttribute("user");
        member.setUserId(user.getId());//设置抽奖人员的 ID
        member.setCreateTime(new Date());//设置时间
        memberMapper.insert(member);
    }

    //根据主键修改抽奖人员
    @Transactional
    public void updateMember(Member member,HttpSession session) {
        User user  = (User) session.getAttribute("user");
        member.setUserId(user.getId());
        memberMapper.updateByPrimaryKey(member);
    }

    //根据抽奖人员id删除抽奖人员
    @Transactional
    public void delete(Integer id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}
