package my.starblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableScheduling
@MapperScan("my.starblog.dao")
@SpringBootApplication
public class StarblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarblogApplication.class, args);
    }

}
