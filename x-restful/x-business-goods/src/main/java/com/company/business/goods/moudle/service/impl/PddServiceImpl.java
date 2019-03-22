package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.properties.PddProperties;
import com.company.business.goods.moudle.entity.SubjectEntity;
import com.company.business.goods.moudle.service.IPddService;
import com.company.business.goods.moudle.service.ISubjectService;
import com.company.business.goods.utils.*;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pddService")
public class PddServiceImpl implements IPddService {

    @Autowired
    private PddProperties pddProperties;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISubjectService subjectService;
    private static Random random = new Random();

    public String apiCenter(JSONObject json) {
        Map<String, Object> map = (Map) JSONObject.toJavaObject(json, Map.class);

        return getResponse(map);
    }

    private String getResponse(Map<String, Object> map) {
        map.put("timestamp", DateUtils.getSecondTimestampTwo(new Date()));
        map.put("client_id", this.pddProperties.getClientId());
        Map<String, Object> dataMap = new TreeMap(map);

        String sign = getSignStr(dataMap);

        map.put("sign", sign);
        try {
            return TomatoRestUtils.post(this.request, this.pddProperties.getUrl(), buildRequestMap(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 内部调用的获取订单信息,开始时间，结束时间
     *
     * @return
     */
    @Override
    public String getOrder() {
        Long recentUpdateTime = (Long) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getOrderKey());

        Log.i("recentUpdateTime:" + recentUpdateTime);
        if (null == recentUpdateTime) {
            recentUpdateTime = Long.valueOf(DateUtils.getSecondTimestampTwo(new Date()));
        }
        Long now = Long.valueOf(DateUtils.getSecondTimestampTwo(new Date()));
        Map<String, Object> map = new HashMap<>();
        map.put("type", pddProperties.getOrderMethod());

        map.put("start_update_time", recentUpdateTime);//10位时间戳
        map.put("end_update_time", now);
        Log.i("now:" + now);
        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getOrderKey(), now, TomatoConstant.Common.LOG_TIME_REDIS);
        return getResponse(map);
    }

    /**
     * 前端类别调用接口,如配置有多个主题，只可能获取0个或是1个主题
     *
     * @param json
     * @return
     */
    @Override
    public String categoryProduct(JSONObject json) {
        //fixme 当前端请求获取分类列表时返回设置推荐内容--解析获取数据信息
        long optId = json.getLongValue("opt_id");
        int page = json.getInteger("page");
        int page_size = json.getInteger("page_size");

        List<SubjectEntity> subjectList = subjectService.getSubjectByCategoryId(String.valueOf(optId));
        if (subjectList.size() == TomatoConstant.Common.NUMBER_0) {
            return "";
        } else {
            //fixme 服务端后台有配置多个频道、根据权重处理返回哪个0-不返回100-必然返回

            SubjectEntity subjectEntity = getSubjectByWeight(subjectList);
            if (null == subjectEntity) {
                return "";
            }

            //fixme 获得管理后台配置的推荐商品列表
            String productId = subjectEntity.getSubject_product_id();
            if (null == productId) {
                return "";
            }
            List<String> productList = Arrays.asList(productId.split(","));

            if (null == productList) {
                return "";
            }

            //fixme 根据配置的productId查询商品信息
            return getResponse(productList, page, page_size);

        }

    }


    private String getResponse(List<String> productList, int page, int pageSize) {


        if (productList.size() <= pageSize) {
            return getProductList(productList, page, pageSize);
        } else {
            //继续往下滑当
            if ((page - 1) * pageSize > productList.size()) {//前一页数已超总额,1不能少
                return "";
            }
            if (page == TomatoConstant.Common.NUMBER_1) {

                return getProductList(productList.subList(TomatoConstant.Common.NUMBER_0, pageSize), page, pageSize);//第一页获取从0-20
            } else {
                return getProductList(productList.subList((page - TomatoConstant.Common.NUMBER_1) * pageSize, show(productList.size(), page, pageSize)), page, pageSize);
            }
        }

    }

    private boolean isLast(int size, int page, int pageSize) {

        if (size - page * pageSize >= 0) {
            return true;
        } else {
            return false;//最后一页
        }

    }

    private int show(int size, int page, int pageSize) {

        if (isLast(size, page, pageSize)) {//list总长度任然大于页码数
            return page * pageSize;
        } else {//最后一页
            return size;
        }

    }


    private String getProductList(List<String> productList, int page, int pageSize) {
        List<Long> list = new ArrayList<>();
        for (String productId : productList) {
            list.add(Long.valueOf(productId));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("goods_id_list", list.toString());
        map.put("type", pddProperties.getProductMethod());
        //分页
        map.put("page", page);
        map.put("page_size", pageSize);

        //fixme 获取搜索商品返回信息
        String response = getResponse(map);

        return response;

    }


    //fixme 根据权重计算挑选出唯一的推荐实体
    private SubjectEntity getSubjectByWeight(List<SubjectEntity> subjectList) {

        int sumWeight = 0;

        //fixme 将过期主题删除
        List<SubjectEntity> ultimatelyList = new ArrayList<>();


        //fixme 筛选出已经过期的主题
        for (SubjectEntity subjectEntity : subjectList) {

            Date endDate = subjectEntity.getSubject_end_date();
            Date startDate = subjectEntity.getSubject_start_date();

            if (DateUtils.isNotOneDay(startDate, new Date()) >= 0 && DateUtils.isNotOneDay(new Date(), endDate) > 0 && subjectEntity.getSubject_weight() > TomatoConstant.Common.NUMBER_0) {

                ultimatelyList.add(subjectEntity);
            }

        }


        if (ultimatelyList.size() == TomatoConstant.Common.NUMBER_0) {
            return null;

        }


        //fixme 计算未过期主题的权重信息
        for (SubjectEntity subject : ultimatelyList) {
            if (subject.getSubject_weight() == TomatoConstant.Common.NUMBER_100) {
                //fixme 权重为100直接返回当前实体
                return subject;

            }
            //fixme 1.累加权重
            sumWeight += subject.getSubject_weight();

        }

        Integer randomWeight = random.nextInt(sumWeight) + TomatoConstant.Common.NUMBER_5; //fixme 2.生成权重区间的随机数,因需求是有可能显示推荐也不能不显示推荐，此处手动加入不显示的几率为百分之10
        Integer temp = 0;//fixme 权重累加


        for (SubjectEntity subjectEntity : ultimatelyList) {

            if (temp <= randomWeight && randomWeight < temp + subjectEntity.getSubject_weight()) {
                return subjectEntity;
            }
            temp += subjectEntity.getSubject_weight();
        }

        return null;
    }

    private Map<String, Object> buildRequestMap(Map<String, Object> map) {
        for (String key : map.keySet()) {
            if (((map.get(key) instanceof String)) &&
                    (DateUtils.isChinese((String) map.get(key)))) {
                String value = (String) map.get(key);
                map.put(key, value);
            }
        }
        return map;
    }

    private String getSignStr(Map<String, Object> dataMap) {
        StringBuilder sign = new StringBuilder();
        for (String key : dataMap.keySet()) {
            if ((dataMap.get(key) instanceof Integer)) {
                String value = String.valueOf(dataMap.get(key));
                sign.append(key).append(value);
            } else if ((dataMap.get(key) instanceof Long)) {
                String value = String.valueOf(dataMap.get(key));
                sign.append(key).append(value);
            } else if ((dataMap.get(key) instanceof String)) {
                if (DateUtils.isChinese((String) dataMap.get(key))) {
                    sign.append(key).append((String) dataMap.get(key));
                } else {
                    sign.append(key).append(dataMap.get(key));
                }
            } else {
                sign.append(key).append(dataMap.get(key));
            }
        }
        String signStr = this.pddProperties.getClientSecret() + sign + this.pddProperties.getClientSecret();

        return DigestUtils.md5Hex(signStr).toUpperCase();
    }
}
