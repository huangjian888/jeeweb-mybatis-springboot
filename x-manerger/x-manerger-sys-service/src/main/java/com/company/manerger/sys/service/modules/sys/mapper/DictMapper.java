package com.company.manerger.sys.service.modules.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.manerger.sys.service.modules.sys.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {
	List<Dict> selectDictList();
}