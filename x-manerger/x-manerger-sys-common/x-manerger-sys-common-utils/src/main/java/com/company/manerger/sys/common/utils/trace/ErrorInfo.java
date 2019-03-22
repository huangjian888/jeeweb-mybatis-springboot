package com.company.manerger.sys.common.utils.trace;

public class ErrorInfo {
    private String time;//发生时间
    private String url;//访问Url
    private String error;//错误类型
    private String stackTrace;//错误的堆栈轨迹
    private int statusCode;//状态码
    private String reasonPhrase;//状态码

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("url:"+ url +"\n");
        stringBuilder.append("time:"+ time +"\n");
        stringBuilder.append("statusCode:"+ statusCode +"\n");
        stringBuilder.append("error:"+ error +"\n");
        stringBuilder.append("reasonPhrase:"+ reasonPhrase +"\n");
        stringBuilder.append("stackTrace:"+ stackTrace +"\n");
        return stringBuilder.toString();
    }
}
