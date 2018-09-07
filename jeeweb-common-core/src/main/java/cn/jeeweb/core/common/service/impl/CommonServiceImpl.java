package cn.jeeweb.core.common.service.impl;

import cn.jeeweb.core.common.data.DuplicateValid;
import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.core.query.data.Page;
import cn.jeeweb.core.query.data.PageImpl;
import cn.jeeweb.core.query.data.Pageable;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.query.parse.QueryToWrapper;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Transactional
public class CommonServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements ICommonService<T> {

	@Override
	public Page<T> list(Queryable queryable) {
		EntityWrapper<T> entityWrapper = new EntityWrapper<T>();
		return list(queryable, entityWrapper);
	}

	@Override
	public Page<T> list(Queryable queryable, Wrapper<T> wrapper) {
		QueryToWrapper<T> queryToWrapper = new QueryToWrapper<T>();
		queryToWrapper.parseCondition(wrapper, queryable);
		// 排序问题
		queryToWrapper.parseSort(wrapper, queryable);
		Pageable pageable = queryable.getPageable();
		com.baomidou.mybatisplus.plugins.Page<T> page = new com.baomidou.mybatisplus.plugins.Page<T>(
				pageable.getPageNumber(), pageable.getPageSize());
		com.baomidou.mybatisplus.plugins.Page<T> content = selectPage(page, wrapper);
		return new PageImpl<T>(content.getRecords(), queryable.getPageable(), content.getTotal());
	}

	@Override
	public List<T> listWithNoPage(Queryable queryable) {
		EntityWrapper<T> entityWrapper = new EntityWrapper<T>();
		return listWithNoPage(queryable, entityWrapper);
	}

	@Override
	public List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper) {
		QueryToWrapper<T> queryToWrapper = new QueryToWrapper<T>();

		queryToWrapper.parseCondition(wrapper, queryable);
		// 排序问题
		queryToWrapper.parseSort(wrapper, queryable);
		List<T> content = selectList(wrapper);
		return content;
	}

	@Override
	public Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper) {
		Boolean valid = Boolean.FALSE;
		String queryType = duplicateValid.getQueryType();
		if (StringUtils.isEmpty(queryType)) {
			queryType = "table";
		}
		if (queryType.equals("table")) {
			valid = validTable(duplicateValid, wrapper);
		}
		return valid;
	}

	private Boolean validTable(DuplicateValid duplicateValid, Wrapper<T> wrapper) {
		Integer num = null;
		String extendName = duplicateValid.getExtendName();
		String extendParam = duplicateValid.getExtendParam();
		if (!StringUtils.isEmpty(extendParam)) {
			// [2].编辑页面校验
			wrapper.eq(duplicateValid.getName(), duplicateValid.getParam()).ne(extendName, extendParam);
			num = baseMapper.selectCount(wrapper);
		} else {
			// [1].添加页面校验
			wrapper.eq(duplicateValid.getName(), duplicateValid.getParam());
			num = baseMapper.selectCount(wrapper);
		}

		if (num == null || num == 0) {
			// 该值可用
			return true;
		} else {
			// 该值不可用
			return false;
		}
	}

}