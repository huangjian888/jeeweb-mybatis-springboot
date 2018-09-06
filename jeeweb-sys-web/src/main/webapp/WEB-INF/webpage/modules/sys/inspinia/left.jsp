<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- BEGIN SIDEBAR MENU -->
<ul class="nav" id="side-menu">
	<li class="nav-header">
		<div class="dropdown profile-element">
			<span class="default-avatar"><img alt="image" class="img-circle"
				src="${appPath}/${fns:getUser().portrait}" /></span> <a
				data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
				class="clear"> <span class="block m-t-xs"><strong
						class="font-bold">${fns:getUser().username}</strong></span> <span
					class="text-muted text-xs block">${fns:getUser().realname}<b class="caret"></b></span>
			</span>
			</a>
			<ul class="dropdown-menu animated fadeInRight m-t-xs">
				<li><a class="J_menuItem" href="${adminPath}/sys/user/${fns:getUser().id}/avatar">修改头像</a></li>
				<li style="display:none;"><a  href="#" onclick=" openDialog(title,url,gridId,width, height);update('修改密码','/jeeweb/admin/sys/user/changePassword','userGridId','800px','500px')">修改密码</a></li>
				<li class="divider"></li>
                <li><a onclick="changeStyle('ace')" href="#">ACE模式</a></li> 
                <li><a onclick="changeStyle('uadmin')" href="#">FLAT模式</a></li> 
				<li class="divider"></li>
				<li><a href="${adminPath}/logout">安全退出</a></li>
			</ul>
		</div>
		<div class="logo-element">JW</div>
	</li>
	<%@include file="./menu.jsp"%>
</ul>
<!-- END SIDEBAR MENU -->
<script>
function changeStyle(theme){
	   $.get('${adminPath}/theme/'+theme+'?url='+window.top.location.href,function(result){   window.location.reload();});
}
</script>