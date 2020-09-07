package dao;



import bean.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    List<UserInfo> findAllUser();
    @Select("select * from userinfo where userId=#{id}")
    UserInfo findUserById(int id);
}
