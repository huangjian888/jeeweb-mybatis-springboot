package com.company.manerger.sys.common.quartz.factory;

import org.quartz.DisallowConcurrentExecution;

/**
 *
 * @description: 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 *
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution extends QuartzJobFactory {
}