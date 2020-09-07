package gongjun.service;

import gongjun.exception.ClintException;
import gongjun.exception.SystemException;
import gongjun.mapper.UserMapper;
import gongjun.model.Setting;
import gongjun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.soap.SAAJResult;
import java.io.*;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SettingService settingService;

    @Value("${user.head.local-path}")
    private String localPath;
    @Value("${user.head.remote-path}")
    private String remotePath;
    @Value("${user.head.filename}")
    private String fileName;

    public User login(User user) {
//        User exist = userMapper.login(user);
//        if(exist == null)
//            throw new ClintException("USER001","用户名或密码错误！");

        User user1 = new User();
        user1.setUsername(user.getUsername());
        User exist = userMapper.selectOne(user1);

        if (exist == null) {
            throw new ClintException("USR001", "用户名不存在！");
        }
        if (!exist.getPassword().equals(user.getPassword()))
            throw new ClintException("USR002", "用户密码校验失败！");

        return exist;
    }

    /**
     * 该方法用该设置为事务方法，保证操作的原子性
     * @param user
     * @param headFile
     */
    //默认的事务配置为spring事务的传播特性为required,默认的隔离级别为数据库的隔离级别
    @Transactional
    public void register(User user, MultipartFile headFile) {
        //构建头像路径
        String path = "/" + user.getUsername() + "/" + fileName;
        user.setHead(remotePath + path);
        //根据用户名查询注册过来的数据是否存在，存在报异常
        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);
        if(exist!=null){
            throw new ClintException("USR004","用户已经存在！");
        }
        //对用户信息进行保存
        userMapper.insertSelective(user);
        //注册用户时，完成初始化设置，创建setting数据
        Setting setting = new Setting();
        setting.setUserId(user.getId());//插入成功之后，自增主键通过Mybatis设置返回对象
        setting.setBatchNumber(8);
        settingService.add(setting);

        //对上传的头像文件进行保存到本地文件夹
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            try {
                File dir = new File(localPath+"/"+user.getUsername());
                dir.mkdirs();
                fos = new FileOutputStream(localPath + path);
                bos = new BufferedOutputStream(fos);
                bos.write(headFile.getBytes());
                bos.flush();
            } finally {
                if (bos != null)
                    bos.close();

                if (fos != null)
                    fos.close();
            }
        } catch (IOException e) {
            //打印捕获异常，抛出自定义异常
//            e.printStackTrace();
//            throw new SystemException("USR003","用户注册失败，头像上传出错！");

            e.printStackTrace();
            throw new SystemException("USR003","用户注册失败，头像上传出错！",e);
        }
    }
}
