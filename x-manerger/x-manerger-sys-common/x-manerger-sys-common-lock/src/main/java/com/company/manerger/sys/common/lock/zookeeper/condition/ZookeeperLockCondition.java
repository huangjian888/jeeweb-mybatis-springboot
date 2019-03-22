package com.company.manerger.sys.common.lock.zookeeper.condition;


import com.company.manerger.sys.common.lock.condition.LockCondition;

public class ZookeeperLockCondition extends LockCondition {
    public ZookeeperLockCondition() {
        super("lock.type", "zookeeperLock");
    }
}