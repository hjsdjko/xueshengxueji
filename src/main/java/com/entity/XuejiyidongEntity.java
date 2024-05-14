package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 学籍异动
 *
 * @author 
 * @email
 */
@TableName("xuejiyidong")
public class XuejiyidongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuejiyidongEntity() {

	}

	public XuejiyidongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 申请原因
     */
    @TableField(value = "xuejiyidong_text")

    private String xuejiyidongText;


    /**
     * 申请文件
     */
    @TableField(value = "xuejiyidong_file")

    private String xuejiyidongFile;


    /**
     * 申请项目
     */
    @TableField(value = "xuejiyidong_types")

    private Integer xuejiyidongTypes;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请状态
     */
    @TableField(value = "xuejiyidong_yesno_types")

    private Integer xuejiyidongYesnoTypes;


    /**
     * 申请结果
     */
    @TableField(value = "xuejiyidong_yesno_text")

    private String xuejiyidongYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：申请原因
	 */
    public String getXuejiyidongText() {
        return xuejiyidongText;
    }
    /**
	 * 获取：申请原因
	 */

    public void setXuejiyidongText(String xuejiyidongText) {
        this.xuejiyidongText = xuejiyidongText;
    }
    /**
	 * 设置：申请文件
	 */
    public String getXuejiyidongFile() {
        return xuejiyidongFile;
    }
    /**
	 * 获取：申请文件
	 */

    public void setXuejiyidongFile(String xuejiyidongFile) {
        this.xuejiyidongFile = xuejiyidongFile;
    }
    /**
	 * 设置：申请项目
	 */
    public Integer getXuejiyidongTypes() {
        return xuejiyidongTypes;
    }
    /**
	 * 获取：申请项目
	 */

    public void setXuejiyidongTypes(Integer xuejiyidongTypes) {
        this.xuejiyidongTypes = xuejiyidongTypes;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getXuejiyidongYesnoTypes() {
        return xuejiyidongYesnoTypes;
    }
    /**
	 * 获取：申请状态
	 */

    public void setXuejiyidongYesnoTypes(Integer xuejiyidongYesnoTypes) {
        this.xuejiyidongYesnoTypes = xuejiyidongYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getXuejiyidongYesnoText() {
        return xuejiyidongYesnoText;
    }
    /**
	 * 获取：申请结果
	 */

    public void setXuejiyidongYesnoText(String xuejiyidongYesnoText) {
        this.xuejiyidongYesnoText = xuejiyidongYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xuejiyidong{" +
            "id=" + id +
            ", xuejiyidongText=" + xuejiyidongText +
            ", xuejiyidongFile=" + xuejiyidongFile +
            ", xuejiyidongTypes=" + xuejiyidongTypes +
            ", yonghuId=" + yonghuId +
            ", xuejiyidongYesnoTypes=" + xuejiyidongYesnoTypes +
            ", xuejiyidongYesnoText=" + xuejiyidongYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
