package cn.pzhu.shorturl.dao.dao;

import cn.pzhu.shorturl.domain.Diyurl;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface DiyurlMapper extends Mapper<Diyurl> {

  List<String> getDiyUrls();
}