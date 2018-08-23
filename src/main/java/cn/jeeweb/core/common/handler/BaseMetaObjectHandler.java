package cn.jeeweb.core.common.handler;

import cn.jeeweb.core.common.constant.DataBaseConstant;
import cn.jeeweb.core.common.constant.DataBaseFieldConstant;
import cn.jeeweb.modules.sys.utils.UserUtils;
import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: MyMetaObjectHandler.java
 * @package cn.jeeweb.core.common.handler
 * @description: 填充创建时间，创建人，更新时间，更新人
 * @author: auth_team
 * @date: 2017年7月20日 上午10:55:42
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class BaseMetaObjectHandler extends MetaObjectHandler {

	/**
	 * 新增
	 */
	public void insertFill(MetaObject metaObject) {
		// 创建用户
		Object createBy = getFieldValByName(DataBaseFieldConstant.CREATE_BY, metaObject);
		if (createBy == null) {
			setFieldValByName(DataBaseFieldConstant.CREATE_BY, UserUtils.getUser(), metaObject);
		}

		// 创建时间
		Object createDate = getFieldValByName(DataBaseFieldConstant.CREATE_DATE, metaObject);
		if (createDate == null) {
			setFieldValByName(DataBaseFieldConstant.CREATE_DATE, new Date(), metaObject);
		}

		// 删除标记
		Object delFlag = getFieldValByName(DataBaseFieldConstant.DEL_FLAG, metaObject);
		if (delFlag == null) {
			setFieldValByName(DataBaseFieldConstant.DEL_FLAG, DataBaseConstant.DEL_FLAG_NORMAL, metaObject);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		// 更新用户
		Object updateBy = getFieldValByName(DataBaseFieldConstant.UPDATE_BY, metaObject);
		if (updateBy == null) {
			setFieldValByName(DataBaseFieldConstant.UPDATE_BY, UserUtils.getUser(), metaObject);
		}

		// 更新用户
		Object updateDate = getFieldValByName(DataBaseFieldConstant.UPDATE_DATE, metaObject);
		if (updateDate == null) {
			setFieldValByName(DataBaseFieldConstant.UPDATE_DATE, new Date(), metaObject);
		}
	}
}