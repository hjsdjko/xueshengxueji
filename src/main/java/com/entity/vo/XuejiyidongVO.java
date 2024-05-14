package com.entity.vo;

import com.entity.XuejiyidongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学籍异动
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuejiyidong")
public class XuejiyidongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
