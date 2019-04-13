package cn.pzhu.shorturl.service.impl;

import cn.pzhu.shorturl.dao.dao.DiyurlMapper;
import cn.pzhu.shorturl.dao.dao.ViewMapper;
import cn.pzhu.shorturl.domain.View;
import cn.pzhu.shorturl.service.ViewService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {


  @Autowired
  RedisTemplate redisTemplate;

  @Autowired
  ViewMapper viewMapper;

  @Autowired
  DiyurlMapper diyurlMapper;

  @Override
  public void insertView(String ipAddr, HttpServletRequest request) {
    viewMapper.insert(new View(ipAddr,new Date()));
  }

  @Override
  public List<String> listDiyUrls() {
    return diyurlMapper.getDiyUrls();
  }

  @Override
  public String countVies() {
    return viewMapper.countAllViews();
  }

  @Deprecated
  public String getIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");
    if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
      //多次反向代理后会有多个ip值，第一个ip才是真实ip
      int index = ip.indexOf(",");
      if (index != -1) {
        return ip.substring(0, index);
      } else {
        return ip;
      }
    }
    ip = request.getHeader("X-Real-IP");
    if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
      return ip;
    }
    return request.getRemoteAddr();
  }
}
