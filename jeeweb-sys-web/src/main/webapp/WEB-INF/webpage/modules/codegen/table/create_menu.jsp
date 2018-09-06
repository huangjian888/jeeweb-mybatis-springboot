<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="sys.menu.edittitle" /></title>
    <meta name="decorator" content="form"/> 
</head>

<body class="white-bg"  formid="menuForm">
     <form:form id="menuForm" modelAttribute="data" action="${adminPath}/sys/menu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="url"   />
		<form:hidden path="permission"  />
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		          <td class="width-15 active"><label class="pull-right">上级菜单:</label></td>
		         <td class="width-35">
		            <form:treeselect title="请选择上级菜单"   path="parentId" dataUrl="${adminPath}/sys/menu/treeData"   labelName="parentname" labelValue="${data.parent.name}" />	   
				  </td>
		          <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>菜单名称:</label>
		         </td>
		         <td class="width-35" >
		             <form:input path="name" class="form-control " datatype="*" nullmsg="请输入菜单名称！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	
		              <label><font color="red">*</font>是否显示:</label>
		         </td>
		         <td class="width-35" >
		             <form:radiobuttons path="isshow"
								 dict="sf" defaultvalue="${roleIdList}"
								 htmlEscape="false"
								cssClass="i-checks required" />
		              <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		       <tr>
		         <td  class="width-15 active text-right">	
		              <label>备注:</label>
		         </td>
		         <td class="width-35" colspan="3" >
		              <form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="form-control "/>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active"><label class="pull-right">图标:</label></td>
		         <td class="width-35" >
					 <form:iconselect path="menuIcon" />	
					 <label class="Validform_checktip"></label>   
				</td>
		         <td  class="width-15 active"><label class="pull-right">排序:</label></td>
		         <td  class="width-35" >
		             <form:input path="sort" class="form-control"  htmlEscape="false" />
		             <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>排序为升序</span>
		             <label class="Validform_checktip"></label>
		      </tr>
		   </tbody>
		   </table>   
	</form:form>
	 
</body>
</html>