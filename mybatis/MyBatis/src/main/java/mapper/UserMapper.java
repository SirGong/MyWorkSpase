package mapper;

import bean.PageInfo;
import bean.UserInfo;

import java.util.List;
import java.util.Map;

//对应bean包中的UserInfo类，其实这个就是原来dao包中的userInfoDAO
public interface UserMapper {
    List<UserInfo>findAllUser();
    void deleteUser(int userId);
    void saveUser(UserInfo ui);
    void updateUser(UserInfo ui);
    //通过Map集合封装参数分页查找
    List<UserInfo> findUser1(Map<String,Integer> map);
    //通过封装类封装参数分页查找
    List<UserInfo> findUser2(PageInfo pi);
    //检索模糊查询
    List<UserInfo> searchUser(String name);
    //通过主键查找用户信息
    UserInfo findByUserId(int userId);
}
