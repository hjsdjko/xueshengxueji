package com.entity.vo;

import com.entity.JiaowurenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教务人员姓名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaowurenyuan")
public class JiaowurenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 工号
     */

    @TableField(value = "jiaowurenyuan_uuid_number")
    private String jiaowurenyuanUuidNumber;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 教务人员姓名
     */

    @TableField(value = "jiaowurenyuan_name")
    private String jiaowurenyuanName;


    /**
     * 身份证号
     */

    @TableField(value = "jiaowurenyuan_id_number")
    private String jiaowurenyuanIdNumber;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 假删
     */

    @TableField(value = "jiaowurenyuan_delete")
    private Integer jiaowurenyuanDelete;


    /**
     * 创建时间
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
	 * 设置：工号
	 */
    public String getJiaowurenyuanUuidNumber() {
        return jiaowurenyuanUuidNumber;
    }


    /**
	 * 获取：工号
	 */

    public void setJiaowurenyuanUuidNumber(String jiaowurenyuanUuidNumber) {
        this.jiaowurenyuanUuidNumber = jiaowurenyuanUuidNumber;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：教务人员姓名
	 */
    public String getJiaowurenyuanName() {
        return jiaowurenyuanName;
    }


    /**
	 * 获取：教务人员姓名
	 */

    public void setJiaowurenyuanName(String jiaowurenyuanName) {
        this.jiaowurenyuanName = jiaowurenyuanName;
    }
    /**
	 * 设置：身份证号
	 */
    public String getJiaowurenyuanIdNumber() {
        return jiaowurenyuanIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setJiaowurenyuanIdNumber(String jiaowurenyuanIdNumber) {
        this.jiaowurenyuanIdNumber = jiaowurenyuanIdNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getJiaowurenyuanDelete() {
        return jiaowurenyuanDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setJiaowurenyuanDelete(Integer jiaowurenyuanDelete) {
        this.jiaowurenyuanDelete = jiaowurenyuanDelete;
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

}
