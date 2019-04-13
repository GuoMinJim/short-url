package cn.pzhu.shorturl.dao.dao;

import cn.pzhu.shorturl.domain.View;
import tk.mybatis.mapper.common.Mapper;

public interface ViewMapper extends Mapper<View> {
  String countAllViews();
}