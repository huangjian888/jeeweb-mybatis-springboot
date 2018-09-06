<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title><spring:message code="sys.dict.title" /></title>
  <meta name="decorator" content="list"/>
</head>
<body title="<spring:message code="sys.dict.title" />">
<grid:grid id="groupGridId" url="${adminPath}/sys/dict/ajaxList?gid=${group.id}" editable="true">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/sys/dict/delete" />
    <grid:column label="分组名称" name="dictGroup.name" editable="true" edittype="button"   />
    <grid:column label="sys.dict.label"  name="label" editable="true"  edittype="date"  editoptions="editoptions"  />
    <grid:column label="sys.dict.value"  name="value" editable="true" edittype="textarea"  />
    
	<grid:toolbar title="sys.common.add" icon="fa-plus" function="add" url="${adminPath}/sys/dict/edit?gid=${group.id}"  />
	<grid:toolbar title="sys.common.update" icon="fa-file-text-o" function="update" url="${adminPath}/sys/dict/edit"  />
	<grid:toolbar title="sys.common.delete" icon="fa-trash-o" function="deleteALLSelect" url="${adminPath}/sys/dict/batchDelete"  />
	
	<grid:toolbar  layout="right" title="sys.common.search" icon="fa-search"  function="doSearch"  />
	<grid:toolbar  layout="right" title="sys.common.reset" icon="fa-refresh"  function="searchReset"  />
</grid:grid>
<!-- 自动搜索 -->
<html:js name="typeahead" />
<script>
 function editoptions(){
    return {
        // dataInit is the client-side event that fires upon initializing the toolbar search field for a column
        // use it to place a third party control to customize the toolbar
        dataInit: function (element) {
		   $(element).attr("autocomplete","off").typeahead({ 
			   appendTo : "body",
				source: function(query, proxy) {
					$.ajax({
						url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/autocompletepbs.php?callback=?&acelem=ShipName',
						dataType: "jsonp",
						data: {term: query},
						success : proxy
					});
				}
		   });
        }
    };
 }
 </script>
</body>
</html>