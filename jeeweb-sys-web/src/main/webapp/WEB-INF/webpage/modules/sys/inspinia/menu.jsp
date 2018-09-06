<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${menus}" var="menu">
     <c:if test="${menu.parentId == null && menu.isshow eq '1'}">
	     <li>
	        <c:choose>
			   <c:when test="${menu.hasChildren}">  
				  <a href="#"><i class="fa ${menu.menuIcon}"></i> <span class="nav-label">${menu.name}</span><span class="fa arrow"></span></a>  
			   </c:when>
			   <c:otherwise> 
				  <a  class="J_menuItem"  href="${adminPath}/${menu.url}"><i class="fa ${menu.menuIcon}"></i> <span class="nav-label">${menu.name}</span><span class="fa arrow"></span></a>
			   </c:otherwise>
			</c:choose>
			<ul class="nav nav-second-level">
				 <c:forEach items="${menus}" var="secondMenu">
				     <c:if test="${secondMenu.parentId == menu.id && secondMenu.isshow eq '1'}">
					     <li>
					         <c:if test="${!secondMenu.hasChildren}"><a class="J_menuItem" href="${adminPath}/${secondMenu.url}">${secondMenu.name}</a></c:if>
						     <c:if test="${secondMenu.hasChildren}"><a href="#">${secondMenu.name}<span class="fa arrow"></span></a></c:if>
						     <!--  这里应该循环，但是出现了错误 -->
							 <ul class="nav nav-third-level">
							     <c:forEach items="${menus}" var="thirdMenu">
							       <c:if test="${thirdMenu.parentId == secondMenu.id && thirdMenu.isshow eq '1'}">
									  <li><a class="J_menuItem" href="${adminPath}/${thirdMenu.url}">${thirdMenu.name}</a></li>
								   </c:if>
								 </c:forEach>
							 </ul>
						 </li>
					 </c:if>
				 </c:forEach>
			</ul> 
		</li>
     </c:if>
</c:forEach>