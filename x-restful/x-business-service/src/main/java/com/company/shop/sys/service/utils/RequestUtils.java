package com.company.shop.sys.service.utils;

import com.company.shop.sys.service.common.constant.GlobalConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 用于获取前端请求网络信息--保证安全
 */
public class RequestUtils {

    /**
     * 获取HttpServletRequest实例
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取去前端请求当前ip--微信支付需要
     *
     * @param request
     * @return
     */
    public static String getCurrentIp() {
        HttpServletRequest request = getRequest();
        String ipAddress = request.getHeader(GlobalConstant.X_REAL_IP);
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.WL_PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.HTTP_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(GlobalConstant.HTTP_X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if (StringUtils.isEmpty(ipAddress) || GlobalConstant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (GlobalConstant.LOCALHOST_IP.equals(ipAddress) || GlobalConstant.LOCALHOST_IP_16.equals(ipAddress)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    Log.e("获取ip地址出现异常：" + e.getMessage());

                }
                assert inet != null;
                ipAddress = inet.getHostAddress();
            }
            Log.i("获取到的ip地址是:" + ipAddress);
        }
        // 对于通过多个代理的情况, 第一个IP为客户端真实IP,多个IP按照','分割 //"***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > GlobalConstant.MAX_IP_LENGTH) {
            if (ipAddress.indexOf(GlobalConstant.Symbol.COMMA) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(GlobalConstant.Symbol.COMMA));
            }
        }
        return ipAddress;
    }

    /**
     * 普通网络请求
     *
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        // 创建SSLContext
        StringBuffer buffer = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //往服务器端写内容
            if (null != outputStr) {
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }
            // 读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
