package cn.pzhu.shorturl.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MD5UtilTest {

  @Test
  public void byteArrayToHexString() {
  }

  @Test
  public void MD5Encode() {
    System.out.println(MD5Util.MD5Encode("130"));
  }
}