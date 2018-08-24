package cn.jeeweb.modules.sys.mapper;

import cn.jeeweb.modules.sys.entity.Attachment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 附件数据库控制层接口
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {
	List<Attachment> selectAttachmentPage(Page<Attachment> page, @Param("ew") Wrapper<Attachment> wrapper);
}