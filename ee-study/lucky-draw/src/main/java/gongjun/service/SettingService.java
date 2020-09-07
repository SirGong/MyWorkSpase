package gongjun.service;

import gongjun.exception.BusinessException;
import gongjun.mapper.SettingMapper;
import gongjun.model.Award;
import gongjun.model.Member;
import gongjun.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;
    //调用其他单表业务查询相关数据
    @Autowired
    private AwardService awardService;
    @Autowired
    private MemberService memberService;

    public Setting query(Integer id) {
        Setting settingQuery = new Setting();
        settingQuery.setUserId(id);
        //注册用户时需要生成一个setting对象，1对1，如果没有生成，说明业务出问题
        Setting setting = settingMapper.selectOne(settingQuery);
        if(setting == null){
            throw new BusinessException("SET001","用户设置信息出错");
        }

        //查询奖品列表,根据设置Id进行查询
        Award award = new Award();
        award.setSettingId(setting.getId());
        List<Award> awards = awardService.query(award);
        setting.setAwards(awards);

        //查询人员列表，根据user_id 查询
        Member member = new Member();
        member.setUserId(id);
        List<Member> members = memberService.query(member);
        setting.setMembers(members);

        return  setting;
    }

    @Transactional
    public void add(Setting setting) {
        settingMapper.insertSelective(setting);
    }
    //默认spring事务设置的传播方式为required，当前没有事务就创建，有就加入
    @Transactional
    public void update(Integer id, Integer batchNumber) {
        //自己写mapper进行条件修改设置
        int res = settingMapper.updateByUserId(id,batchNumber);
    }
}
