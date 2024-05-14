package com.dao;

import com.entity.JiaowurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaowurenyuanView;

/**
 * 教务人员姓名 Dao 接口
 *
 * @author 
 */
public interface JiaowurenyuanDao extends BaseMapper<JiaowurenyuanEntity> {

   List<JiaowurenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
