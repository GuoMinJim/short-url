package cn.pzhu.shorturl.controller;

import cn.pzhu.shorturl.service.ConvertService;
import com.alibaba.druid.util.DruidWebUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert/")
public class UrlController {

  @Autowired
  ConvertService convertService;

  @PostMapping("/long2short")
  public String ConvertLong2Short(HttpServletRequest request, String longUrl, String diyUrl,
      String length) {
    String ipAddr = DruidWebUtils.getRemoteAddr(request);
    return convertService.convertLong2Short(longUrl, diyUrl, ipAddr, length);
  }


  @GetMapping("/short2long")
  public String findLongByShort(String shortUrl) {
    return convertService.findLongByShort(shortUrl);
  }
}
