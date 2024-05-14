package com.dao;

import com.entity.XuejiyidongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuejiyidongView;

/**
 * 学籍异动 Dao 接口
 *
 * @author 
 */
public interface XuejiyidongDao extends BaseMapper<XuejiyidongEntity> {

   List<XuejiyidongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
