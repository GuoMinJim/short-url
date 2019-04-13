package cn.pzhu.shorturl.controller;

import cn.pzhu.shorturl.service.ViewService;
import com.alibaba.druid.util.DruidWebUtils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

  @Autowired
  ViewService viewService;

  @GetMapping("/")
  public String index(HttpServletRequest request){
    // 将真实ip传到service进行处理
    viewService.insertView(DruidWebUtils.getRemoteAddr(request),request);
    HttpSession session = request.getSession();
    // 把用户可以diy的放入session中
    session.setAttribute("diys",viewService.listDiyUrls());
    // 把访问量放入session
    session.setAttribute("views", viewService.countVies());
    return "index";
  }

  /**
   * 获取所有diy的接口
   * @return
   */
  @GetMapping("/diy")
  @ResponseBody
  public List<String> getDiy() {
    return viewService.listDiyUrls();
  }
}
