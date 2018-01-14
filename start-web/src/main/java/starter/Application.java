package starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(basePackages = {"api","service","mapper"})
@EnableCaching
@SpringBootApplication
@MapperScan("mapper")
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new ApplicationPidFileWriter("app.pid"));
        app.run(args);
    }
}