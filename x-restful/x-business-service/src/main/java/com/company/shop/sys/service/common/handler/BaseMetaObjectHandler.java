//package com.company.shop.sys.service.common.handler;
//
//import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
//import DataBaseConstant;
//import DataBaseFieldConstant;
//import org.apache.ibatis.reflection.MetaObject;
//
//import java.util.Date;
//
///**
// *
// * @description: 填充创建时间，创建人，更新时间，更新人
// *
// */
//public class BaseMetaObjectHandler extends MetaObjectHandler {
//	/**
//	 * 删除标记
//	 */
//	public static final String DEL_FLAG = "delFlag";
//	/**
//	 * 创建时间
//	 */
//	public static final String CREATE_BY = "createBy";
//	/**
//	 * 创建时间
//	 */
//	public static final String CREATE_DATE = "createDate";
//	/**
//	 * 创建时间
//	 */
//	public static final String UPDATE_BY = "updateBy";
//	/**
//	 * 更新时间
//	 */
//	public static final String UPDATE_DATE = "updateDate";
//
//	/**
//	 * 新增
//	 */
//	public void insertFill(MetaObject metaObject) {
//		// 创建用户
//		Object createBy = getFieldValByName(DataBaseFieldConstant.CREATE_BY, metaObject);
//		if (createBy == null) {
//			setFieldValByName(DataBaseFieldConstant.CREATE_BY, UserUtils.getUser(), metaObject);
//		}
//
//		// 创建时间
//		Object createDate = getFieldValByName(DataBaseFieldConstant.CREATE_DATE, metaObject);
//		if (createDate == null) {
//			setFieldValByName(DataBaseFieldConstant.CREATE_DATE, new Date(), metaObject);
//		}
//
//		// 删除标记
//		Object delFlag = getFieldValByName(DataBaseFieldConstant.DEL_FLAG, metaObject);
//		if (delFlag == null) {
//			setFieldValByName(DataBaseFieldConstant.DEL_FLAG, DataBaseConstant.DEL_FLAG_NORMAL, metaObject);
//		}
//	}
//
//	@Override
//	public void updateFill(MetaObject metaObject) {
//		// 更新用户
//		Object updateBy = getFieldValByName(DataBaseFieldConstant.UPDATE_BY, metaObject);
//		if (updateBy == null) {
//			setFieldValByName(DataBaseFieldConstant.UPDATE_BY, UserUtils.getUser(), metaObject);
//		}
//
//		// 更新用户
//		Object updateDate = getFieldValByName(DataBaseFieldConstant.UPDATE_DATE, metaObject);
//		if (updateDate == null) {
//			setFieldValByName(DataBaseFieldConstant.UPDATE_DATE, new Date(), metaObject);
//		}
//	}
//}