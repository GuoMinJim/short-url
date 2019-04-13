package cn.pzhu.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.pzhu.shorturl.dao.dao")
@ComponentScan("cn.pzhu.shorturl")
public class ShorturlApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShorturlApplication.class, args);
  }

}
