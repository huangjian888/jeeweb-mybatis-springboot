<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<!-- 例子 http://issues.wenzhixin.net.cn/bootstrap-table/index.html#options/table-style.html -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>H+ 后台主题UI框架 - 基础表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="${adminPath}/static/common/favicon.ico"> 
    <link href="${adminPath}/static/common/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${adminPath}/static/common/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${adminPath}/static/iCheck/custom.css" rel="stylesheet">
    <link href="${adminPath}/static/common/css/animate.css" rel="stylesheet">
    <link href="${adminPath}/static/common/css/style.css?v=4.1.0" rel="stylesheet">
    
    <!-- bootstrap-table CSS -->
    <link href="${adminPath}/static/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    
    <!-- Sweet Alert -->
    <link href="${adminPath}/static/sweetalert/sweetalert.css" rel="stylesheet">
    
    <link rel="stylesheet" href="${adminPath}/static/bootstrap-table/extensions/reorder-rows/bootstrap-table-reorder-rows.css">
    
    

    
</head>
<body class="gray-bg">
     <div class="wrapper wrapper-content animated fadeInRight">
	       <div class="row">
	            <div class="col-sm-12">
	                <div class="ibox float-e-margins">
	                    <div class="ibox-title">
	                        <h5>${group.name}-字典值管理</h5>
	                        <div class="ibox-tools">
	                            <a class="collapse-link">
	                                <i class="fa fa-chevron-up"></i>
	                            </a>
	                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
	                                <i class="fa fa-wrench"></i>
	                            </a>
	                            <ul class="dropdown-menu dropdown-user">
	                                <li><a href="table_basic.html#">选项1</a>
	                                </li>
	                                <li><a href="table_basic.html#">选项2</a>
	                                </li>
	                            </ul>
	                            <a class="close-link">
	                                <i class="fa fa-times"></i>
	                            </a>
	                        </div>
	                    </div>
	               
	                    <div class="ibox-content">
							 <!-- 查询条件 -->
							<div class="row">
								<div id="contentTableQuery" class="col-sm-12">
								 	<div class="form-inline">
										<div class="form-group">
											<span>字典标签：</span>
												<input name="name" value=""  htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
												
										 </div>	
									</div>
									<br/>
								</div>
							</div>
							<!-- 工具栏 -->
							<div class="row">
								<div class="col-sm-12">
									<div class="pull-left">
										<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="add('新增','${adminPath}/admin/dict/edit?gid=${group.id}')" title="添加"><i class="fa fa-plus"></i> 添加</button>
										<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" onclick="update('修改','${adminPath}/admin/dict/edit','contentTable')" title="修改"><i class="fa fa-file-text-o"></i> 修改</button>
										<button class="btn btn-white btn-sm" onclick="deleteALLSelect('删除','${adminPath}/admin/dict/batchDelete','contentTable')" data-toggle="tooltip" data-placement="top"><i class="fa fa-trash-o"> 删除</i>
										<button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="refreshTable('contentTable')" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
									</div>
									<div class="pull-right">
										<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="doSearch('contentTable')" ><i class="fa fa-search"></i> 查询</button>
										<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="searchReset('contentTable')" ><i class="fa fa-refresh"></i> 重置</button>
									</div>
								</div>
							</div>
	                         <table class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable" id="contentTable"
							       data-pagination="true"
							       data-show-refresh="true"
							       data-show-toggle="true"
							       data-showColumns="true">
							       <thead>
							       </thead>
							       <tbody>
							       </tbody>
							</table>
	
	                    </div>
	                </div>
	            </div>
	        </div>
     </div>
