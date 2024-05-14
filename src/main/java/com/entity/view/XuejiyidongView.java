package com.entity.view;

import com.entity.XuejiyidongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学籍异动
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xuejiyidong")
public class XuejiyidongView extends XuejiyidongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请项目的值
		*/
		private String xuejiyidongValue;
		/**
		* 申请状态的值
		*/
		private String xuejiyidongYesnoValue;



		//级联表 yonghu
			/**
			* 学号
			*/
			private String yonghuUuidNumber;
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 家庭地址
			*/
			private String yonghuAddress;
			/**
			* 学院
			*/
			private Integer xueyuanTypes;
				/**
				* 学院的值
				*/
				private String xueyuanValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 学籍状态
			*/
			private Integer xuejiTypes;
				/**
				* 学籍状态的值
				*/
				private String xuejiValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public XuejiyidongView() {

	}

	public XuejiyidongView(XuejiyidongEntity xuejiyidongEntity) {
		try {
			BeanUtils.copyProperties(this, xuejiyidongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请项目的值
			*/
			public String getXuejiyidongValue() {
				return xuejiyidongValue;
			}
			/**
			* 设置： 申请项目的值
			*/
			public void setXuejiyidongValue(String xuejiyidongValue) {
				this.xuejiyidongValue = xuejiyidongValue;
			}
			/**
			* 获取： 申请状态的值
			*/
			public String getXuejiyidongYesnoValue() {
				return xuejiyidongYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setXuejiyidongYesnoValue(String xuejiyidongYesnoValue) {
				this.xuejiyidongYesnoValue = xuejiyidongYesnoValue;
			}
















				//级联表的get和set yonghu

					/**
					* 获取： 学号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 家庭地址
					*/
					public String getYonghuAddress() {
						return yonghuAddress;
					}
					/**
					* 设置： 家庭地址
					*/
					public void setYonghuAddress(String yonghuAddress) {
						this.yonghuAddress = yonghuAddress;
					}

					/**
					* 获取： 学院
					*/
					public Integer getXueyuanTypes() {
						return xueyuanTypes;
					}
					/**
					* 设置： 学院
					*/
					public void setXueyuanTypes(Integer xueyuanTypes) {
						this.xueyuanTypes = xueyuanTypes;
					}


						/**
						* 获取： 学院的值
						*/
						public String getXueyuanValue() {
							return xueyuanValue;
						}
						/**
						* 设置： 学院的值
						*/
						public void setXueyuanValue(String xueyuanValue) {
							this.xueyuanValue = xueyuanValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}

					/**
					* 获取： 学籍状态
					*/
					public Integer getXuejiTypes() {
						return xuejiTypes;
					}
					/**
					* 设置： 学籍状态
					*/
					public void setXuejiTypes(Integer xuejiTypes) {
						this.xuejiTypes = xuejiTypes;
					}


						/**
						* 获取： 学籍状态的值
						*/
						public String getXuejiValue() {
							return xuejiValue;
						}
						/**
						* 设置： 学籍状态的值
						*/
						public void setXuejiValue(String xuejiValue) {
							this.xuejiValue = xuejiValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}


}
