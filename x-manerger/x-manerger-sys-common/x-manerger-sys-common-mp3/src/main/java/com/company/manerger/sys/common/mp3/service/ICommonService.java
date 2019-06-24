package com.company.manerger.sys.common.mp3.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.manerger.sys.common.query.data.Page;
import com.company.manerger.sys.common.query.data.Queryable;

import java.util.List;

public interface ICommonService<T> extends IService<T> {
    Page<T> listWithPage(Queryable queryable);

    Page<T> listWithPage(Queryable queryable, QueryWrapper<T> queryWrapper);

    List<T> listWithNoPage(Queryable queryable);

    List<T> listWithNoPage(Queryable queryable, QueryWrapper<T> queryWrapper);
}