</body>

    <!-- 全局js -->
    <script src="${adminPath}/static/common/js/jquery.min.js?v=2.1.4"></script>
    <script src="${adminPath}/static/common/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- Peity -->
    <script src="${adminPath}/static/common/peity/jquery.peity.min.js"></script>

    <!-- 自定义js -->
    <script src="${adminPath}/static/common/js/content.js?v=1.0.0"></script>


    <!-- iCheck -->
    <script src="${adminPath}/static/iCheck/icheck.min.js"></script>

    <!-- 系统公用JS -->
    <script src="${adminPath}/static/common/js/jeeweb.js"></script>
    
    <!-- Bootstrap table -->
    <script src="${adminPath}/static/bootstrap-table/bootstrap-table.js"></script>
    <script src="${adminPath}/static/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="${adminPath}/static/common/js/curdtools.js"></script>
    
    <!-- Sweet alert -->
    <script src="${adminPath}/static/sweetalert/sweetalert.min.js"></script>
    
    <script src="https://rawgit.com/isocra/TableDnD/master/js/jquery.tablednd.js"></script>
    <script src="${adminPath}/static/bootstrap-table/extensions/reorder-rows/bootstrap-table-reorder-rows.js"></script>
    

    
    
    <script type="text/javascript"> 
    function refreshTableTest()
    {
    	alert("哈哈哈哈哈哈哈哈哈");
    }
	    function initTable()
	    {
			//初始化用户列表
			$("#contentTable").bootstrapTable({
			    method: 'get',
			    url: "${adminPath}/admin/dict/ajaxList",
			    striped: true,  //表格显示条纹
			    pagination: true, //启动分页
			    reorderableRows: true,
		        useRowAttrFunc: true,
		        toggle:"table",
			    pageSize: 10,  //每页显示的记录数
			    pageNumber:1, //当前第几页
			    dataField: 'results',
			    pageList: [10, 20, 30],  //记录数可选列表
			    search: false,  //是否启用查询
			    showColumns: false,  //显示下拉框勾选要显示的列
			    showRefresh: false,  //显示刷新按钮
			    sortStable: false,
			    showToggle: false,
			    sidePagination: "server", //表示服务端请求
			    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
			    sortable: false,                     //是否启用排序
			    sortOrder: "asc",                   //排序方式
			    onLoadSuccess: function (data) {
			    	//iChecks();
		            return false;
		        },
			    queryParams: function (e) {
			        e.rows=e.limit;
		            e.page=((e.offset / e.limit) + 1);
			        return e;
			        
			    },
			    columns: [{
			        checkbox: true,
			        visible: true,
			        sortable: false,
			    },
			    {
			        field: 'label',
			        title: '字典标签',
			        width:'100',
			        align: 'center',
			        sortable: true,
			        clickToSelect: false
			    },
			    {
			        field: 'value',
			        title: '字典值',
			        width:'100',
			        align: 'center',
			        sortable: true,
			        clickToSelect: false
			    },
			    {
			        field: 'opt',
			        title: '操作',
			        align: 'center',
			        width:'300',
			        sortable: true,
			        clickToSelect: false,
			        formatter: optFormatter
			    }]
			});
	 	 }
	    $(document).ready(function () {
	    	 initTable();
	    });
	    function lockFormatter(value, row, index) {
	    	return value == 1 ? "未锁定" : "锁定";
	    }
	    function optFormatter(value, row, index)
	    {
	    	if (!row.id) {
                return '';
            }
	    	 var href="<a href=\"#\" onclick=\"openDialogView('查看区域', '/jeeplus/a/sys/area/form?id={{row.id}}','800px', '500px')\" class=\"btn btn-info btn-xs\" ><i class=\"fa fa-search-plus\"></i> 查看</a> &nbsp";
	    	 href += "<a href=\"#\" onclick=\"openDialog('修改区域', '/jeeplus/a/sys/area/form?id={{row.id}}','800px', '500px')\" class=\"btn btn-success btn-xs\" ><i class=\"fa fa-edit\"></i> 修改</a>&nbsp";
	    	 href += "<a href=\"#\" onclick=\"delObj('要删除该区域及所有子区域项吗？', '${adminPath}/admin/dict/delete','"+row.id+"')\" class=\"btn btn-danger btn-xs\" ><i class=\"fa fa-trash\"></i> 删除</a>&nbsp";
		   return href;
	    }
	    function iChecks()
	    {
	    	$(".i-checks").iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
	    }
    </script>
   
</html>