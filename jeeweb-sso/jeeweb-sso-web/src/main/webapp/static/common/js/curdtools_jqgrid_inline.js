/*!
 * Copyright &copy; 2016-2020 <a href="http://www.jeeweb.cn/">JeeWeb</a> All rights reserved.
 * 
 * 行内编辑
 * @author auth_team
 * @version 2017-06-03
 */
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
    var colModel = gridObject.jqGrid().getGridParam("colModel");    
    var dataRow = JSON.stringify(colModel);   
    //var ids = gridObject.jqGrid('getDataIDs');    
    //如果jqgrid中没有数据 定义行号为1 ，否则取当前最大行号+1    
    var rowid ="insertrow"+random(6);
    gridObject.jqGrid("addRowData", rowid, dataRow, "last"); 
}  
//删除行
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
	}
}

function getRowDatas(gridId,hasExtend){
	var gridObject = $("#"+gridId);  
    var rowIds = gridObject.jqGrid('getDataIDs');        //返回当前grid里所有数据的id  
    var selectRowDatas=[];
    for(var i=0;i < rowIds.length;i++){
    	var rowid=rowIds[i];
    	var gridInfo=getGridRowData(gridId,rowid);
    	gridObject.editRow(rowid, true); 
    	selectRowDatas[i] =gridInfo;
    	if(rowid.indexOf("insertrow")==-1){
    		selectRowDatas[i].id=rowid;
    	}
    }
    return selectRowDatas;
}

function getGridRowData(gridId,rowid){
	var gridObject = $("#"+gridId);  
	gridObject.saveRow(rowid, false, 'clientArray');
	var rowData=gridObject.jqGrid('getRowData',rowid);
	gridObject.editRow(rowid, true); 
	return rowData;
}