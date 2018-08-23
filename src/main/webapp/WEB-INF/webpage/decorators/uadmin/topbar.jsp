<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="menus" value="${fns:getMenuList()}" />
<c:set var="currentMenu" value="${fns:getCurrentMenu()}" />
<c:set var="pmenuids" value="${currentMenu.parentIds}" />
<!--BEGIN TOPBAR-->
<div id="header-topbar-option-demo" class="page-header-topbar">
    <nav id="topbar" role="navigation" style="margin-bottom: 0; z-index: 2;" class="navbar navbar-default navbar-static-top">
       <div class="navbar-header">
           <button type="button" data-toggle="collapse" data-target=".sidebar-collapse" class="navbar-toggle">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
           </button>
           <a id="logo" href="${adminPath}" class="navbar-brand">
               <span class="fa fa-rocket"></span>
               <span class="logo-text">H5Web</span>
               <span style="display: none" class="logo-text-icon">HW</span>
           </a>
       </div>
       <div class="topbar-main">
           <a id="menu-toggle" href="#" class="hidden-xs">
               <i class="fa fa-bars"></i>
           </a>

           <ul class="nav navbar navbar-top-links navbar-right mbn">
               <li class="dropdown" style="display:none;"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-bell fa-fw"></i><span class="badge badge-green">3</span></a>
                   <ul class="dropdown-menu dropdown-alerts">
                       <li>
                           <p>You have 14 new notifications</p>
                       </li>
                       <li>
                           <div class="dropdown-slimscroll">
                               <ul>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-blue"><i class="fa fa-comment"></i></span>New Comment<span class="pull-right text-muted small">4 mins ago</span></a>
                                   </li>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-violet"><i class="fa fa-twitter"></i></span>3 New Followers<span class="pull-right text-muted small">12 mins ago</span></a>
                                   </li>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-pink"><i class="fa fa-envelope"></i></span>Message Sent<span class="pull-right text-muted small">15 mins ago</span></a>
                                   </li>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-green"><i class="fa fa-tasks"></i></span>New Task<span class="pull-right text-muted small">18 mins ago</span></a>
                                   </li>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-yellow"><i class="fa fa-upload"></i></span>Server Rebooted<span class="pull-right text-muted small">19 mins ago</span></a>
                                   </li>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-green"><i class="fa fa-tasks"></i></span>New Task<span class="pull-right text-muted small">2 days ago</span></a>
                                   </li>
                                   <li><a href="extra-user-list.html" target="_blank"><span class="label label-pink"><i class="fa fa-envelope"></i></span>Message Sent<span class="pull-right text-muted small">5 days ago</span></a>
                                   </li>
                               </ul>
                           </div>
                       </li>
                       <li class="last"><a href="extra-user-list.html" class="text-right">See all alerts</a>
                       </li>
                   </ul>
               </li>
               <li class="dropdown" style="display:none;"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-envelope fa-fw"></i><span class="badge badge-orange">7</span></a>
                   <ul class="dropdown-menu dropdown-messages">
                       <li>
                           <p>You have 14 new messages</p>
                       </li>
                       <li>
                           <div class="dropdown-slimscroll">
                               <ul>
                                   <!--<li><a href="email-view-mail.html" target="_blank"><span class="avatar"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/48.jpg" alt="" class="img-responsive img-circle"/></span><span class="info"><span class="name">Jessica Spencer</span><span class="desc">Lorem ipsum dolor sit amet...</span></span></a>
                                   </li>
                                   <li><a href="email-view-mail.html" target="_blank"><span class="avatar"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/48.jpg" alt="" class="img-responsive img-circle"/></span><span class="info"><span class="name">John Smith<span class="label label-blue pull-right">New</span></span><span class="desc">Lorem ipsum dolor sit amet...</span></span></a>
                                   </li>
                                   <li><a href="email-view-mail.html" target="_blank"><span class="avatar"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/48.jpg" alt="" class="img-responsive img-circle"/></span><span class="info"><span class="name">John Doe<span class="label label-orange pull-right">10 min</span></span><span class="desc">Lorem ipsum dolor sit amet...</span></span></a>
                                   </li>
                                   <li><a href="email-view-mail.html" target="_blank"><span class="avatar"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/48.jpg" alt="" class="img-responsive img-circle"/></span><span class="info"><span class="name">John Smith</span><span class="desc">Lorem ipsum dolor sit amet...</span></span></a>
                                   </li>
                                   <li><a href="email-view-mail.html" target="_blank"><span class="avatar"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/48.jpg" alt="" class="img-responsive img-circle"/></span><span class="info"><span class="name">John Smith</span><span class="desc">Lorem ipsum dolor sit amet...</span></span></a>
                                   </li>-->
                               </ul>
                           </div>
                       </li>
                       <li class="last"><a href="email-view-mail.html" target="_blank">Read all messages</a>
                       </li>
                   </ul>
               </li>
               <li class="dropdown"  style="display:none;"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-tasks fa-fw"></i><span class="badge badge-yellow">8</span></a>
                   <ul class="dropdown-menu dropdown-tasks">
                       <li>
                           <p>You have 14 pending tasks</p>
                       </li>
                       <li>
                           <div class="dropdown-slimscroll">
                               <ul>
                                   <li><a href="page-blog-item.html" target="_blank"><span class="task-item">Fix the HTML code<small class="pull-right text-muted">40%</small></span><div class="progress progress-sm"><div role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;" class="progress-bar progress-bar-orange"><span class="sr-only">40% Complete (success)</span></div></div></a>
                                   </li>
                                   <li>
                                       <a href="page-blog-item.html" target="_blank"> <span class="task-item">Make a wordpress theme<small class="pull-right text-muted">60%</small></span>
                                           <div class="progress progress-sm">
                                               <div role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;" class="progress-bar progress-bar-blue"><span class="sr-only">60% Complete (success)</span>
                                               </div>
                                           </div>
                                       </a>
                                   </li>
                                   <li>
                                       <a href="page-blog-item.html" target="_blank"> <span class="task-item">Convert PSD to HTML<small class="pull-right text-muted">55%</small></span>
                                           <div class="progress progress-sm">
                                               <div role="progressbar" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100" style="width: 55%;" class="progress-bar progress-bar-green"><span class="sr-only">55% Complete (success)</span>
                                               </div>
                                           </div>
                                       </a>
                                   </li>
                                   <li>
                                       <a href="page-blog-item.html" target="_blank"> <span class="task-item">Convert HTML to Wordpress<small class="pull-right text-muted">78%</small></span>
                                           <div class="progress progress-sm">
                                               <div role="progressbar" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100" style="width: 78%;" class="progress-bar progress-bar-yellow"><span class="sr-only">78% Complete (success)</span>
                                               </div>
                                           </div>
                                       </a>
                                   </li>
                               </ul>
                           </div>
                       </li>
                       <li class="last"><a href="page-blog-item.html" target="_blank">See all tasks</a>
                       </li>
                   </ul>
               </li>
               <li class="dropdown topbar-user">
                   <a data-hover="dropdown" href="#" class="dropdown-toggle"><img src="${appPath}/${fns:getUser().portrait}" alt="" class="img-responsive img-circle" />&nbsp;<span class="hidden-xs">${fns:getUser().realname}</span>&nbsp;<span class="caret"></span>
                   </a>
                   <ul class="dropdown-menu dropdown-user pull-right">
                       <li><a href="#"><i class="fa fa-user"></i>个人信息</a></li>
                       <li><a href="${adminPath}/sys/user/${fns:getUser().id}/avatar"><i class="fa fa-camera-retro"></i>修改头像</a></li>
                       <li><a href="#" data-hover="tooltip" title="修改密码" data-toggle="modal" data-target="#change-password"><i class="fa fa-key"></i>修改密码</a></li>  
                       <li class="divider"></li>
                       <li><a href="${adminPath}/logout"><i class="fa fa-key"></i>退出</a></li>
                   </ul>
               </li>
               <li class="dropdown hidden-xs">
                   <!--BEGIN THEME SETTING--><a id="theme-setting" href="javascript:;" data-hover="dropdown" data-step="1" data-intro="&lt;b&gt;Header&lt;/b&gt;, &lt;b&gt;sidebar&lt;/b&gt;, &lt;b&gt;border style&lt;/b&gt; and &lt;b&gt;color&lt;/b&gt;, all of them can change for you to create the best" data-position="left" class="dropdown-toggle"><i class="fa fa-cogs"></i></a>
                   <ul class="dropdown-menu dropdown-theme-setting pull-right">
                       <li>
                           <h4 class="mtn">主题</h4>
                           <select id="list_theme" class="form-control">
                               <option value="uadmin">FLAT主题</option>
                               <option value="ace">ACE主题</option>
                               <option value="inspinia">INSPINIA主题</option>
                           </select>
                       </li>
                       <li>
                           <h4 class="mtn">风格</h4>
                           <select id="list-menu" class="form-control">
                               <option value="sidebar-default">风格1</option>
                               <option value="sidebar-colors">风格2</option>
                               <option value="sidebar-icons">风格3</option>
                               <option value="sidebar-collapsed">风格4</option>
                           </select>
                       </li>
                       <li>
                           <h4 class="mtn">头部和侧边栏</h4>
                           <select id="list-header" class="form-control">
                               <option value="header-static">Static</option>
                               <option value="header-fixed">Fixed</option>
                           </select>
                       </li>
                       <li style="display:none;">
                           <h4 class="mtn">Theme Colors</h4>
                           <ul id="list-color" class="list-unstyled list-inline">
                               <li data-color="green-dark" data-hover="tooltip" title="Green - Dark" class="green-dark"></li>
                               <li data-color="red-dark" data-hover="tooltip" title="Red - Dark" class="red-dark"></li>
                               <li data-color="pink-dark" data-hover="tooltip" title="Pink - Dark" class="pink-dark"></li>
                               <li data-color="blue-dark" data-hover="tooltip" title="Blue - Dark" class="blue-dark"></li>
                               <li data-color="yellow-dark" data-hover="tooltip" title="Yellow - Dark" class="yellow-dark"></li>
                               <li data-color="green-grey" data-hover="tooltip" title="Green - Grey" class="green-grey"></li>
                               <li data-color="red-grey" data-hover="tooltip" title="Red - Grey" class="red-grey"></li>
                               <li data-color="pink-grey" data-hover="tooltip" title="Pink - Grey" class="pink-grey"></li>
                               <li data-color="blue-grey" data-hover="tooltip" title="Blue - Grey" class="blue-grey"></li>
                               <li data-color="yellow-grey" data-hover="tooltip" title="Yellow - Grey" class="yellow-grey"></li>
                               <li data-color="yellow-green" data-hover="tooltip" title="Yellow - Green" class="yellow-green"></li>
                               <li data-color="orange-grey" data-hover="tooltip" title="Orange - Grey" class="orange-grey"></li>
                               <li data-color="pink-blue" data-hover="tooltip" title="Pink - Blue" class="pink-blue"></li>
                               <li data-color="pink-violet" data-hover="tooltip" title="Pink - Violet" class="pink-violet active"></li>
                               <li data-color="orange-violet" data-hover="tooltip" title="Orange - Violet" class="orange-violet"></li>
                               <li data-color="pink-green" data-hover="tooltip" title="Pink - Green" class="pink-green"></li>
                               <li data-color="pink-brown" data-hover="tooltip" title="Pink - Brown" class="pink-brown"></li>
                               <li data-color="orange-blue" data-hover="tooltip" title="Orange - Blue" class="orange-blue"></li>
                               <li data-color="yellow-blue" data-hover="tooltip" title="Yellow - Blue" class="yellow-blue"></li>
                               <li data-color="green-blue" data-hover="tooltip" title="Green - Blue" class="green-blue"></li>
                           </ul>
                       </li>
                   </ul>
                   <!--END THEME SETTING-->
               </li>
           </ul>
       </div>
   </nav>
   <!--BEGIN MODAL CONFIG PORTLET-->
   <div id="change-password" class="modal fade">
       <div class="modal-dialog">
           <div class="modal-content">
               <div class="modal-header">
                   <button type="button" data-dismiss="modal" aria-hidden="true" class="close">&times;</button>
                   <h4 class="modal-title">修改密码</h4>
               </div>
               <div class="modal-body">
                  <form  id="changePasswordForm"  method="post" action="${adminPath}/sys/user/${fns:getUser().id}/changePassword" class="form"> 
	                <div class="form-group">
	                    <div class="input-icon right"><i class="fa fa-key"></i>
	                          <input type="password" value="" name="password"  class="form-control" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" />
		             		  <label class="Validform_checktip"></label>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <div class="input-icon right"><i class="fa fa-key"></i>
	                        <input type="password" value="" name="userpassword2" class="form-control" datatype="*" recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" />
		             		<label class="Validform_checktip"></label>
	                    </div>
	                </div>
		          </form>
               </div>
               <div class="modal-footer">
                   <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
                   <button type="button" class="btn btn-primary" onclick="changePassword()">修改密码</button>
               </div>
           </div>
       </div>
   </div>
   <!--END MODAL CONFIG PORTLET-->
</div>
<!--END TOPBAR-->