<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<li <c:if test="${currentMenu == null}">class="active"</c:if>><a href="${adminPath}"><i class="fa fa-tachometer fa-fw"><div class="icon-bg bg-orange"></div></i><span class="menu-title">控制台</span></a></li>--%>
<%--<c:forEach items="${menus}" var="menu">--%>
     <%--<c:if test="${menu.parentId == null && menu.isshow eq '1'}">--%>
		<%--<li <c:if test="${fn:contains(pmenuids,menu.id)==true||menu.id == currentMenu.id}">class="active"</c:if>>--%>
		    <%--<c:choose>--%>
			   <%--<c:when test="${menu.hasChildren}">--%>
			      <%--<a href="#"><i class="fa <c:if test="${empty menu.menuIcon}">fa-desktop</c:if> ${menu.menuIcon} fa-fw"><div class="icon-bg bg-dark"></div></i>--%>
			      <%--<span class="menu-title">${menu.name}</span><span class="fa arrow"></span></a>--%>
					 <%--<ul class="nav nav-second-level collapse<c:if test="${fn:contains(pmenuids,menu.id)==true||menu.id == currentMenu.id}"> in</c:if>">--%>
					 <%--<c:forEach items="${menus}" var="secondMenu">--%>
					     <%--<c:if test="${secondMenu.parentId == menu.id && secondMenu.isshow eq '1'}">--%>
						      <%--<li <c:if test="${fn:contains(pmenuids,secondMenu.id)==true||secondMenu.id == currentMenu.id}">class="active"</c:if>>--%>
						        <%--<c:choose>--%>
								   <%--<c:when test="${secondMenu.hasChildren}">--%>
									    <%--<a href="#"><i class="fa <c:if test="${empty secondMenu.menuIcon}">fa-angle-right</c:if>${secondMenu.menuIcon}"></i>--%>
									    <%--<span class="submenu-title">${secondMenu.name}</span><span class="fa arrow"></span></a>--%>
									    <%--<ul class="nav nav-third-level collapse <c:if test="${fn:contains(pmenuids,secondMenu.id)==true||secondMenu.id == currentMenu.id}">in</c:if>">--%>
									    <%--<c:forEach items="${menus}" var="thirdMenu">--%>
										       <%--<c:if test="${thirdMenu.parentId == secondMenu.id && thirdMenu.isshow eq '1'}">--%>
												   <%--<li <c:if test="${fn:contains(pmenuids,thirdMenu.id)==true||thirdMenu.id == currentMenu.id}">class="active"</c:if>>--%>
												      <%--<a href="${adminPath}/${thirdMenu.url}"><i class="fa <c:if test="${empty thirdMenu.menuIcon}">fa-angle-double-right</c:if>${thirdMenu.menuIcon}"></i>--%>
												      <%--<span class="submenu-title">${thirdMenu.name}</span></a>--%>
												    <%--</li>--%>
											   <%--</c:if>--%>
											<%--</c:forEach>--%>
							            <%--</ul>--%>
								   <%--</c:when>--%>
								   <%--<c:otherwise>--%>
									   <%--<a href="${adminPath}/${secondMenu.url}"><i class="fa <c:if test="${empty secondMenu.menuIcon}">fa-angle-right</c:if>${secondMenu.menuIcon}"></i>--%>
									   <%--<span class="submenu-title">${secondMenu.name}</span></a>--%>
								   <%--</c:otherwise>--%>
								<%--</c:choose>--%>
							 <%--</li>--%>
			  		  <%--</c:if>--%>
					<%--</c:forEach>--%>
				    <%--</ul>--%>
			   <%--</c:when>--%>
			   <%--<c:otherwise>--%>
			      <%--<a href="${adminPath}/${menu.url}"><i class="fa ${menu.menuIcon}"><div class="icon-bg bg-orange"></div></i><span class="menu-title">${menu.name}</span></a>--%>
			   <%--</c:otherwise>--%>
			<%--</c:choose>--%>
		<%--</li>--%>
    <%--</c:if>--%>
<%--</c:forEach>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<li <c:if test="${currentMenu == null}">class="active"</c:if>>
	<%-- 	<a href="${adminPath}">
    <!-- 		<i class="fa fa-tachometer fa-fw">
                <div class="icon-bg bg-orange"></div>
            </i> -->
    <!-- 		<span class="menu-title">控制台</span> -->
        </a> --%>
