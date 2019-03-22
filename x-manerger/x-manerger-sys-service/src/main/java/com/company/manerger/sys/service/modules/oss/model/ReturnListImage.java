package com.company.manerger.sys.service.modules.oss.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列表回掉
 */
public class ReturnListImage {
        private String state;//上传状态SUCCESS 一定要大写
        private Integer start;
        private Long total;
        private List<Map<String,String>> list=new ArrayList<Map<String,String>>();


        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public Integer getStart() {
                return start;
        }

        public void setStart(Integer start) {
                this.start = start;
        }

        public Long getTotal() {
                return total;
        }

        public void setTotal(Long total) {
                this.total = total;
        }

        public List<Map<String, String>> getList() {
                return list;
        }

        public void setList(List<Map<String, String>> list) {
                this.list = list;
        }

        public void putUrl(String url){
                Map<String,String> urlMap=new HashMap<String,String>();
                urlMap.put("url",url);
                list.add(urlMap);
        }
}