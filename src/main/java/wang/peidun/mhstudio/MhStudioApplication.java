package wang.peidun.mhstudio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("wang.peidun.mhstudio.dao")
public class MhStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MhStudioApplication.class, args);
    }

}
