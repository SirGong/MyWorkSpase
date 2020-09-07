package gongjun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gongjun.mapper")//扫描"gongjun.mapper"下带有@Mapper注解的接口，通过mybatis框架,利用AOP生成代理类
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
