package cn.pzhu.shorturl;

import cn.pzhu.shorturl.service.ConvertService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ShorturlApplication.class)
@RunWith(SpringRunner.class)
public class TestConvertService {

  @Autowired
  ConvertService convertService;


  @Test
  public void testDecode() {
    String s = convertService
        .convertLong2Short("https://blog.csdn.net/lmb55/article/details/82470388", "sin.a", "",
            "10");
    System.out.println(s);
  }

  @Test
  public void testEncode(){
    String longByShort = convertService.findLongByShort("Http://sina.it/000000D");
    System.out.println(longByShort);
  }
}
