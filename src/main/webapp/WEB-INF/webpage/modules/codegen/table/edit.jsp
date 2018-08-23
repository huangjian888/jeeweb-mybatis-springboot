<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>

<head>

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>表单设计</title>
    <meta name="keywords" content="<spring:message code="sys.site.keywords" arguments="${platformName}"/>">
	<meta name="description" content="<spring:message code="sys.site.description" arguments="${platformName}"/>">
    <link rel="shortcut icon" href="${staticPath}/common/favicon.ico">
    <html:css  name="bootstrap,font-awesome,animate,iCheck,datepicker,jqgrid,sweetalert,Validform,jqgrid"/>
    <link href="${staticPath}/common/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="white-bg">
	<div class="ibox-content">
       <form:form id="inputForm"  modelAttribute="data" action="${adminPath}/codegen/table/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="columnList" nested="false"/>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		       <tr>
		         <td  class="width-15 active text-right">
		              <label><font color="red">*</font>表名:</label>
		         </td>
		         <td class="width-35">
		               <form:input path="tableName" class="form-control " datatype="*" nullmsg="请输入表名称！" htmlEscape="false" />
		             <label class="Validform_checktip"></label>
		         </td>
		         <td  class="width-15 active text-right">
		              <label><font color="red">*</font>类名:</label>
		         </td>
		         <td class="width-35">
		               <form:input path="className" class="form-control " datatype="*" nullmsg="请输入表类名！" htmlEscape="false" />
		               <label class="Validform_checktip"></label>
		               <span class="help-block m-b-none">请输入类名</span>
		         </td>
		      </tr>
		      <tr>
		         <td  class="width-15 active text-right">	<label><font color="red">*</font>表类型:</label></td>
			     <td  class="width-35" >
			             <form:select path="tableType"  dict="tabletype" defaultvalue="1" class="form-control"></form:select>
			             <label class="Validform_checktip"></label>
			     </td>
		         <td  class="width-15 active">
		              <label class="pull-right">备注:</label>
		         </td>
		         <td class="width-35">
		               <form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="form-control "/>
		         </td>
		      </tr>
		   </tbody>
		   </table>

	</form:form>
	<div id="javaTypeForm" style="display:none;">
	     <div class="form-horizontal wrapper wrapper-content">
              <div class="form-group">
                  <label class="col-sm-3 control-label">包名：</label>
                  <div class="col-sm-8">
                      <input id="packagePath" name="packagePath" type="text" placeholder="包名" class="form-control">
                      <span class="help-block m-b-none">请输入包名</span>
                  </div>
              </div>
              <div class="form-group">
                  <label class="col-sm-3 control-label">类名：</label>
                  <div class="col-sm-8">
                      <input id="className" name="className"  type="text" placeholder="类名" class="form-control">
                      <span class="help-block m-b-none">请输入类名</span>
                  </div>
              </div>
          </div>
	</div>
	    <button class="btn btn-white btn-sm" onclick="return addRowData('attributeInfoTable')"><i class="fa fa-plus"> 增加</i></button>
		<button class="btn btn-white btn-sm" onclick="return delRowData('attributeInfoTable')"><i class="fa fa-minus"> 删除</i> </button>
	    <div class="row">
                <div class="tabs-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab_dbinfo" aria-expanded="true">数据库属性</a></li>
                        <li class=""><a data-toggle="tab" href="#tab_pageinfo" aria-expanded="false">页面属性</a></li>
                        <li class=""><a data-toggle="tab" href="#tab_validinfo" aria-expanded="false">页面校验</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab_dbinfo" class="tab-pane active">
                            <div class="panel-body">
                                <div class="jqGrid_wrapper">
		                            <table id="attributeInfoTable"></table>
		                        </div>
                            </div>
                        </div>
                        <div id="tab_pageinfo" class="tab-pane">
                            <div class="panel-body">
                                 <div class="jqGrid_wrapper">
		                            <table id="pageInfoTable"></table>
		                        </div>
                            </div>
                        </div>
                        <div id="tab_validinfo" class="tab-pane">
                            <div class="panel-body">
                                 <div class="jqGrid_wrapper">
		                            <table id="validInfoTable"></table>
		                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	</div>
    <!-- 全局js -->
    <html:js  name="jquery,bootstrap,jquery-ui,peity,iCheck,sweetalert,Validform,jqgrid"/>
    <script src="${staticPath}/modules/codegen/js/table.${dbType}.data.js"></script>
    <script src="${staticPath}/modules/codegen/js/table.edit.js"></script>
    <script language="javascript" type="text/javascript">
	    function resizeGrid(){
		    $("#attributeInfoTable").setGridWidth($(window).width()*0.99-28);
	        $("#pageInfoTable").setGridWidth($(window).width()*0.99-28);
	        $("#validInfoTable").setGridWidth($(window).width()*0.99-28);
		}
		$(document).ready(function(){
		   $(window).resize(function(){
			   resizeGrid();
		    });
		   $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
			   resizeGrid();
		   });
		   var oldTableTypeValue=$('#tableType').val();
		   $('#tableType').change(function(){
			  var tableTypeValue=$(this).val();
			  if(tableTypeValue==4){
				  var selectRowDatas=getRowDatas("attributeInfoTable",true);
				  //判断包含editable这些特殊标签，代表验证失败
				  var str = JSON.stringify(selectRowDatas);
			      if(str.indexOf("editable") > 0&&str.indexOf("inline-edit-cell") )
			      {
			    	    $('#tableType').val(oldTableTypeValue);
			    	    return false;
			      }
				  insertTreeField(selectRowDatas, treeTableExtent);//数据合并
				  //clearGridData();
				  //refreshGrid(selectRowDatas);
			  }else{
				  var selectRowDatas=getRowDatas("attributeInfoTable",true);
				  //判断包含editable这些特殊标签，代表验证失败
				  var str = JSON.stringify(selectRowDatas);
			      if(str.indexOf("editable") > 0&&str.indexOf("inline-edit-cell") )
			      {
			    	    $('#tableType').val(oldTableTypeValue);
			    	    return false;
			      }
			      deleteTreeField(selectRowDatas);
			     // clearGridData();
			     // refreshGrid(newRowDatas);
			  }
			  oldTableTypeValue=tableTypeValue;
	  	    });
	   });

	   function deleteTreeField(oldRowDatas){
		   for (var i=0;i<oldRowDatas.length;i++)
		   {
		       var rowsdata=oldRowDatas[i];
		       var rowid=rowsdata.id;
		       if(rowid.indexOf("templateid")!=-1){
		    	   //添加一行
		    	   $("#attributeInfoTable").jqGrid("delRowData", rowid);
		  		   delRowDataExt(rowid);
		       }
		   }
	   }

	   function insertTreeField(oldRowDatas,treeTableExtent){
		   for (var i=0;i<treeTableExtent.length;i++)
		   {
			   var treedata=treeTableExtent[i];
			   var columnName=treedata.columnName;
			   var hasTree=false;
			   for (var j=0; j< oldRowDatas.length;j++)
			   {
			       var rowsdata=oldRowDatas[j];
			       //如果有数的列表
			       if(columnName==rowsdata.columnName){
			    	   hasTree=true;
			       }
			   }
			   if(!hasTree){
				    var gridObject = $('#attributeInfoTable');
				    var dataRow = treedata;
				    //如果jqgrid中没有数据 定义行号为1 ，否则取当前最大行号+1
				    var rowid ="templateid"+random(6);
				    dataRow.id="";
				    gridObject.jqGrid("addRowData", rowid, dataRow, "last");
				    addRowDataExt(rowid, dataRow);
			   }
		   }
		   return oldRowDatas;
	   }
	</script>
	<script type="text/javascript">
	   $.jgrid.defaults.width = $(window).width()*0.99-32;
	   $.jgrid.defaults.responsive = true;
	   $.jgrid.defaults.styleUI = 'Bootstrap';

	    function initTable(data)
	    {
	    	 var javaField=[<c:forEach items="${javaTypes}" var="javaType" varStatus="stat">'${javaType}'<c:if test="${!stat.last}">,</c:if></c:forEach>];
	    	 var baseJavaType="<c:forEach items="${javaTypes}" var="javaType" varStatus="stat">${javaType}:${javaType}<c:if test="${!stat.last}">;</c:if></c:forEach>";
	    	 var typeNames="<c:forEach items="${typeNames}" var="typeName" varStatus="stat">${typeName}:${typeName}<c:if test="${!stat.last}">;</c:if></c:forEach>";
	    	 var mainTables=":请选择主表;<c:forEach items="${mainTables}" var="mainTable" varStatus="stat">${mainTable.tableName}:${mainTable.tableName}<c:if test="${!stat.last}">;</c:if></c:forEach>";
	    	 var extendTypes="${extendTypes};other:自定义JAVA类型";
	    	 var javaTypeConf=baseJavaType+extendTypes;
	    	 var attributeColModel=[
			    					{ label: '字段名称', name: 'columnName', width: 100,  editable: true,editrules: {
			                            required: true
			                        }},
			    					{ label: '字段备注', name: 'remarks', width: 120, editable: true,editrules: {
			                            required: true
			                        }},
									{ label: '字段类型', name: 'typeName', width: 100, formatter:'select', editable: true,
									    edittype: "select",
									    editoptions:{value:typeNames}
									},
			    					{ label: '字段长度', name: 'columnSize', width: 60, editable: true,editrules: {
										number: true,
			                            minValue: 1,
			                            required: true
			                        }},
			    					{ label: '小数点', name: 'decimalDigits', width: 50, editable: true,editrules: {
										number: true,
			                            minValue: 0,
			                            maxValue: 2,
			                            required: false
			                        }},
			    					{ label: '默认值', name: 'columnDef', width: 50, editable: true},
			    					{ label: 'JAVA类型', name: 'javaType', width: 120,formatter:'select', editable: true,
									    edittype: "select",
									    editoptions: {
									        value:javaTypeConf
									        , dataEvents: [
									                       { type: 'change',          //下拉选择的时候
									                           fn: function(e) {
									                        	   var selectValue=this.value;
									                        	   if($.inArray(selectValue, javaField)=='-1'){
									                        		   var targetId="select#"+e.target.id;
										                               var target = $(targetId);//获取下面下拉框javaType对象
										                               //target.append("<option role=\"option\" value=\"sdfs\">sdfsdf</option>");
										                               var javaTypeForm=$("#javaTypeForm").clone();
										                               javaTypeForm.attr("id", "javaTypeItem"); ///必须加入，否则id会重复，导致操纵时混乱
										                               if(selectValue!=undefined&&selectValue!=''){
										                            	   var values=selectValue.split('|');
										                            	   if(values.length==2){
											                               	   javaTypeForm.find("#packagePath").attr("value",values[0]);
											                              	   javaTypeForm.find("#className").attr("value",values[1]);
										                            	   }
										                               }
										                               javaTypeForm.find("#packagePath").attr("id", "packagePathItem");
										                               javaTypeForm.find("#className").attr("id", "classNameItem");

										                               var content=javaTypeForm.html();
										                               //在这里面输入任何合法的js语句
										                               top.layer.open({
										                                 type: 1 //Page层类型
										                                 ,area: ['500px', '300px']
										                                 ,title: '自定义JAVA类型'
										                                 ,shade: 0.6 //遮罩透明度
										                                 ,maxmin: true //允许全屏最小化
										                                 ,anim: 1, //0-6的动画形式，-1不开启
										                                 content:content,
										                                 btn: ['确定', '关闭'],
										         					     yes: function(index, layero){ //或者使用btn1
										         					    	 var packagePath=layero.find("#packagePathItem").val();
										         					    	 var className=layero.find("#classNameItem").val();

										         					    	 if(packagePath==undefined||packagePath==''){
										         					    		 top.layer.tips('请填写包名！', '#packagePathItem');
										         					    		 return false;
										         					    	 }
										         					    	 if(className==undefined||className==''){
										         					    		top.layer.tips('请填写类名！', '#classNameItem');
										         					    		return false;
										         					    	 }
										         					    	 //类名不能为已经存在的基础类型
										         					    	 if($.inArray(className, javaField)!='-1'){
										         					    		top.layer.tips('类名不能为已经存在的基础类型！', '#classNameItem');
										         					    		return false;
										         					    	 }
										         					    	 var realPath=packagePath+"|"+className;
										         					    	 var extend=realPath+":"+className;
										         					    	 if(javaTypeConf.indexOf(realPath)==-1){
										         					    		javaTypeConf+=";"+extend;
										         					    		target.append("<option role=\"option\" value=\""+realPath+"\">"+className+"</option>");
										         					    		$("#attributeInfoTable").setColProp('javaType',{editoptions:{value:javaTypeConf}});
										         					    	 }
										         					    	 //设置选中最后
										         					    	 target.val(realPath);
										         					    	 top.layer.close(index);

										         					     },
										         			    	     cancel: function(index){}
										                               });
									                        	   }

									                           }
									                       }
									                    ]
									},editrules: {
			                            required: true
			                        }},
									{ label: 'JAVA属性名称', name: 'javaField', width: 120, editable: true,editrules: {
			                            required: true
			                        }},
			                        { label: '主表', name: 'foreignTable', width: 120, editable: true,
			                            edittype: "select",
			                            editoptions: {
			                                value: mainTables
			                    	}},
			                        { label: '主键', name: 'parmaryKey', width: 40, editable: true,
				                            edittype: "checkbox",
				                            editoptions: {
				                                value: "true:false"
				                    }},
				                    { label: '空值', name: 'nullable', width: 40, editable: true,
			                            edittype: "checkbox",
			                            editoptions: {
			                            	value: "true:false"
			                       }}
			 ];

	    	 initGrid('attributeInfoTable',attributeColModel,data);

	    	 var pageInfoColModel=[
									{ label: '字段名称', name: 'columnName', width: 100},
									{ label: '字段备注', name: 'remarks', width: 120},
									{ label: '表单', name: 'isForm', width: 50, editable: true,
									        edittype: "checkbox",
									        editoptions: {
									            value: "true:false"
									}},
									{ label: '查询', name: 'isQuery', width: 50, editable: true,
									        edittype: "checkbox",
									        editoptions: {
									            value: "true:false"
									}},
									{ label: '列表', name: 'isList', width: 50, editable: true,
									        edittype: "checkbox",
									        editoptions: {
									            value: "true:false"
									}},
									{ label: '查询方式', name: 'queryType', width: 100, formatter:'select', editable: true,
									    edittype: "select",
									    editoptions: {
									        value: "eq:等于;ne:不等于;gt:大于;ge:大于等于;le:小于等于;isNull:是否为空;isNotNull:非空;in:包含;notIn:不包含;between:between;prefixLike:前缀模糊匹配;prefixNotLike:前缀模糊不匹配;suffixLike:后缀模糊匹配;suffixNotLike:后缀模糊不匹配;like:模糊匹配;notLike:不匹配"
									}},
									{ label: '查询模式', name: 'queryModel', width: 100, formatter:'select', editable: true,
									    edittype: "select",
									    editoptions: {
									        value: "input:input;select:select;radio:radio;checkbox:checkbox;date:date"
									}},
									{ label: '显示表单类型', name: 'formType', width: 120, formatter:'select', editable: true,
									    edittype: "select",
									    editoptions: {
									        value: "input:单行文本;textarea:多行文本;select:下拉选项;radiobox:单选按钮;checkbox:复选框;dateselect:日期选择;editor:编辑器;fileinput:文件上传;avatarinput:头像上传"
									}},
									{ label: '字典类型', name: 'dictGroup', width: 120, editable: true}
			             ];

	    	    initGrid('pageInfoTable',pageInfoColModel,data);

	    	    var validInfoColModel=[
										{ label: '字段名称', name: 'columnName', width: 120},
										{ label: '字段备注', name: 'remarks', width: 120},
										{ label: '校验类型', name: 'validType', width: 120, formatter:'select', editable: true,
										    edittype: "select",
										    editoptions: {
										        value: ":不验证;*:必填;n:数字;s:字符串;p:邮政编码;m:手机号码;e:电子邮件;url:网址;idcard:身份证"
										}},
										{ label: '验证规则', name: 'regexValid', width: 100, editable: true},
										{ label: '为空提示', name: 'nullmsg', width: 120, editable: true},
										{ label: '最小长度', name: 'minSize', width: 80, editable: true,editrules: {
											number: true
				                        }},
										{ label: '最大长度', name: 'maxSize', width: 80, editable: true,editrules: {
											number: true
				                        }},
				                        { label: '最小值', name: 'minValue', width: 80, editable: true},
				                        { label: '最大值', name: 'maxValue', width: 80, editable: true}
				             ];

		    	initGrid('validInfoTable',validInfoColModel,data);

			   	$("#attributeInfoTable").jqGrid('sortableRows',{
			 		update:function(){
			 		    //动态的更改行
					    var datas=getRowDatas("attributeInfoTable",true);
					    //刷新
					    //传入查询条件参数
					    $("#pageInfoTable").jqGrid('setGridParam',{
					    	data:datas
					    }).trigger("reloadGrid"); //重新载入
					   //传入查询条件参数
					    $("#validInfoTable").jqGrid('setGridParam',{
					    	data:datas
					    }).trigger("reloadGrid"); //重新载入
			 		}
			 	});
	 	}

	    var lastSelection="";
	    function editRow(id) {
            if (id && id !== lastSelection) {
                var grid = $("#attributeInfoTable");
                grid.jqGrid('restoreRow',lastSelection);
                grid.jqGrid('editRow',id, {keys:true, focusField: 4});
                lastSelection = id;
            }
        }

	    $(document).ready(function () {
	    	 var initTableData=${columns};
	    	 if(initTableData.length==0){
	    	   for (var j=0; j< singleTable.length;j++)
			   {
			       singleTable[j].id=singleTable[j].id+random(6);;
			   }
	    	   initTableData=singleTable;
	    	 }
	    	 //初始化Table
	    	 initTable(initTableData);
	    	 initListener();
	    });

	    function initListener(){
	    	//通过on事件监听数据的变化
			$("#attributeInfoTable").on('input',function(e){
				   var element =event.target;
				   var inputName=$(element).attr("name");
				   if(inputName=='columnName'||inputName=='remarks'){
					    var rowid = $(element).attr("rowid");
					    var value=$(element).val();
					    //动态的更改行
					    var data=getGridRowData("pageInfoTable",rowid);
					    data[inputName]=value;
					    $("#pageInfoTable").jqGrid("setRowData", rowid, data);
					    //动态的更改行
					    var datas=getRowDatas("pageInfoTable",true);
					    //刷新
					    //传入查询条件参数
					    $("#pageInfoTable").jqGrid('setGridParam',{
					    	data:datas
					    }).trigger("reloadGrid"); //重新载入
					    //传入查询条件参数
					    $("#validInfoTable").jqGrid('setGridParam',{
					    	data:datas
					    }).trigger("reloadGrid"); //重新载入
				   }

			});
	    }
    </script>
    
</body>

</html>