/*!
 * Copyright &copy; 2016-2020 <a href="http://www.jeeweb.cn/">JeeWeb</a> All rights reserved.
 * 
 * 通用公共方法
 * @author auth_team
 * @version 2016-12-04
 */
/**
 * 新增事件打开窗口
 * 
 * @param title
 *            编辑框标题
 * @param addurl//目标页面地址
 */
function add(title, url, width, height, target) {
	openDialog(title, url, width, height, target);
}

/**
 * 更新事件打开窗口
 * 
 * @param title
 *            编辑框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function update(title, url, tableid, width, height, target) {
	var rowsData = $("#" + tableid).bootstrapTable('getSelections');
	if (!rowsData || rowsData.length == 0) {
		top.layer.alert('请至少选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}
	if (rowsData.length > 1) {
		top.layer.alert('只能选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}

	var id = rowsData[0].id;
	;
	openDialog(title, url + "?id=" + id, "800px", "500px", "");
}

// 打开对话框(添加修改)
function openDialog(title, url, width, height, target) {
	width = width ? width : '800px';
	height = height ? height : '500px';
	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {// 如果是移动端，就使用自适应大小弹窗
		width = 'auto';
		height = 'auto';
	} else {// 如果是PC端，根据用户设置的width和height显示。

	}
	top.layer.open({
		type : 2,
		area : [ width, height ],
		title : title,
		maxmin : true, // 开启最大化最小化按钮
		content : url,
		btn : [ '确定', '关闭' ],
		yes : function(index, layero) {
			var body = top.layer.getChildFrame('body', index);
			var iframeWin = layero.find('iframe')[0]; // 得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			// 文档地址
			// http://www.layui.com/doc/modules/layer.html#use
			iframeWin.contentWindow.doSubmit(top, index, function() {
				// 刷新表单
				refreshTable('contentTable');
			});

		},
		cancel : function(index) {
		}
	});

}

// 打开对话框(查看)
function openDialogView(title, url, width, height) {

	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {// 如果是移动端，就使用自适应大小弹窗
		width = 'auto';
		height = 'auto';
	} else {// 如果是PC端，根据用户设置的width和height显示。

	}
	top.layer.open({
		type : 2,
		area : [ width, height ],
		title : title,
		maxmin : true, // 开启最大化最小化按钮
		content : url,
		btn : [ '关闭' ],
		cancel : function(index) {
		}
	});
}

/**
 * 多记录刪除請求
 * 
 * @param title
 * @param url
 * @param gname
 * @return
 */
function deleteALLSelect(title, url, tableid) {
	var ids = [];
	var rows = $("#" + tableid).bootstrapTable('getSelections');
	if (rows.length > 0) {
		swal({
			title : "提示",
			text : "您确定要删除这些信息么，请谨慎操作！",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "确定",
			closeOnConfirm : false,
			cancelButtonText : "取消",
		}, function() {
			for (var i = 0; i < rows.length; i++) {
				// alert(rows[i].id);
				ids.push(rows[i].id);
			}
			$.ajax({
				url : url,
				type : 'post',
				data : {
					ids : ids.join(',')
				},
				cache : false,
				success : function(d) {
					if (d.ret == 0) {
						var msg = d.msg;
						swal("删除成功！", msg, "success");
						// 刷新表单
						refreshTable('contentTable');
					}
				}
			});
		});
		return;
	} else {
		top.layer.alert('请选择需要删除的数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}
}

/**
 * 多记录刪除請求
 * 
 * @param title
 * @param url
 * @param gname
 * @return
 */
function delObj(title, url, infoid) {
	swal({
		title : "提示",
		text : "您确定要删除这些信息么，请谨慎操作！",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "确定",
		closeOnConfirm : false,
		cancelButtonText : "取消",
	}, function() {
		$.ajax({
			url : url,
			type : 'post',
			data : {
				id : infoid
			},
			cache : false,
			success : function(d) {
				if (d.ret == 0) {
					var msg = d.msg;
					swal("删除成功！", msg, "success");
					// 刷新表单
					refreshTable('contentTable');
				}
			}
		});
	});
}

function refreshTable(tableid) {
	doSearch(tableid);
}

/**
 * 查看详细事件打开窗口
 * 
 * @param title
 *            查看框标题
 * @param addurl//目标页面地址
 * @param id//主键字段
 */
function detail(title, url, tableid, width, height) {
	var rowsData = $("#" + tableid).bootstrapTable('getSelections');
	if (!rowsData || rowsData.length == 0) {
		top.layer.alert('请至少选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}
	if (rowsData.length > 1) {
		top.layer.alert('只能选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}

	var id = rowsData[0].id;
	;
	openDialogView(title, url + "&id=" + id, "800px", "500px", "");
}

function searchReset(tableid) {
	$("#" + tableid + "Query").find(":input").val("");
	demandListsearch();
}

function doSearch(tableid) {
	var queryParams = {};

	$('#' + tableid + "Query").find(":input").each(function() {
		// 普通的查询
		var val = $(this).val();
		if (queryParams[$(this).attr('name')]) {
			val = queryParams[$(this).attr('name')] + "," + $(this).val();
		}
		queryParams[$(this).attr('name')] = val;
	});

	// 普通的查询
	$('#' + tableid + "Query").find(":input").each(function() {
		var condition = $(this).attr('condition');
		if (!condition) {
			condition = "";
		}
		var key = "query." + $(this).attr('name') + "||" + condition;
		queryParams[key] = queryParams[$(this).attr('name')];
	});

	$("#" + tableid).bootstrapTable('refresh', {
		pageNumber : 1,
		query : queryParams
	// 传到后台的参数
	});
}