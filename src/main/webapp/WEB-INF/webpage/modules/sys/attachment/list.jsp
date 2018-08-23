<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>附件信息</title>
  <meta name="decorator" content="list"/>
</head>
<body title="附件信息">
<grid:grid id="attachmentId" url="${adminPath}/sys/attachment/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete"/>
    <grid:column label="附件名称"  name="filename" width="200"  />
    <grid:column label="文件路径"  name="filepath"  width="200" />
    <grid:column label="文件大小"  name="filesize" width="100"    />
    <grid:column label="文件扩展名"  name="fileext"   width="100" />
    <grid:column label="上传时间"  name="uploadtime"  />
    <grid:column label="上传人"  name="user.realname"  />
    <grid:column label="上传IP"  name="uploadip"  />
    
	<grid:toolbar  function="delete" />
	
	<grid:toolbar  function="search"  />
	<grid:toolbar  function="reset" />
</grid:grid>
</body>
</html>