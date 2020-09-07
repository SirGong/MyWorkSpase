package gongjun.service;

import gongjun.mapper.RecordMapper;
import gongjun.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 添加抽奖成员
     * @param awardId
     * @param memberIds
     */
    public void add(Integer awardId, List<Integer> memberIds) {
        /*
        批量操作：1.循环遍历一次更新
        2.mybatis 批量操作 推荐，效率更高
         */
        for(Integer id:memberIds){
            Record record = new Record();
            record.setMemberId(id);
            record.setAwardId(awardId);
            recordMapper.insertSelective(record);
        }
    }

    @Transactional
    public void deleteByMemberId(Integer id) {
        Record record = new Record();
        record.setMemberId(id);
        recordMapper.deleteByCondition(record);
    }

    @Transactional
    public void deleteByAwardId(Integer id) {
        Record record = new Record();
        record.setAwardId(id);
        recordMapper.deleteByCondition(record);
    }
}
