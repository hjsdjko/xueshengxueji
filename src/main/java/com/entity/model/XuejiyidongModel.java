package com.entity.model;

import com.entity.XuejiyidongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学籍异动
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuejiyidongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请原因
     */
    private String xuejiyidongText;


    /**
     * 申请文件
     */
    private String xuejiyidongFile;


    /**
     * 申请项目
     */
    private Integer xuejiyidongTypes;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 申请状态
     */
    private Integer xuejiyidongYesnoTypes;


    /**
     * 申请结果
     */
    private String xuejiyidongYesnoText;


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
	 * 获取：申请原因
	 */
    public String getXuejiyidongText() {
        return xuejiyidongText;
    }


    /**
	 * 设置：申请原因
	 */
    public void setXuejiyidongText(String xuejiyidongText) {
        this.xuejiyidongText = xuejiyidongText;
    }
    /**
	 * 获取：申请文件
	 */
    public String getXuejiyidongFile() {
        return xuejiyidongFile;
    }


    /**
	 * 设置：申请文件
	 */
    public void setXuejiyidongFile(String xuejiyidongFile) {
        this.xuejiyidongFile = xuejiyidongFile;
    }
    /**
	 * 获取：申请项目
	 */
    public Integer getXuejiyidongTypes() {
        return xuejiyidongTypes;
    }


    /**
	 * 设置：申请项目
	 */
    public void setXuejiyidongTypes(Integer xuejiyidongTypes) {
        this.xuejiyidongTypes = xuejiyidongTypes;
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
	 * 获取：申请状态
	 */
    public Integer getXuejiyidongYesnoTypes() {
        return xuejiyidongYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setXuejiyidongYesnoTypes(Integer xuejiyidongYesnoTypes) {
        this.xuejiyidongYesnoTypes = xuejiyidongYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getXuejiyidongYesnoText() {
        return xuejiyidongYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setXuejiyidongYesnoText(String xuejiyidongYesnoText) {
        this.xuejiyidongYesnoText = xuejiyidongYesnoText;
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
