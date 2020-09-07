package gongjun.mapper;

import gongjun.base.BaseMapper;
import gongjun.model.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {
    //传入参数有多个是需要使用@param注解指定名称,xml文件中使用自己指定的名称
    int updateByUserId(@Param("userId") Integer id,@Param("batchNumber") Integer batchNumber);
}