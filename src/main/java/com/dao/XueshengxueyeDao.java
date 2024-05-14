package com.dao;

import com.entity.XueshengxueyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengxueyeView;

/**
 * 学生学业 Dao 接口
 *
 * @author 
 */
public interface XueshengxueyeDao extends BaseMapper<XueshengxueyeEntity> {

   List<XueshengxueyeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
