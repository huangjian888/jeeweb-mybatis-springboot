package com.company.manerger.sys.common.idgenerator.zookeeper.impl;

import com.company.manerger.sys.common.idgenerator.exception.IdGeneratorException;
import com.company.manerger.sys.common.idgenerator.zookeeper.ZookeeperIdGenerator;
import com.company.manerger.sys.common.idgenerator.zookeeper.curator.handler.CuratorHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.hashids.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PreDestroy;

public class ZookeeperIdGeneratorImpl implements ZookeeperIdGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperIdGeneratorImpl.class);
    private static final int MAX_BATCH_COUNT = 1000;
    @Autowired
    private CuratorHandler curatorHandler;
    @Value("${idgenerator.prefix:idGeneratorPrefix}")
    private String prefix;

    @PreDestroy
    public void destroy() {
        try {
            curatorHandler.close();
        } catch (Exception e) {
            throw new IdGeneratorException("Close Curator failed", e);
        }
    }

    @Override
    public String nextSequenceId(String name, String key) throws Exception {
        return nextSequenceId(name,key,false);
    }

    @Override
    public String nextSequenceId(String name, String key, boolean useHashIds) throws Exception {
        return nextSequenceId(name,key,useHashIds,null);
    }

    @Override
    public String nextSequenceId(String name, String key, boolean useHashIds, String salt) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new IdGeneratorException("name is null or empty");
        }
        if (StringUtils.isEmpty(key)) {
            throw new IdGeneratorException("key is null or empty");
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return nextSequenceId(compositeKey,useHashIds,salt);
    }

    @Override
    public String nextSequenceId(String compositeKey) throws Exception {
        return nextSequenceId(compositeKey,false);
    }

    @Override
    public String nextSequenceId(String compositeKey, boolean useHashIds) throws Exception {
        return nextSequenceId(compositeKey,useHashIds,null);
    }

    @Override
    public String nextSequenceId(String compositeKey, boolean useHashIds, String salt) throws Exception {
        if (StringUtils.isEmpty(compositeKey)) {
            throw new IdGeneratorException("Composite key is null or empty");
        }
        curatorHandler.validateStartedStatus();
        String path = curatorHandler.getPath(prefix, compositeKey);
        // 并发过快，这里会抛“节点已经存在”的错误，当节点存在时候，就不会创建，所以不必打印异常
        try {
            if (!curatorHandler.pathExist(path)) {
                curatorHandler.createPath(path, CreateMode.PERSISTENT);
            }
        } catch (Exception e) {

        }
        CuratorFramework curator = curatorHandler.getCurator();
        String nextSequenceId = String.valueOf(curator.setData().withVersion(-1).forPath(path, "".getBytes()).getVersion());
        if(useHashIds){
            Hashids hashids;
            if(!StringUtils.isEmpty(salt)){
                hashids = new Hashids(salt);
            }else{
                hashids = new Hashids();
            }
            nextSequenceId = hashids.encodeHex(nextSequenceId);
        }
        return nextSequenceId;
    }

    @Override
    public String[] nextSequenceIds(String name, String key, int count) throws Exception {
        return nextSequenceIds(name,key,count,false);
    }

    @Override
    public String[] nextSequenceIds(String name, String key, int count, boolean useHashIds) throws Exception {
        return nextSequenceIds(name,key,count,useHashIds,null);
    }

    @Override
    public String[] nextSequenceIds(String name, String key, int count, boolean useHashIds, String salt) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new IdGeneratorException("name is null or empty");
        }
        if (StringUtils.isEmpty(key)) {
            throw new IdGeneratorException("key is null or empty");
        }
        if (count <= 0 || count > MAX_BATCH_COUNT) {
            throw new IdGeneratorException(String.format("Count can't be greater than %d or less than 0", MAX_BATCH_COUNT));
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return nextSequenceIds(compositeKey,count,useHashIds,salt);
    }

    @Override
    public String[] nextSequenceIds(String compositeKey, int count) throws Exception {
        return nextSequenceIds(compositeKey,count,false);
    }

    @Override
    public String[] nextSequenceIds(String compositeKey, int count, boolean useHashIds) throws Exception {
        return nextSequenceIds(compositeKey,count,useHashIds,null);
    }

    @Override
    public String[] nextSequenceIds(String compositeKey, int count, boolean useHashIds, String salt) throws Exception {
        if (count <= 0 || count > MAX_BATCH_COUNT) {
            throw new IdGeneratorException(String.format("Count can't be greater than %d or less than 0", MAX_BATCH_COUNT));
        }
        if (StringUtils.isEmpty(compositeKey)) {
            throw new IdGeneratorException("Composite key is null or empty");
        }
        String[] nextSequenceIds = new String[count];
        for (int i = 0; i < count; i++) {
            nextSequenceIds[i] = nextSequenceId(compositeKey,useHashIds,salt);
        }
        return nextSequenceIds;
    }
}