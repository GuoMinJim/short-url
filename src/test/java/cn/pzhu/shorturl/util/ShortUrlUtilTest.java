package cn.pzhu.shorturl.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShortUrlUtilTest {

  @Test
  public void shortText() {
    String[] shortText = ShortUrlUtil.ShortText("https://segmentfault.com/a/1190000012088345");
    for (String url : shortText) {
      System.out.println(url);
    }
  }
}