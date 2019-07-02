package com.company.manerger.sys.common.mybatis.service.impl;

import com.company.manerger.sys.common.base.http.DuplicateValid;
import com.company.manerger.sys.common.mybatis.parse.QueryToWrapper;
import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.manerger.sys.common.query.data.Page;
import com.company.manerger.sys.common.query.data.PageImpl;
import com.company.manerger.sys.common.query.data.Pageable;
import com.company.manerger.sys.common.query.data.Queryable;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *Transactional 事务，公共层Impl实现不应该有事务，事务会导致使用dynamic-datasource切换数据源框架无法生效
 * dynamic-datasource 框架目前暂不支持事务，重点！
 * 如若需要事务，请在具体的业务Impl类上或者是方法上面添加事务
 * @param <M>
 * @param <T>
 */
//@Transactional
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
//            wrapper.eq(duplicateValid.getName(), duplicateValid.getParam()).ne(extendName, extendParam);
            wrapper.eq(duplicateValid.getName(), duplicateValid.getParam()).eq(extendName, extendParam);
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