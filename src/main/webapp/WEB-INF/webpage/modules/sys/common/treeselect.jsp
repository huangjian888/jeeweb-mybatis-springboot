<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="sys.common.treeselect.title" /></title>
    <meta name="decorator" content="form"/> 
    <html:css name="jquery-ztree"/>
    <html:js  name="jquery-ztree"/>
    <style>
	    .ibox-content {
	   	  padding: 0px 0px 0px;
	   	}
	</style>
</head>

<body class="white-bg">
	<ul id="treeObj" class="ztree"></ul>
	<script type="text/javascript">
        var treeObj;
		var setting = {
			check: {
				enable: ${multiselect},
				chkboxType:  { "Y": "${chkboxType}", "N": "${chkboxType}" }
			},
			data: {
				key: {
					url: "notarget",
					icon: "notarget"
				},
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "parentId",
					rootPId: 0
				}
			},
		    callback: {
		        onClick: function(event, treeId, treeNode) {
		        	treeObj.expandNode(treeNode);
		        },
		        onCheck: function(e, treeId, treeNode) {
		            var nodes = treeObj.getCheckedNodes(true);
		            for (var i = 0; i < nodes.length; i++) {
		            	treeObj.expandNode(nodes[i], true, false, false);
		            }
		            return false;
		        },
		        onAsyncSuccess: function(event, treeId, treeNode, msg) {
		            var nodes = treeObj.getNodesByParam("parentId", treeNode.id, null);
		            for (var i = 0,
		            l = nodes.length; i < l; i++) {
		                try {
		                    treeObj.checkNode(nodes[i], treeNode.checked, true);
		                } catch(e) {}
		            }
		            selectCheckNode();
		        },
		        onDblClick: function() {
		        	 
		        }
		    }
		};
		
		$(document).ready(function(){
			$.ajax({  
			       type : "post",  
			       url : "${url}",  
			       dataType : "json",  
			       //data:{key:'1'},
			       success : function(data) {
			    	   var nodes=data.results;
			    	   initTree(setting,nodes);
			       }
			});
		});
		
		function initTree(setting,nodes){
			treeObj=$.fn.zTree.init($("#treeObj"), setting, nodes);
			// 默认展开一级节点
	        var nodes = treeObj.getNodesByParam("level", 0);
	        for (var i = 0; i < nodes.length; i++) {
	        	treeObj.expandNode(nodes[i], true, false, false);
	        }
			initSelectNode();
		}
		
		function initSelectNode(){
			var selectNodeIds="${selectNodes}".split(",");
			for(var i=0; i<selectNodeIds.length; i++) {
				var nodeid=selectNodeIds[i];
				var node = treeObj.getNodeByParam("id", nodeid);
				if (${multiselect}) {
		            try {
		            	treeObj.checkNode(node, true, false);
		            } catch(e) {}
		            treeObj.selectNode(node, false);
		        } else {
		        	treeObj.selectNode(node, true);
		        }
			}
		}
		
		
	</SCRIPT>
</body>
</html>