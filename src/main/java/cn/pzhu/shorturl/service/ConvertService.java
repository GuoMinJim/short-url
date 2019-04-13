package cn.pzhu.shorturl.service;

/**
 * 转换url
 */
public interface ConvertService {

  /**
   * 将长网址转换成短网址
   * @param longUrl
   * @param diyUrl
   * @return
   */
  String convertLong2Short(String longUrl, String diyUrl, String ipAddr,String length);

  /**
   * 根据短网址在数据库查找长网址
   * @param shortUrl
   * @return
   */
  String findLongByShort(String shortUrl);


}
