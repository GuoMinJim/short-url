package cn.pzhu.shorturl.dao.dao;

import cn.pzhu.shorturl.domain.Urlmapping;
import tk.mybatis.mapper.common.Mapper;

public interface UrlmappingMapper extends Mapper<Urlmapping> {

  /**
   * 查找最后一条数据的id
   */
  String findLastId();

  /**
   * 根据短链接找长链接
   * @param shortUrl
   * @return
   */
  String findLongByShort(String shortUrl);

  /**
   * 寻找是否已经压缩过
   */
  String findByLong(String longUrl);

}