package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.utils.*;
import cn.jeeweb.core.utils.upload.FileUploadUtils;
import cn.jeeweb.core.utils.upload.exception.FileNameLengthLimitExceededException;
import cn.jeeweb.core.utils.upload.exception.InvalidExtensionException;
import cn.jeeweb.modules.sys.entity.Attachment;
import cn.jeeweb.modules.sys.mapper.AttachmentMapper;
import cn.jeeweb.modules.sys.service.IAttachmentService;
import cn.jeeweb.modules.sys.utils.UserUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Transactional
@Service(interfaceClass = IAttachmentService.class)
public class AttachmentServiceImpl extends CommonServiceImpl<AttachmentMapper, Attachment>
		implements IAttachmentService {
	public static final String DEFAULT_CONFIG_FILE = "upload.properties";
	protected String configname = DEFAULT_CONFIG_FILE;
	private long maxSize = 0;
	private boolean needDatePathAndRandomName = true;
	private String[] allowedExtension;
	private String baseDir;

	@Override
	public Page<Attachment> selectPage(Page<Attachment> page, Wrapper<Attachment> wrapper) {
		Page<Attachment> pageInfo = new Page<Attachment>();
		wrapper.eq("1", "1");
		int total = baseMapper.selectCount(wrapper);
		List<Attachment> records = baseMapper.selectAttachmentPage(page, wrapper);
		pageInfo.setTotal(total);
		pageInfo.setRecords(records);
		return pageInfo;
	}

	@PostConstruct
	public void initAttachement() {
		PropertiesUtil propertiesUtil = new PropertiesUtil(configname);
		maxSize = propertiesUtil.getLong("upload.max.size");
		baseDir = propertiesUtil.getString("upload.base.dir");
		String extension = propertiesUtil.getString("upload.allowed.extension");
		allowedExtension = extension.split(",");
	}

	@Override
	public Attachment upload(HttpServletRequest request, MultipartFile file) throws FileSizeLimitExceededException,
            InvalidExtensionException, FileNameLengthLimitExceededException, IOException {
		String url = FileUploadUtils.upload(request, baseDir, file, allowedExtension, maxSize,
				needDatePathAndRandomName);
		String filename = file.getOriginalFilename();
		long size = file.getSize();
		String realFileName = StringUtils.getFileNameNoEx(filename);
		String fileext = StringUtils.getExtensionName(filename);
		// 保存上传的信息
		Attachment attachment = new Attachment();
		attachment.setFileext(fileext);
		attachment.setFilename(realFileName);
		attachment.setFilepath(url);
		attachment.setFilesize(size);
		attachment.setStatus("1");
		attachment.setUploadip(IpUtils.getIpAddr(request));
		attachment.setUploadtime(new Date());
		attachment.setUser(UserUtils.getUser());
		insert(attachment);
		return attachment;
	}

	@Override
	public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
		for (Object object : idList) {
			deleteById((Serializable) object);
		}
		return true;
	}

	//	@Override
//	public boolean deleteBatchIds(List<? extends Serializable> idList) {
//		for (Object object : idList) {
//			deleteById((Serializable) object);
//		}
//		return true;
//	}

	@Override
	public boolean deleteById(Serializable id) {
		Attachment attachment = selectById(id);
		String basePath = ServletUtils.getRequest().getServletContext().getRealPath("/");
		String filePath = attachment.getFilepath();
		FileUtil.delFile(basePath + filePath);
		return super.deleteById(id);
	}

}
