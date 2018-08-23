package cn.jeeweb.core.common.service;

import cn.jeeweb.core.common.data.DuplicateValid;
import cn.jeeweb.core.query.data.Page;
import cn.jeeweb.core.query.data.Queryable;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface ICommonService<T> extends IService<T> {

	public Page<T> list(Queryable queryable);
	
	public Page<T> list(Queryable queryable, Wrapper<T> wrapper);

	public List<T> listWithNoPage(Queryable queryable);

	public List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper);

	Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper);
}