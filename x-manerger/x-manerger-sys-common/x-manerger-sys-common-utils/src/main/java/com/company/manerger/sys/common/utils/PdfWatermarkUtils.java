package com.company.manerger.sys.common.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


public class PdfWatermarkUtils {

    /**
     * 为pdf文件加水印(根据水印文字)
     *
     * @param sourcePath
     * @param targetPath
     * @param waterMarkName
     * @throws IOException
     * @throws DocumentException
     */
    public static void setWatermark(String sourcePath,
                                    String targetPath, String waterMarkName)
            throws IOException, DocumentException {
       setWatermark(sourcePath,targetPath,waterMarkName,1);
    }

    /**
     * 为pdf文件加水印(根据水印文字)
     *
     * @param sourcePath
     * @param targetPath
     * @param waterMarkName
     * @param opacity
     * @throws IOException
     * @throws DocumentException
     */
    public static void setWatermark(String sourcePath,
                                    String targetPath, String waterMarkName, float opacity)
            throws IOException, DocumentException {
        byte[] bytes=FileUtil.toByteArray(sourcePath);
        OutputStream outPutStream = FileUtil.openOutputStream(new File(targetPath));
        PdfReader pr = new PdfReader(bytes, "PDF".getBytes());
        // 获取文件页数
        int pageSize = pr.getNumberOfPages();
        PdfStamper stam = new PdfStamper(pr, outPutStream);
        PdfContentByte content = null;
        // 设置字体
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                BaseFont.EMBEDDED);
        PdfGState gs = new PdfGState();
        // 设置透明度(填充不透明度)
        gs.setFillOpacity(opacity);
        for (int i = 1; i <= pageSize; i++) {
            content = stam.getOverContent(i);// 在内容上方加水印
            // content = stam.getUnderContent(i);//在内容下方加水印
            content.setGState(gs);
            content.beginText();
            content.setColorFill(BaseColor.LIGHT_GRAY);
            content.setFontAndSize(base, 50);// 设置字体的大小
            content.setTextMatrix(70, 200);
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 100,
                    750, 45);// 宽，高，斜度
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 250,
                    650, 45);
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 350,
                    550, 45);
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 200,
                    250, 45);
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 350,
                    150, 45);
            content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, 500,
                    350, 45);
            content.endText();
        }
        stam.close();
    }
}
