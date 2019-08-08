package com.company.spring.boot.shardingsphere.seata;

import com.company.spring.boot.shardingsphere.seata.modules.entity.Order;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.service.IBusinessService;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderItemService;
//import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderService;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.concurrent.locks.LockSupport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XSpringBootShardingsphereSeataApplicationTests {

    @Autowired
    IBusinessService businessService;

    @Test
    public void contextLoads(){
        businessService.purchase();
    }

}
