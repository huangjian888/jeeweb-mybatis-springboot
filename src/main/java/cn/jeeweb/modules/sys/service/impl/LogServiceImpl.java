package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.Log;
import cn.jeeweb.modules.sys.mapper.LogMapper;
import cn.jeeweb.modules.sys.service.ILogService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@Service("logService")
public class LogServiceImpl extends CommonServiceImpl<LogMapper,Log> implements ILogService {
	@Override
	public Page<Log> selectPage(Page<Log> page, Wrapper<Log> wrapper) {
		wrapper.eq("1", "1");
		page.setRecords(baseMapper.selectLogPage(page, wrapper));
		return page;
	}

	@Override
	public Page<Log> selectLogPageByTime(Page<Log> page, Date startTime, Date endTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _startTime = formatter.format(startTime);
		String _endTime = formatter.format(endTime);
		page.setRecords(baseMapper.selectLogPageByTime(page,_startTime,_endTime));
		return page;
	}
}
