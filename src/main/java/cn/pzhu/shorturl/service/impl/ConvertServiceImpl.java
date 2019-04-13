package cn.pzhu.shorturl.service.impl;

import cn.pzhu.shorturl.dao.dao.UrlmappingMapper;
import cn.pzhu.shorturl.domain.Urlmapping;
import cn.pzhu.shorturl.service.ConvertService;
import cn.pzhu.shorturl.util.ConversionUtil;
import cn.pzhu.shorturl.util.DateFormateUtil;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 转换Url的实现
 */
@Service
public class ConvertServiceImpl implements ConvertService {

  @Autowired
  UrlmappingMapper urlmappingMapper;

  @Autowired
  RedisTemplate redisTemplate;

  @Override
  public String convertLong2Short(String longUrl, String diyUrl, String ipAddr, String length) {
    // 再判断是否已经压缩过
    String longUrlTemp = urlmappingMapper.findByLong(longUrl);
    if (!StringUtils.isNotEmpty(longUrlTemp)) {
      // 最后一条自增的id值
      String lastIdStr = urlmappingMapper.findLastId();
      lastIdStr = (lastIdStr == null) ? "0" : lastIdStr;
      int lastId = Integer.valueOf(lastIdStr);
      // 处理长度
      int urlLength = (StringUtils.isNotEmpty(length)) ? Integer.valueOf(length) : 7;
      String encode = ConversionUtil.encode(lastId + 1, urlLength);
      String shortUrl = "Http://" + diyUrl + "/" + encode;
      // 将这条数据持久化到数据库中
      urlmappingMapper.insert(new Urlmapping(shortUrl, longUrl, new Date()));
      return shortUrl;
    } else {
      return longUrlTemp;
    }
  }

  @Override
  public String findLongByShort(String shortUrl) {
    // 从数据库查询对应的长链接
    String longUrl = urlmappingMapper.findLongByShort(shortUrl);
    // 如果查询为空 则返回提示信息
    return StringUtils.isNotEmpty(longUrl) ? longUrl : "此短链接未对应长连接";
  }
}
