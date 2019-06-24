package com.company.manerger.sys.common.mp3.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import java.util.List;

/**
 * @description: 自动注入器
 *
 */
public class AutoSqlInjector extends DefaultSqlInjector {
	@Override
	public List<AbstractMethod> getMethodList() {
		/**
		 * 默认使用mp3的方法
		 */
		return super.getMethodList();
	}
}
