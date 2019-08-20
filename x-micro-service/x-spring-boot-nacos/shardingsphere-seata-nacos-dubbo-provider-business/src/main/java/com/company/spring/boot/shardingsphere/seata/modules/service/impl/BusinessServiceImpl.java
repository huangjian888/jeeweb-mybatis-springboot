package com.company.spring.boot.shardingsphere.seata.modules.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.service.IBusinessService;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements IBusinessService {

    @Reference(check = false,mock = "com.company.spring.boot.shardingsphere.seata.modules.mock.IOrderServiceMock")
    IOrderService orderService;

    @Override
    @ShardingTransactionType(TransactionType.BASE)
    @GlobalTransactional(name = "dubbo-purchase")
    public void purchase(){
        TransactionTypeHolder.set(TransactionType.BASE);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(123);
        orderEntity.setStatus("seata");
        orderEntity.setUserId(123);
        orderService.insertOrder(orderEntity);
        System.out.println("XID:"+ RootContext.getXID());
        throw new RuntimeException("回滚测试");
    }
}
