<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--BEGIN SIDEBAR MENU-->
<nav id="sidebar" role="navigation" class="navbar-default navbar-static-side">
    <div class="sidebar-collapse menu-scroll">
        <ul id="side-menu" class="nav">
            <li class="user-panel">
                <div class="thumb"><img src="${appPath}/${fns:getUser().portrait}" alt="" class="img-circle" />
                </div>
                <div class="info">
                    <p>${fns:getUser().realname}</p>
                    <ul class="list-inline list-unstyled">
                        <li><a href="#" data-hover="tooltip" title="个人信息"><i class="fa fa-user"></i></a>
                        </li>
                        <li><a href="${adminPath}/sys/user/${fns:getUser().id}/avatar" data-hover="tooltip" title="修改头像"><i class="fa fa-camera-retro"></i></a>
                        </li>
                        <li><a href="#" data-hover="tooltip" title="修改密码" data-toggle="modal" data-target="#change-password"><i class="fa fa-key"></i></a></li>
                        <li><a href="${adminPath}/logout" data-hover="tooltip" title="退出"><i class="fa fa-sign-out"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </li>
            <%@include file="./menu.jsp"%>
        </ul>
    </div>
</nav>
<!--END SIDEBAR MENU-->