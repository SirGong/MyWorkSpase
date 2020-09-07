package gongjun.service;

import gongjun.mapper.AwardMapper;
import gongjun.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AwardService {
    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {
        return awardMapper.query(award);
    }

    @Transactional
    public void add(Award award) {
        //1.通过session获取user，通过user的is查询settingId，并设置
        //2.登录的时候就把setting的信息设置到会话当中
        awardMapper.insertSelective(award);
    }

    @Transactional
    public void update(Award award) {
        awardMapper.updateByPrimaryKeySelective(award);
    }

    @Transactional
    public void delete(Integer id) {
        awardMapper.deleteByPrimaryKey(id);
    }
}
