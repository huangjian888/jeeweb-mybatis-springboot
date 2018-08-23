/*!
 * Copyright &copy; 2016-2020 <a href="http://www.jeeweb.cn/">JeeWeb</a> All rights reserved.
 * 
 * 通用公共方法
 * @author auth_team
 * @version 2016-12-04
 */
/**
 * 新增事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function create(title,url,gridid,width,height) {
	openDialog(title,url,gridid,width,height);
}

/**
 * 新增事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function createDialog(title,url,gridid,width,height) {
	openDialog(title,url,gridid,width,height);
}





/**
 * 更新事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function update(title,url,gridId,width,height) {
	var rowsData = $("#"+gridId).jqGrid('getGridParam','selarrrow');
	var multiselect=$("#"+gridId).jqGrid('getGridParam','multiselect');
	var rowData= $("#"+gridId).jqGrid('getGridParam','selrow');
	if(!multiselect)
	{
		if(rowData)
		{
			  rowsData[0]=rowData;
		}
	}
    if (!rowsData || rowsData.length==0) {
	    top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
		return; 
	}
    if (rowsData.length>1) {
    	top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
		return;
	}
    
    var id = rowsData[0];
    url=url.replace("{id}",id);
    openDialog(title,url,gridId,width, height);
}

/**
 * 更新事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function updateDialog(title,url,gridId,width,height) {
	console.log("gridId:"+gridId);
	var rowsData = $("#"+gridId).jqGrid('getGridParam','selarrrow');
	var multiselect=$("#"+gridId).jqGrid('getGridParam','multiselect');
	var rowData= $("#"+gridId).jqGrid('getGridParam','selrow');

	console.log("rowsData:"+rowsData);
	if(!multiselect)
	{
		if(rowData)
		{
			  rowsData[0]=rowData;
		}
	}
    if (!rowsData || rowsData.length==0) {
	    top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
		return; 
	}
    if (rowsData.length>1) {
    	top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
		return;
	}
    
    var id = rowsData[0];
    url=url.replace("{id}",id);
    openDialog(title,url,gridId,width, height);
}

/**
 * 多记录选择請求
 * @param title
 * @param url
 * @param gname
 * @return
 */
function toolbarSelectConfirm(title,url,gridId,tipMsg) {
	if(tipMsg==undefined||tipMsg==''){
		  tipMsg="您确定要执行该操作！";
	}
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
    if (rows.length > 0) {
    	swal({
            title: title+"提示",
            text: tipMsg,
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false,
            cancelButtonText: "取消",
        }, function () {
        	for ( var i = 0; i < rows.length; i++) {
        		ids.push(rows[i]);
			}
			$.ajax({
				url : url,
				type : 'post',
				data : {
					ids : ids.join(',')
				},
				cache : false,
				success : function(d) {
					if (d.ret==0) {
						var msg = d.msg;
					    swal(title+"提示！", msg, "success");
					    //刷新表单
			            refreshTable(gridId);
					}else{
						var msg = d.msg;
					    swal(title+"提示！", msg, "error");
					}
				}
			});
        });
		return;
	}else
	{
	    top.layer.alert('请选择需要操作的数据!', {icon: 0, title:'警告'});
	    return;
	}
}

//打开对话框(添加修改)
function openDialog(title,url,gridId,width,height){
	console.log("openDialog url:"+url);
	width = width?width:'800px';
	height = height?height:'500px';
	if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
		width='auto';
		height='auto';
	}else{//如果是PC端，根据用户设置的width和height显示。
	
	}
	top.layer.open({
	    type: 2,  
	    area: [width, height],
	    title: title,
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['确定', '关闭'],
	    yes: function(index, layero){
	    	 var body = top.layer.getChildFrame('body', index);
	         var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
	         //文档地址
	         //http://www.layui.com/doc/modules/layer.html#use
	         iframeWin.contentWindow.doSubmit(function()
	         {
	        	 //判断逻辑并关闭
       	         setTimeout(function(){top.layer.close(index)}, 100);//延时0.1秒，对应360 7.1版本bug
	        	 //刷新表单
	        	 refreshTable(gridId);
	         });
			
		  },
		  cancel: function(index){ 
			  
		  }
	}); 	
	
}

/**
 * 单条记录删除
 * @param title
 * @param url
 * @param gname
 * @return
 */
function deleteRowData(title,url,infoid,gridId,tipMsg) {
	   url=url.replace("{id}",infoid);
	   if(tipMsg==undefined||tipMsg==''){
		   msg= "您确定要删除该信息么，请谨慎操作！";
	   }
	   swal({
            title: "提示",
            text: msg,
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false,
            cancelButtonText: "取消",
        }, function () {
			$.ajax({
				url : url,
				type : 'post',
				data : {
					id : infoid
				},
				cache : false,
				success : function(d) {
					if (d.ret==0) {
						var msg = d.msg;
					    swal("提示！", msg, "success");
					    //刷新表单
			            refreshTable(gridId);
					}else{
						var msg = d.msg;
					    swal("提示！", msg, "error");
					}
				}
			});
        });
}

/**
 * 多记录刪除請求
 * @param title
 * @param url
 * @param gname
 * @return
 */
