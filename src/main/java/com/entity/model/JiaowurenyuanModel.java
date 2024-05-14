package com.entity.model;

import com.entity.JiaowurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教务人员姓名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaowurenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 工号
     */
    private String jiaowurenyuanUuidNumber;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 教务人员姓名
     */
    private String jiaowurenyuanName;


    /**
     * 身份证号
     */
    private String jiaowurenyuanIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer jiaowurenyuanDelete;


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
	 * 获取：工号
	 */
    public String getJiaowurenyuanUuidNumber() {
        return jiaowurenyuanUuidNumber;
    }


    /**
	 * 设置：工号
	 */
    public void setJiaowurenyuanUuidNumber(String jiaowurenyuanUuidNumber) {
        this.jiaowurenyuanUuidNumber = jiaowurenyuanUuidNumber;
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
	 * 获取：教务人员姓名
	 */
    public String getJiaowurenyuanName() {
        return jiaowurenyuanName;
    }


    /**
	 * 设置：教务人员姓名
	 */
    public void setJiaowurenyuanName(String jiaowurenyuanName) {
        this.jiaowurenyuanName = jiaowurenyuanName;
    }
    /**
	 * 获取：身份证号
	 */
    public String getJiaowurenyuanIdNumber() {
        return jiaowurenyuanIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setJiaowurenyuanIdNumber(String jiaowurenyuanIdNumber) {
        this.jiaowurenyuanIdNumber = jiaowurenyuanIdNumber;
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
	 * 获取：假删
	 */
    public Integer getJiaowurenyuanDelete() {
        return jiaowurenyuanDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setJiaowurenyuanDelete(Integer jiaowurenyuanDelete) {
        this.jiaowurenyuanDelete = jiaowurenyuanDelete;
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
