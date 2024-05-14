package com.entity.model;

import com.entity.XueshengxueyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生学业
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengxueyeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学业情况
     */
    private String xueshengxueyeName;


    /**
     * 学业状态
     */
    private Integer xueshengxueyeTypes;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 备注信息
     */
    private String xueshengxueyeText;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学业情况
	 */
    public String getXueshengxueyeName() {
        return xueshengxueyeName;
    }


    /**
	 * 设置：学业情况
	 */
    public void setXueshengxueyeName(String xueshengxueyeName) {
        this.xueshengxueyeName = xueshengxueyeName;
    }
    /**
	 * 获取：学业状态
	 */
    public Integer getXueshengxueyeTypes() {
        return xueshengxueyeTypes;
    }


    /**
	 * 设置：学业状态
	 */
    public void setXueshengxueyeTypes(Integer xueshengxueyeTypes) {
        this.xueshengxueyeTypes = xueshengxueyeTypes;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：备注信息
	 */
    public String getXueshengxueyeText() {
        return xueshengxueyeText;
    }


    /**
	 * 设置：备注信息
	 */
    public void setXueshengxueyeText(String xueshengxueyeText) {
        this.xueshengxueyeText = xueshengxueyeText;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
