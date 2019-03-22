package com.company.manerger.sys.common.lock.redis.redisson.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RedissionContent {
    private String content;

    public RedissionContent(String path, String encoding) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(path);
            this.content = IOUtils.toString(inputStream, encoding);
        } finally {
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
        }
    }

    public RedissionContent(File file, String encoding) throws IOException {
        this.content = FileUtils.readFileToString(file, encoding);
    }

    public RedissionContent(StringBuilder stringBuilder) throws IOException {
        this.content = stringBuilder.toString();
    }

    public String getContent() {
        return content;
    }

    public static InputStream getInputStream(String path) throws IOException {
        // 从Resource路径获取
        InputStream inputStream = RedissionContent.class.getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            // 从文件路径获取
            inputStream = new FileInputStream(path);
        }

        return inputStream;
    }
}
