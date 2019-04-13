package cn.pzhu.shorturl.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversionUtilTest {

  @Test
  public void encode() {
    System.out.println(ConversionUtil.encode(1235456,7));
  }

  @Test
  public void decode() {
    System.out.println(ConversionUtil.decode("5BOi"));
  }
}