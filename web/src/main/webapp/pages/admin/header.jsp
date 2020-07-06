<%--
  页头
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-12">
    <ul class="nav nav-pills btn-lg">
        <li role="presentation"><a href="${pageContext.request.contextPath}/regiBook/findByUntreated">登记情况</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/searchHistory/showSearchHistory">搜索记录</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/pages/admin/notice.jsp">更新公告</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/invitationCode/findAll">邀请码</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/sysLog/findAll">操作日志</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath}/pages/admin/other.jsp">其他</a></li>
        <ul  class="navbar-right nav nav-pills ">
            <li role="presentation"><a href="${pageContext.request.contextPath}/">返回主页</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/user/loggedOut">退出登录</a></li>
        </ul>
    </ul>

</div>

