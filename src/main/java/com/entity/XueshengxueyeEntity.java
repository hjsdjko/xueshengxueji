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
 * 学生学业
 *
 * @author 
 * @email
 */
@TableName("xueshengxueye")
public class XueshengxueyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengxueyeEntity() {

	}

	public XueshengxueyeEntity(T t) {
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
     * 学业情况
     */
    @TableField(value = "xueshengxueye_name")

    private String xueshengxueyeName;


    /**
     * 学业状态
     */
    @TableField(value = "xueshengxueye_types")

    private Integer xueshengxueyeTypes;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 备注信息
     */
    @TableField(value = "xueshengxueye_text")

    private String xueshengxueyeText;


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
	 * 设置：学业情况
	 */
    public String getXueshengxueyeName() {
        return xueshengxueyeName;
    }
    /**
	 * 获取：学业情况
	 */

    public void setXueshengxueyeName(String xueshengxueyeName) {
        this.xueshengxueyeName = xueshengxueyeName;
    }
    /**
	 * 设置：学业状态
	 */
    public Integer getXueshengxueyeTypes() {
        return xueshengxueyeTypes;
    }
    /**
	 * 获取：学业状态
	 */

    public void setXueshengxueyeTypes(Integer xueshengxueyeTypes) {
        this.xueshengxueyeTypes = xueshengxueyeTypes;
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
	 * 设置：备注信息
	 */
    public String getXueshengxueyeText() {
        return xueshengxueyeText;
    }
    /**
	 * 获取：备注信息
	 */

    public void setXueshengxueyeText(String xueshengxueyeText) {
        this.xueshengxueyeText = xueshengxueyeText;
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
        return "Xueshengxueye{" +
            "id=" + id +
            ", xueshengxueyeName=" + xueshengxueyeName +
            ", xueshengxueyeTypes=" + xueshengxueyeTypes +
            ", yonghuId=" + yonghuId +
            ", xueshengxueyeText=" + xueshengxueyeText +
            ", createTime=" + createTime +
        "}";
    }
}
