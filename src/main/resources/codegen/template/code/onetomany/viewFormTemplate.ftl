<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>${functionName}</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor,jqgrid" />
</head>

<body class="white-bg"  formid="${entityName?uncap_first}Form" beforeSubmit="beforeSubmit">
    <form:form id="${entityName?uncap_first}Form" modelAttribute="data"  method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
	    <#assign index=0 />
		<#list columns as column>
			<#if column.isForm?? && column.isForm>
			<#assign index=index+1 />
			<#if index%2==1> 
				<tr>
			</#if>
					<td  class="width-15 active text-right">	
		              <label><#if column.nullable??&&!column.nullable><font color="red">*</font></#if><#if column.remarks??&&column.remarks!="">${column.remarks}<#else>${column.javaField}</#if>:</label>
		            </td>
					<td class="width-35">
			<#if column.formType == "input">
						<form:input path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "textarea">
						<form:textarea path="${column.javaField}" rows="4" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "radiobox">
						<form:radiobuttons path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.dictGroup??&&column.dictGroup!="">dict="${column.dictGroup}"</#if>  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  cssClass="i-checks required"/>
			<#elseif column.formType == "select">
						<form:select path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.dictGroup??&&column.dictGroup!="">dict="${column.dictGroup}"</#if>  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "checkbox">
						<form:checkboxes path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.dictGroup??&&column.dictGroup!="">dict="${column.dictGroup}"</#if>  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "dateselect">
						<form:input path="${column.javaField}" htmlEscape="false" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"   <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "editor">
						<form:editor path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "fileinput">
						<form:fileinput path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			<#elseif column.formType == "avatarinput">
						<form:fileinput showType="avatar" fileInputWidth="100px"  fileInputHeight="100px"  path="${column.javaField}" htmlEscape="false" class="form-control"  <#if column.regexValid??&&column.regexValid!="">datatype="${column.regexValid}"<#else><#if column.validType??&&column.validType!="">datatype="${column.validType}<#if column.validType=="s"||column.validType=="n"><#if column.minSize??>${column.minSize}<#if column.maxSize??>-${column.maxSize}<#else>-${column.columnSize}</#if></#if></#if>"</#if></#if>  <#if column.nullmsg??&&column.nullmsg!="">nullmsg="${column.nullmsg}"</#if>  />
			</#if>
						<label class="Validform_checktip"></label>
					</td>
			<#if index%2==0> 
				</tr>
			</#if>
			</#if>
		</#list>
		<#if index%2==1 > 
					<td class="width-15 active text-right"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		</#if>
		      
		   </tbody>
		</table>   
	</form:form>
	<div class="row">
        <div class="tabs-container">
            <ul class="nav nav-tabs">
                <#list schedules as schedule>
            	<li <#if schedule_index == 0>class="active"</#if>><a data-toggle="tab" href="#tab_${schedule.className?uncap_first}" aria-expanded="true">${schedule.remarks}</a></li>
            	</#list>
            </ul>
            <div class="tab-content">
           		 <#list schedules as schedule>
                 <div id="tab_${schedule.className?uncap_first}" class="tab-pane <#if schedule_index == 0>active</#if>">
                    <div class="panel-body">
                        <grid:grid id="${schedule.className?uncap_first}"  datas="${r'$'}{${schedule.className?uncap_first}List}"  gridShowType="form" pageable="false"  editable="true">
						    <#list schedule.columns as column>
							   <#if column.isList&&column.columnName!='id'>
							    <grid:column label="<#if column.remarks??&&column.remarks!="">${column.remarks}<#else>${column.javaField}</#if>"  name="${column.javaField}"  editable="true"  <#if column.formType??&&column.formType=="dateselect">  edittype="date" </#if>   <#if column.dictGroup??&&column.dictGroup!=""> edittype="select"  dict="${column.dictGroup}"</#if> <#if column.validType??&&column.validType!=""> datatype="${column.validType}" </#if> <#if column.nullmsg??&&column.nullmsg!=""> nullmsg="${column.nullmsg}" </#if> <#if column.errormsg??&&column.errormsg!=""> errormsg="${column.errormsg}" </#if>/>
							   </#if>
							</#list>
						</grid:grid>
						
					</div>
                </div>
                </#list>
          
            </div>
        </div>
    </div>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor,jqgrid,jqGrid_curdtools,jqGrid_curdtools_inline" />
<script>
	$(document).ready(function () {
	    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	    	 resizeGrid();
		});
	});
	$(function(){
	   $(window).resize(function(){   
		   resizeGrid();
	   });
	});
	function resizeGrid(){
		 <#list schedules as schedule>
		 $("#${schedule.className?uncap_first}Grid").setGridWidth($(window).width()-60);
	     </#list>
	}

	/**
	*提交回调方法
	*/
	function beforeSubmit(curform){
		 //这里最好还是使用JSON提交，控制器改变提交方法，并使用JSON方式来解析数
		 //通过判断，如果有问题不提交
		 <#list schedules as schedule>
		 if(!initGridFormData(curform,"${schedule.className?uncap_first}"))return false;
		 </#list>
		 return true;
	}
	
	function initGridFormData(curform,gridId){
		 var rowDatas =getRowDatas(gridId+"Grid");
		 var rowJson = JSON.stringify(rowDatas);
		 if(rowJson.indexOf("editable") > 0&&rowJson.indexOf("inline-edit-cell") )
	     {
	    	 return false;
	     }
		 var gridListJson=$('#'+gridId+"ListJson").val();
		 if(gridListJson==undefined||gridListJson==''){
			 var rowInput = $('<input id="'+gridId+'ListJson" type="hidden" name="'+gridId+'ListJson" />');  
			 rowInput.attr('value', rowJson);  
			 // 附加到Form  
			 curform.append(rowInput); 
		 }else{
			 $('#'+gridId+"ListJson").val(rowJson);
		 }
		 return true;
	}
</script>
</body>
</html>