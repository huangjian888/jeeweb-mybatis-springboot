package com.company.manerger.sys.common.idgenerator.local.utils;

import com.company.manerger.sys.common.idgenerator.exception.IdGeneratorException;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 自定义雪花算法
 */
public class CustomSnowflakeIdGenerator {
    /**
     * 每一部分占用的位数
     */
    private final static long DATA_CENTER_ID_BITS = 5L; // 数据中心标识在ID中占用的位数
    private final static long MACHINE_ID_BITS = 5L; // 机器标识在ID中占用的位数
    private final static long SEQUENCE_BITS = 12L; // 序列号在ID中占用的位数
    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATA_CENTER_ID = -1L ^ (-1L << DATA_CENTER_ID_BITS); // 支持的最大数据中心标识ID为31
    private final static long MAX_MACHINE_ID = -1L ^ (-1L << MACHINE_ID_BITS); // 支持的最大机器标识ID为31(这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BITS); // 支持的最大序列(掩码), 这里为4095 (0b111111111111=0xfff=4095)
    /**
     * 每一部分向左的位移
     */
    private final static long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + MACHINE_ID_BITS; // 数据中心标识ID向左移17位(12+5)
    private final static long MACHINE_ID_SHIFT = SEQUENCE_BITS; // 机器标识ID向左移12位
    private final static long TIMESTAMP_SHIFT = SEQUENCE_BITS + MACHINE_ID_BITS + DATA_CENTER_ID_BITS; // 时间戳向左移22位(5+5+12)
    /**
     * 批量获取的最大数目(10万)
     */
    private final static int MAX_BATCH_COUNT = 100_000;
    /**
     * 变量部分
     */
    private long dataCenterId; // 数据中心标识ID(0~31)
    private long machineId; // 机器标识ID(0~31)
    private long sequence = 0L; // 毫秒内序列(0~4095)
    private long lastTimestamp = -1L; // 上次生成ID的时间戳

    public CustomSnowflakeIdGenerator(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
            throw new IdGeneratorException(String.format("Data center id can't be greater than %d or less than 0", MAX_DATA_CENTER_ID));
        }

        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IdGeneratorException(String.format("Machine id can't be greater than %d or less than 0", MAX_MACHINE_ID));
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    /**
     * 批量获取下一组ID
     * @param count 批量条数
     * @return String[]
     */
    public String[] nextIds(int count) {
        if (count <= 0 || count > MAX_BATCH_COUNT) {
            throw new IdGeneratorException(String.format("Count can't be greater than %d or less than 0", MAX_BATCH_COUNT));
        }
        String[] ids = new String[count];
        for (int i = 0; i < count; i++) {
            ids[i] = nextId();
        }
        return ids;
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return String
     */
    public synchronized String nextId() {
        long currentTimestamp = getCurrentTimestamp();
        // 如果当前时间小于上一次ID生成的时间戳, 说明系统时钟回退过这个时候应当抛出异常
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - currentTimestamp));
        }
        // 如果是同一时间生成的, 则进行毫秒内序列自增
        if (lastTimestamp == currentTimestamp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 同一毫秒的序列数已经达到最大，则毫秒内序列溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒，获得新的时间戳
                currentTimestamp = getNextTimestamp(lastTimestamp);
            }
        } else {
            // 不同毫秒内，序列号置为0
            sequence = 0L;
        }
        // 上次生成ID的时间戳
        lastTimestamp = currentTimestamp;
        long suffix = (dataCenterId << DATA_CENTER_ID_SHIFT) | (machineId << MACHINE_ID_SHIFT) | sequence;
        String datePrefix = DateFormatUtils.format(currentTimestamp, "yyyyMMddHHmmssSSS");
        return datePrefix + dataCenterId + suffix;
    }

    /**
     * 阻塞到下一个毫秒, 直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间戳
     * @return long
     */
    private long getNextTimestamp(long lastTimestamp) {
        long currentTimestamp = getCurrentTimestamp();
        while (currentTimestamp <= lastTimestamp) {
            currentTimestamp = getCurrentTimestamp();
        }
        return currentTimestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return long
     */
    private long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        CustomSnowflakeIdGenerator generator = new CustomSnowflakeIdGenerator(2, 3);

        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(generator.nextId());
        }
    }
}
