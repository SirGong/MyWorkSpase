package gongjun.mapper;

import gongjun.base.BaseMapper;
import gongjun.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}