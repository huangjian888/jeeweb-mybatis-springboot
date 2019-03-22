package com.company.manerger.sys.service.modules.oss.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 列表回掉
 */
public class ReturnCatchimageListImage {
        private String state;//上传状态SUCCESS 一定要大写
        private List<CatchImageItem> list=new ArrayList<CatchImageItem>();

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public List<CatchImageItem> getList() {
                return list;
        }

        public void setList(List<CatchImageItem> list) {
                this.list = list;
        }

        public void putItem(String url,String source){
                CatchImageItem catchImageItem=new CatchImageItem(url,source,"SUCCESS");
                list.add(catchImageItem);
        }

        public class CatchImageItem implements Serializable{
                private String url;
                private String source;
                private String state;
                public CatchImageItem(){

                }
                public CatchImageItem(String url,String source,String state){
                        this.url=url;
                        this.source=source;
                        this.state=state;
                }
                public String getUrl() {
                        return url;
                }

                public void setUrl(String url) {
                        this.url = url;
                }

                public String getSource() {
                        return source;
                }

                public void setSource(String source) {
                        this.source = source;
                }

                public String getState() {
                        return state;
                }

                public void setState(String state) {
                        this.state = state;
                }
        }
}