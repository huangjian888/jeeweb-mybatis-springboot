package cn.jeeweb.modules.sys.mapper;

import cn.jeeweb.modules.sys.entity.Dict;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
	List<Dict> selectDictList();
}