package com.company.manerger.sys.common.mp3.parse;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.manerger.sys.common.query.data.Condition;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.data.Condition.Operator;
import com.company.manerger.sys.common.query.data.Condition.Filter;
import com.company.manerger.sys.common.query.data.Sort;
import com.company.manerger.sys.common.utils.ObjectUtils;

import java.lang.reflect.Method;
import java.util.List;

public class QueryToWrapper<T> {

    public void parseCondition(QueryWrapper<T> queryWrapper, Queryable queryable) {
        Condition condition = queryable.getCondition();
        if (condition != null) {
            for (Filter filter : condition) {
                Object value = filter.getValue();
                if (!ObjectUtils.isNullOrEmpty(value)) {
                    Operator operator = filter.getOperator();
                    String property = filter.getProperty();
                    if(operator == Operator.custom){
                        continue;
                    }else if(operator == Operator.isNull){
                        queryWrapper.isNull(true,property);
                    }else if(operator == Operator.isNotNull){
                        queryWrapper.isNotNull(true,property);
                    }else if(operator == Operator.between){
                        Object[] betweens = null;
                        if(value instanceof List){
                            betweens = ((List) value).toArray(new Object[(((List) value).size())]);
                        }else{
                            betweens = (Object[]) value;
                        }
                        if(betweens.length == 2){
                            queryWrapper.between(true,property,betweens[0],betweens[1]);
                        }
                    }else if(operator == Operator.like){
                        queryWrapper.like(true,property,filter.getValue());
                    }else if(operator == Operator.notLike){
                        queryWrapper.notLike(true,property,filter.getValue());
                    }else if(operator == Operator.prefixLike){
                        queryWrapper.likeLeft(true,property,filter.getValue());
                    }else if(operator == Operator.prefixNotLike){
                        //暂未实现
                    }else if(operator == Operator.suffixLike){
                        queryWrapper.likeRight(true,property,filter.getValue());
                    }else if(operator == Operator.suffixNotLike){
                        //暂未实现
                    }else{
                        invokeQueryWrapper(queryWrapper,filter);
                    }
                }
            }
        }
    }

    public void invokeQueryWrapper(QueryWrapper<T> queryWrapper,Filter filter){
        try {
            Method method = queryWrapper.getClass().getMethod(filter.getOperator().name(),Boolean.class,String.class,Object.class);
            method.invoke(queryWrapper,true,filter.getProperty(),filter.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseSort(QueryWrapper<T> queryWrapper,Queryable queryable){
        Sort sort = queryable.getPageable().getSort();
        if(sort != null){
            for (Sort.Order order : sort) {
                if (order.getDirection() == Sort.Direction.DESC) {
                    queryWrapper.orderBy(true,false,order.getProperty());
                }else if (order.getDirection() == Sort.Direction.ASC) {
                    queryWrapper.orderBy(true,true,order.getProperty());
                }
            }
        }
    }

}
