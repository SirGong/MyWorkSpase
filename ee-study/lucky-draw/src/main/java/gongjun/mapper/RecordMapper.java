package gongjun.mapper;

import gongjun.base.BaseMapper;
import gongjun.model.Record;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    void deleteByCondition(Record record);
}