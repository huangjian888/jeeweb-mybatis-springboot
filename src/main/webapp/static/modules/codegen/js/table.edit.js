//初始化表单
var validateForm;
var callFunc;
//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
function doSubmit(func){
	callFunc=func;
    validateForm.ajaxPost();
}

$(document).ready(function() {
      validateForm = $("#inputForm").Validform({
		tiptype:function(msg,o,cssctl){
			if(!o.obj.is("form")){
				var objtip=o.obj.siblings(".Validform_checktip");
				cssctl(objtip,o.type);
				objtip.text(msg);
			}
		},
		ajaxPost: true,
		beforeSubmit:function(curform){
		    //var rowIds = jQuery("#attributeInfoTable").jqGrid('getDataIDs');        //返回当前grid里所有数据的id  
		    var selectRowDatas=getRowDatas("attributeInfoTable",true);
		    var str = JSON.stringify(selectRowDatas); 
		    //判断包含editable这些特殊标签，代表验证失败
	    	if(str.indexOf("editable") > 0&&str.indexOf("inline-edit-cell") )
	    	{
	    	    return false;
	    	}
            $("#columnList").val(str);
			return true;	
		},callback:function(result){
			if(result.ret==0)
        	{
        	    top.layer.alert(result.msg, {icon: 0, title:'提示'});
        	    callFunc();
        	}else
        	{
        		top.layer.alert(result.msg, {icon: 0, title:'警告'});
        	}
		}
	});
	
});

//生成随机数
function random(length){
	var rand = "";
	for(var i = 0; i < length; i++){
	    var r = Math.floor(Math.random() * 10);
	    rand += r;
	}
	return rand;
}

//添加行数据
function addRowData(gridId){ //创建一条空的记录，待编辑  
    var gridObject = $('#'+gridId);  
    //获取表格的初始model    
    var colModel = gridObject.jqGrid().getGridParam("colModel") ;    
    var dataRow = JSON.stringify(colModel);   
    //var ids = gridObject.jqGrid('getDataIDs');    
    //如果jqgrid中没有数据 定义行号为1 ，否则取当前最大行号+1    
    var rowid ="insertrow"+random(6);
    gridObject.jqGrid("addRowData", rowid, dataRow, "last"); 
    //addRowDataExt(rowid, dataRow);
}  
   
//添加扩展数据
function addRowDataExt(rowid,dataRow){
	var gridObject = $('#pageInfoTable');  
	gridObject.jqGrid("addRowData", rowid, dataRow, "last"); 
	var validGridObject = $('#validInfoTable');  
	validGridObject.jqGrid("addRowData", rowid, dataRow, "last"); 
}

function delRowData(gridId){
	var ids = [];
	var rows =$("#"+gridId).jqGrid('getGridParam','selarrrow');
	var rowData= $("#"+gridId).jqGrid('getGridParam','selrow');
	var multiselect=$("#"+gridId).jqGrid('getGridParam','multiselect');
	if(!multiselect)
	{
		if(rowData)
		{
			rows[0]=rowData;
		}
	}
	if(rows.length==0){
          alert("请选择要删除的行");
          return;
    }
	var len = rows.length;  
	for ( var i = 0; i < len; i++) {
		 var rowid=rows[0];
		 $("#"+gridId).jqGrid("delRowData", rowid);   
		 delRowDataExt(rowid);
	}
}

function delRowDataExt(rowid){
	var gridObject = $('#pageInfoTable');  
	gridObject.jqGrid("delRowData",rowid); 
	var validGridObject = $('#validInfoTable');  
	validGridObject.jqGrid("delRowData",rowid); 
}

function getRowDatas(gridId,hasExtend){
	var gridObject = $("#"+gridId);  
    var rowIds = gridObject.jqGrid('getDataIDs');        //返回当前grid里所有数据的id  
    var selectRowDatas=[];
    for(var i=0;i < rowIds.length;i++){
    	var rowid=rowIds[i];
    	var attributeInfo=getGridRowData(gridId,rowid);
    	gridObject.editRow(rowid, true); 
    	if(hasExtend!=undefined &&hasExtend){
    		var extendDatas=getRowExtendDatas(rowid);
        	selectRowDatas[i] =$.extend(extendDatas,attributeInfo);
    	}else{
    		selectRowDatas[i] =attributeInfo;
    	}
    	if(rowid.indexOf("insertrow")==-1){
    		selectRowDatas[i].id=rowid;
    	}
    	selectRowDatas[i].sort=i+1;
    }
    return selectRowDatas;
}

function getRowExtendDatas(rowid){
	var pageInfo=getGridRowData('pageInfoTable',rowid);
	var validInfo=getGridRowData('validInfoTable',rowid);
	//恢复编辑状态
	$.extend(pageInfo, validInfo);//合并对象
	return pageInfo;
}

function getGridRowData(gridId,rowid){
	var gridObject = $("#"+gridId);  
	gridObject.saveRow(rowid, false, 'clientArray');
	var rowData=gridObject.jqGrid('getRowData',rowid);
	gridObject.editRow(rowid, true); 
	return rowData;
}

function setGridEdit(gridId){
	 var gridObject = $("#"+gridId);  
	 var rowIds = gridObject.jqGrid('getDataIDs');        //返回当前grid里所有数据的id  
         for(var i=0;i < rowIds.length;i++){  
         	 var rowid=rowIds[i];
         	 gridObject.editRow(rowid, true); 
         }
	}
   function initGrid(girdid,colModel,data){
	 //初始化用户列表
 	 $("#"+girdid).jqGrid({
 	         datatype: "local",
			 data: data,
             height: 450,
             editurl: 'clientArray',
             jsonReader : {  
                 root:"results",  
                 page: "page",  
                 total: "totalPage",  
                 records: "total"  
             },
             gridComplete: function() {//表格生成完成后的回调函数。  
            	 setGridEdit(girdid);
             },
             viewrecords: true,
             colModel:colModel,
             autowidth: false,
             multiselect:true,
             shrinkToFit: true,
             sortable:true,
             rownumbers: true,
             rownumWidth: 35,
             rowNum:10000,
             altRows: true
         });
}