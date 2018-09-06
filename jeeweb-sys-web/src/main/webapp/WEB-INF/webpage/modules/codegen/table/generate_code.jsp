<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="sys.dict.edittitle" /></title>
    <meta name="decorator" content="form"/> 
    
</head>

<body class="white-bg"  formid="genForm">
    <form:form id="genForm" action="${adminPath}/codegen/table/generateCode" method="post" class="form-horizontal">
         <form:hidden path="tableid"  nested="false"/>
         <form:hidden path="id"  nested="false"  value="${scheme.id}"/>
		 <table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		      <tr>
		         <td  class=" active text-right" style="width:20%;">	
		              <label><font color="red">*</font>代码生成目录:</label>
		         </td>
		         <td>
		             <form:input path="pathName" class="form-control" nested="false"  value="${scheme.pathName}" datatype="*" nullmsg="请输入代码生成目录！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>生成包路径:</label>
		         </td>
		         <td>
		             <form:input path="packageName" class="form-control" nested="false"  value="${scheme.packageName}" datatype="*" nullmsg="请输入生成包路径！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>生成模块名:</label>
		         </td>
		         <td>
		             <form:input path="moduleName" class="form-control" nested="false"  value="${scheme.moduleName}"  datatype="*" nullmsg="请输入生成模块名！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr style="display:none;">
		         <td  class=" active text-right">	
		              <label>生成子模块名:</label>
		         </td>
		         <td>
		             <form:input path="subModuleName" class="form-control"  value="${scheme.subModuleName}" nested="false"   htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>实体类名(首字母大写):</label>
		         </td>
		         <td>
		             <form:input path="entityName" class="form-control"  value="${scheme.entityName}"  nested="false"  datatype="*" nullmsg="请输入实体类名(首字母大写)！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		       </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>生成功能描述:</label>
		         </td>
		         <td>
		             <form:input path="functionDesc" class="form-control"  value="${scheme.functionDesc}" nested="false"  datatype="*" nullmsg="请输入生成功能描述！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>生成功能名:</label>
		         </td>
		         <td>
		             <form:input path="functionName" class="form-control" value="${scheme.functionName}" nested="false"  datatype="*" nullmsg="请输入生成功能名！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>生成功能作者:</label>
		         </td>
		         <td>
		             <form:input path="functionAuthor" class="form-control" nested="false" value="${scheme.functionAuthor}"  datatype="*" nullmsg="请输入生成功能作者！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		      </tr>
		      <tr>
		         <td  class=" active text-right">	
		              <label><font color="red">*</font>需要生成的代码:</label>
		         </td>
		         <td>
		             <input type="checkbox" value="Controller" name="generatorKeys"  checked="checked">Controller</input>
					 <input type="checkbox" value="IService" name="generatorKeys"   checked="checked">IService</input> 
					 <input type="checkbox" value="ServiceImpl" name="generatorKeys"  checked="checked">ServiceImpl</input>
				 	 <input type="checkbox" value="Mapper" name="generatorKeys"  checked="checked">Mapper</input>
				 	 <input type="checkbox" value="Entity" name="generatorKeys"  checked="checked">Entity</input>
				 	 <input type="checkbox" value="xmlMapper" name="generatorKeys"  checked="checked">xmlMapper</input>
				 	 <input type="checkbox" value="viewList" name="generatorKeys"  checked="checked">viewList</input>
				 	 <input type="checkbox" value="viewForm" name="generatorKeys"  checked="checked">viewForm</input>   
		             <label class="Validform_checktip"></label>
		         </td>
		       </tr>
		   </tbody>
		</table>
	</form:form>
</body>
</html>