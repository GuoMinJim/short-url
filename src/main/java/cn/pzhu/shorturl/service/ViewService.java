package cn.pzhu.shorturl.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface ViewService {

  /**
   * 插入此条访问数据
   * @param ipAddr
   */
  void insertView(String ipAddr, HttpServletRequest request);

  /**
   * 获取diy的地址数据
   */
  List<String> listDiyUrls();

  /**
   * 获取本站访问量
   */
  String countVies();
}