function batchDelete(title,url,gridId,baseUrl) {
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
    if (rows.length > 0) {
    	swal({
            title: "提示",
            text: "您确定要删除这些信息么，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false,
            cancelButtonText: "取消",
        }, function () {
        	for ( var i = 0; i < rows.length; i++) {
        		ids.push(rows[i]);
			}
			$.ajax({
				url : url,
				type : 'post',
				data : {
					ids : ids.join(','),
					callbackType : 'json',
					baseUrl : baseUrl,
					actionType : 'delete'
				},
				cache : false,
				success : function(d) {
					if (d.ret==0) {
						var msg = d.msg;
					    swal("提示！", msg, "success");
					    //刷新表单
			            refreshTable(gridId);
					}else{
						var msg = d.msg;
					    swal("提示！", msg, "error");
					}
				},
				error:function (d) {
                    // console.log(d);
                }
			});
        });
		return;
	}else
	{
	    top.layer.alert('请选择需要删除的数据!', {icon: 0, title:'警告'});
	    return;
	}
}

/**
 * 行内提示性操作
 * @param title
 * @param url
 * @param gname
 * @return
 */
function rowConfirm(title,url,infoid,gridId,tipMsg) {
	  url=url.replace("{id}",infoid);
	  if(tipMsg==undefined||tipMsg==''){
		  tipMsg="您确定要执行该操作！";
	  }
	   swal({
            title: "提示",
            text: tipMsg,
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false,
            cancelButtonText: "取消",
        }, function () {
			$.ajax({
				url : url,
				type : 'post',
				data : {
					id : infoid
				},
				cache : false,
				success : function(d) {
					if (d.ret==0) {
						var msg = d.msg;
					    swal("提示！", msg, "success");
					    //刷新表单
			            refreshTable(gridId);
					}else{
						var msg = d.msg;
					    swal("提示！", msg, "error");
					}
				}
			});
        });
}

/*
 * 搜索重置
 */
function reset(gridId) {
    $("#" + gridId + "Query").find(":input").val("");
    //运行搜索
    search(gridId);
}


/**
 *搜索
 * @param gridId
 */
function search(gridId) {
    var queryParams = {};
    var queryFields=$('#queryFields').val();
    queryParams['queryFields'] = queryFields;
    //普通的查询
    $('#' + gridId + "Query").find(":input").each(function() {
		var val = $(this).val();
		if (queryParams[$(this).attr('name')]) {
			val = queryParams[$(this).attr('name')] + "," + $(this).val();
		}
		queryParams[$(this).attr('name')] = val;
	});

	// 普通的查询
	$('#' + gridId + "Query").find(":input").each(function() {
		var condition = $(this).attr('condition');
		if (!condition) {
			condition = "";
		}
		var key = "query." + $(this).attr('name') + "||" + condition;
		queryParams[key] = queryParams[$(this).attr('name')];
	});
	console.log("search queryParams:"+JSON.stringify(queryParams));
    //刷新
    //传入查询条件参数
    $("#"+gridId).jqGrid('setGridParam',{
        datatype:'json',
        postData:queryParams, //发送数据
        page:1
    }).trigger("reloadGrid"); //重新载入
}


/**
 * 更新事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function updateObj(title,url,gridId,id,width,height) {
	url=preprocessUrl(url,id);
    openDialog(title,url,gridId,width, height);
}


//打开对话框(查看)
function openDialogDetailRefresh(title,url,gridId,width,height){
	if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
		width='auto';
		height='auto';
	}else{//如果是PC端，根据用户设置的width和height显示。
	
	}
	top.layer.open({
	    type: 2,  
	    area: [width, height],
	    title: title,
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['关闭'],
	    cancel: function(index){ 
	    	//刷新表单
       	    refreshTable(gridId);
	    }
	}); 
}

//打开对话框(查看)
function openDialogDetail(title,url,width,height){
	if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
		width='auto';
		height='auto';
	}else{//如果是PC端，根据用户设置的width和height显示。
	
	}
	top.layer.open({
	    type: 2,  
	    area: [width, height],
	    title: title,
        maxmin: true, //开启最大化最小化按钮
	    content: url ,
	    btn: ['关闭'],
	    cancel: function(index){ 
	    	 
	    }
	}); 
}







/***行內操作的一些内置方法*/



//打开对话框(添加修改)
function rowDialog(title,url,gridId,id,width,height){
	openDialog(title,url+"?id="+id,gridId,width, height);
}

//打开对话框(查看)
function rowDialogDetailRefresh(title,url,gridId,id,width,height){
	var url=preprocessUrl(url,id);
	openDialogDetailRefresh(title,url,gridId,width,height);
}

//打开对话框(查看)
function rowDialogDetail(title,url,width,height){
	var url=preprocessUrl(url,id);
	openDialogDetail(title,url,width,height);
}

function refreshTable(gridId)
{
	search(gridId);
}

function preprocessUrl(url,id){
	if(isContains(url,"?id=")||isContains(url,"&id="))
	{
		return url;
	}
	if(url.indexOf("?")!=-1) 
	{
		return url+"&id="+id;
	}else{
		return url+"?id="+id;
	} 
}

function isContains(str, substr) {
    return str.indexOf(substr) >= 0;
}

/**
 * 查看详细事件打开窗口
 * @param title 查看框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function detail(title,url, gridId,width,height) {
	var rowsData =$("#"+gridId).bootstrapTable('getSelections');
    if (!rowsData || rowsData.length==0) {
	  top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
		return; 
	}
    if (rowsData.length>1) {
    	top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
		return;
	}
    
    var id = rowsData[0].id;;
    openDialogView(title,url+"&id="+id,"800px", "500px","");
}