</li>
<c:forEach items="${menus}" var="menu">
	<c:if test="${menu.parentId == null && menu.isshow eq '1'}">
		<li <c:if test="${fn:contains(pmenuids,menu.id)==true||menu.id == currentMenu.id}">class="active"</c:if>>
			<c:choose>
				<c:when test="${menu.hasChildren}">
					<a href="#">
						<i class="fa <c:if test="${empty menu.menuIcon}">fa-desktop</c:if> ${menu.menuIcon} fa-fw">
							<div class="icon-bg bg-dark"></div>
						</i>
						<span class="menu-title">${menu.name}</span><span class="fa arrow"></span>
					</a>
					<ul class="nav nav-second-level collapse<c:if test="${fn:contains(pmenuids,menu.id)==true||menu.id == currentMenu.id}"> in</c:if>">
						<!-- 二级菜单开始 -->
						<c:forEach items="${menus}" var="secondMenu">
							<c:if test="${secondMenu.parentId == menu.id && secondMenu.isshow eq '1'}">
								<li <c:if test="${fn:contains(pmenuids,secondMenu.id)==true||secondMenu.id == currentMenu.id}">class="active"</c:if>>
									<c:choose>
										<c:when test="${secondMenu.hasChildren}">
											<a href="#"><i class="fa <c:if test="${empty secondMenu.menuIcon}">fa-angle-right</c:if>${secondMenu.menuIcon}"></i>
												<span class="submenu-title">${secondMenu.name}</span><span class="fa arrow"></span></a>
											<ul class="nav nav-third-level collapse <c:if test="${fn:contains(pmenuids,secondMenu.id)==true||secondMenu.id == currentMenu.id}">in</c:if>">
												<!-- 三级菜单开始 -->
												<c:forEach items="${menus}" var="thirdMenu">
													<c:if test="${thirdMenu.parentId == secondMenu.id && thirdMenu.isshow eq '1'}">
														<li <c:if test="${fn:contains(pmenuids,thirdMenu.id)==true||thirdMenu.id == currentMenu.id}">class="active"</c:if>>
															<c:choose>
																<c:when test="${thirdMenu.hasChildren}">
																	<a href="#">&nbsp;&nbsp;<i class="fa <c:if test="${empty thirdMenu.menuIcon}">fa-angle-right</c:if>${thirdMenu.menuIcon}"></i>
																		<span class="submenu-title">${thirdMenu.name}</span><span class="fa arrow"></span></a>
																	<ul class="nav nav-forth-level collapse <c:if test="${fn:contains(pmenuids,thirdMenu.id)==true||thirdMenu.id == currentMenu.id}">in</c:if>">
																		<!-- 四级菜单开始 -->
																		<c:forEach items="${menus}" var="forthMenu">
																			<c:if test="${forthMenu.parentId == thirdMenu.id && forthMenu.isshow eq '1'}">
																				<li <c:if test="${fn:contains(pmenuids,forthMenu.id)==true||forthMenu.id == currentMenu.id}">class="active"</c:if>>
																					<c:choose>
																						<c:when test="${forthMenu.hasChildren}">
																							<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa <c:if test="${empty forthMenu.menuIcon}">fa-angle-right</c:if>${forthMenu.menuIcon}"></i>
																								<span class="submenu-title">${forthMenu.name}</span><span class="fa arrow"></span></a>
																							<ul class="nav nav-fifth-level collapse <c:if test="${fn:contains(pmenuids,forthMenu.id)==true||forthMenu.id == currentMenu.id}">in</c:if>">
																								<!-- 五级菜单开始 -->
																								<c:forEach items="${menus}" var="fifthMenu">
																									<c:if test="${fifthMenu.parentId == forthMenu.id && fifthMenu.isshow eq '1'}">
																										<li <c:if test="${fn:contains(pmenuids,fifthMenu.id)==true||fifthMenu.id == currentMenu.id}">class="active"</c:if>>
																											<a href="${adminPath}/${fifthMenu.url}">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa <c:if test="${empty fifthMenu.menuIcon}">fa-angle-double-right</c:if>${fifthMenu.menuIcon}"></i>
																												<span class="submenu-title">${fifthMenu.name}</span></a>
																										</li>
																									</c:if>
																								</c:forEach>
																								<!-- 五级菜单结束 -->
																							</ul>
																						</c:when>
																						<c:otherwise>
																							<a href="${adminPath}/${forthMenu.url}">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa <c:if test="${empty forthMenu.menuIcon}">fa-angle-right</c:if>${forthMenu.menuIcon}"></i>
																								<span class="submenu-title">${forthMenu.name}</span></a>
																						</c:otherwise>
																					</c:choose>
																				</li>
																			</c:if>
																		</c:forEach>
																		<!-- 四级菜单结束 -->
																	</ul>
																</c:when>
																<c:otherwise>
																	<a href="${adminPath}/${thirdMenu.url}">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa <c:if test="${empty thirdMenu.menuIcon}">fa-angle-right</c:if>${thirdMenu.menuIcon}"></i>
																		<span class="submenu-title">${thirdMenu.name}</span></a>
																</c:otherwise>
															</c:choose> <%--  <a href="${adminPath}/${thirdMenu.url}">&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa <c:if test="${empty thirdMenu.menuIcon}">fa-angle-double-right</c:if>${thirdMenu.menuIcon}"></i>
												      <span class="submenu-title">${thirdMenu.name}</span></a> --%>
														</li>
													</c:if>
												</c:forEach>
												<!-- 三级菜单结束 -->
											</ul>
										</c:when>
										<c:otherwise>
											<a href="${adminPath}/${secondMenu.url}" <c:if test="${fn:contains(secondMenu.url,'jReport')}"> target='_blank'</c:if>  ><i
													class="fa <c:if test="${empty secondMenu.menuIcon}">fa-angle-right</c:if>${secondMenu.menuIcon}"></i>
												<span class="submenu-title">${secondMenu.name}</span></a>
										</c:otherwise>
									</c:choose>
								</li>
							</c:if>
						</c:forEach>
						<!-- 二级菜单结束 -->
					</ul>
				</c:when>
				<c:otherwise>
					<a href="${adminPath}/${menu.url}">
						<i class="fa ${menu.menuIcon}"><div class="icon-bg bg-orange"></div></i>
						<span class="menu-title">${menu.name}</span>
					</a><!-- 一级菜单结束 -->
				</c:otherwise>
			</c:choose>
		</li>
	</c:if>
</c:forEach>