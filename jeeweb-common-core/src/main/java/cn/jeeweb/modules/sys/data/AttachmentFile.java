package cn.jeeweb.modules.sys.data;


import java.io.Serializable;

/**
 * Created by hexin on 2018/9/7.
 */
public class AttachmentFile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String originalFilename;
    private String fileIp;
    private String contentType;
    private byte[] bytes;

    public AttachmentFile(){

    }
    public AttachmentFile(String name,String originalFilename,String fileIp,String contentType,byte[] bytes){
       this.name = name;
       this.originalFilename = originalFilename;
       this.fileIp = fileIp;
       this.contentType = contentType;
       this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFileIp() {
        return fileIp;
    }

    public void setFileIp(String fileIp) {
        this.fileIp = fileIp;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
