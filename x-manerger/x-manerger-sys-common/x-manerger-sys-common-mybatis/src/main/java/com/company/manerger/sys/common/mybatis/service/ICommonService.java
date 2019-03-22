package com.company.manerger.sys.common.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.company.manerger.sys.common.base.http.DuplicateValid;
import com.company.manerger.sys.common.query.data.Page;
import com.company.manerger.sys.common.query.data.Queryable;

import java.util.List;

public interface ICommonService<T> extends IService<T> {

     Page<T> list(Queryable queryable);

     Page<T> list(Queryable queryable, Wrapper<T> wrapper);

     List<T> listWithNoPage(Queryable queryable);

     List<T> listWithNoPage(Queryable queryable, Wrapper<T> wrapper);

     Boolean doValid(DuplicateValid duplicateValid, Wrapper<T> wrapper);
}