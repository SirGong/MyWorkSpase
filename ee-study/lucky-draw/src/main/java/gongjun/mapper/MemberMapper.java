package gongjun.mapper;

import gongjun.base.BaseMapper;
import gongjun.model.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}