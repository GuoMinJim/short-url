package cn.pzhu.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.pzhu.shorturl.dao.dao")
@ComponentScan("cn.pzhu.shorturl")
@Configuration
public class ShorturlApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ShorturlApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(ShorturlApplication.class, args);
  }

}
