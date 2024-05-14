package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YonghuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学号
     */
    private String yonghuUuidNumber;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 学生姓名
     */
    private String yonghuName;


    /**
     * 家庭地址
     */
    private String yonghuAddress;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 学院
     */
    private Integer xueyuanTypes;


    /**
     * 班级
     */
    private Integer banjiTypes;


    /**
     * 学籍状态
     */
    private Integer xuejiTypes;


    /**
     * 假删
     */
    private Integer yonghuDelete;


    /**
     * 创建时间
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
	 * 获取：学号
	 */
    public String getYonghuUuidNumber() {
        return yonghuUuidNumber;
    }


    /**
	 * 设置：学号
	 */
    public void setYonghuUuidNumber(String yonghuUuidNumber) {
        this.yonghuUuidNumber = yonghuUuidNumber;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：学生姓名
	 */
    public String getYonghuName() {
        return yonghuName;
    }


    /**
	 * 设置：学生姓名
	 */
    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }
    /**
	 * 获取：家庭地址
	 */
    public String getYonghuAddress() {
        return yonghuAddress;
    }


    /**
	 * 设置：家庭地址
	 */
    public void setYonghuAddress(String yonghuAddress) {
        this.yonghuAddress = yonghuAddress;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：学院
	 */
    public Integer getXueyuanTypes() {
        return xueyuanTypes;
    }


    /**
	 * 设置：学院
	 */
    public void setXueyuanTypes(Integer xueyuanTypes) {
        this.xueyuanTypes = xueyuanTypes;
    }
    /**
	 * 获取：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }


    /**
	 * 设置：班级
	 */
    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 获取：学籍状态
	 */
    public Integer getXuejiTypes() {
        return xuejiTypes;
    }


    /**
	 * 设置：学籍状态
	 */
    public void setXuejiTypes(Integer xuejiTypes) {
        this.xuejiTypes = xuejiTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getYonghuDelete() {
        return yonghuDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setYonghuDelete(Integer yonghuDelete) {
        this.yonghuDelete = yonghuDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
