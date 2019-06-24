package com.company.manerger.sys.common.mp3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.manerger.sys.common.mp3.parse.QueryToWrapper;
import com.company.manerger.sys.common.mp3.service.ICommonService;
import com.company.manerger.sys.common.mp3.wrapper.QueryEntityWrapper;
import com.company.manerger.sys.common.query.data.Page;
import com.company.manerger.sys.common.query.data.PageImpl;
import com.company.manerger.sys.common.query.data.Pageable;
import com.company.manerger.sys.common.query.data.Queryable;

import java.util.List;

public class CommonServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M , T> implements ICommonService<T> {

    @Override
    public Page<T> listWithPage(Queryable queryable) {
        QueryEntityWrapper<T> queryEntityWrapper = new QueryEntityWrapper<>();
        return listWithPage(queryable,queryEntityWrapper);
    }

    @Override
    public Page<T> listWithPage(Queryable queryable, QueryWrapper<T> queryWrapper) {
        QueryToWrapper<T> queryToWrapper = new QueryToWrapper<>();
        queryToWrapper.parseCondition(queryWrapper,queryable);
        queryToWrapper.parseSort(queryWrapper, queryable);
        Pageable pageable = queryable.getPageable();
        IPage<T> page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(pageable.getPageNumber(), pageable.getPageSize());
        IPage<T> content = page(page,queryWrapper);
        return new PageImpl<>(content.getRecords(), queryable.getPageable(), content.getTotal());
    }

    @Override
    public List<T> listWithNoPage(Queryable queryable) {
        QueryEntityWrapper<T> queryEntityWrapper = new QueryEntityWrapper<>();
        return listWithNoPage(queryable,queryEntityWrapper);
    }

    @Override
    public List<T> listWithNoPage(Queryable queryable, QueryWrapper<T> queryWrapper) {
        QueryToWrapper<T> queryToWrapper = new QueryToWrapper<>();
        queryToWrapper.parseCondition(queryWrapper, queryable);
        queryToWrapper.parseSort(queryWrapper, queryable);
        List<T> content = list(queryWrapper);
        return content;
    }
}
