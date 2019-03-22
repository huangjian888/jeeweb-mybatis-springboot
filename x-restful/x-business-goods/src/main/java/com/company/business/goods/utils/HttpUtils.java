package com.company.business.goods.utils;

import com.company.business.goods.common.constant.TomatoConstant;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.TextUtils;

/**
 * 用作获取生成微信二维码以及保存到服务器上
 */
import java.io.*;

public class HttpUtils {

    /**
     * 返回图片的cdn地址
     *
     * @param url
     * @param json
     * @return
     * @throws Exception
     */
    public static String httpPostWithJSON(String url, String json)
            throws Exception {
        String path = "";
        // 将JSON进行UTF-8编码,以便传输中文
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, TomatoConstant.Common.CONTENT_TYPE_TEXT_JSON);
        StringEntity se = new StringEntity(json);
        se.setContentType(TomatoConstant.Common.CONTENT_TYPE_TEXT_JSON);
        se.setContentEncoding(TomatoConstant.Common.UTF8);

        httpPost.setEntity(se);
        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                InputStream instreams = resEntity.getContent();
                String pngName = new StringBuilder(String.valueOf(System.currentTimeMillis())).append(".png").toString();

                path = saveToImgByInputStream(instreams, TomatoConstant.QrCode.QR_PACKAGE_NAME, pngName);
                Log.i("path:" + path);
                return TextUtils.isEmpty(path) ? "" : new StringBuilder(TomatoConstant.QrCode.QR_PHOTO_URL).append(pngName).toString();
            }
        }
        return "";
    }

    //fixme 将生成的二维码保存到服务器并将对应url返回给前端，将productId与二维码保存缓存
    public static String saveToImgByInputStream(InputStream instreams, String imgPath, String imgName) {

        File sdFile = new File(imgPath);
        if (!sdFile.exists()) {
            sdFile.mkdirs();
        }
        int stateInt = 1;
        if (instreams != null) {
            try {
                File file = new File(imgPath, imgName);//fixme 默认保存png图片
                FileOutputStream fos = new FileOutputStream(file);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = instreams.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
            } catch (Exception e) {
                stateInt = 0;
                e.printStackTrace();
            } finally {
            }
        }
        return stateInt == 1 ? TomatoConstant.QrCode.QR_PACKAGE_NAME : "";
    }
}
