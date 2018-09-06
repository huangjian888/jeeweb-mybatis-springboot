package cn.jeeweb.modules.sys.service;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.sys.entity.Log;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @author jeeweb
 * @date 2017-02-21 16:49:56
 * @version V1.0
 *
 */
public interface ILogService extends ICommonService<Log> {
    Page<Log> selectLogPageByTime(Page<Log> page, Date startTime, Date endTime);
}
