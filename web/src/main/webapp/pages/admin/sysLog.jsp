<%--
  操作日志
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>操作日志</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        #div1 {
            padding-left: 3%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="div1" class="col-md-10">
    <%--搜索--%>
    <div id="div2">
        <form class="form-inline" action="${pageContext.request.contextPath}/sysLog/findAll">
            <div class="form-group">
                <label class="sr-only" for="exampleInputEmail3"></label>
                <input type="text" name="condition" class="form-control" id="exampleInputEmail3" placeholder="访问的方法">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
    </div>
    <%--搜索 /--%>

    共计<strong>${pageInfo.total}</strong>条<br>
    <%--遍历表数据--%>
    <div id="div3">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>ip</th>
                <th>访问时间</th>
                <th>访问时长</th>
                <th>访问的方法</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="sysLog">
                <tr>
                    <td>${sysLog.id}</td>
                    <td><a href="https://www.baidu.com/s?ie=UTF-8&wd=${sysLog.ip}">${sysLog.ip}</a></td>
                    <td><fmt:formatDate value="${sysLog.visitTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${sysLog.executionTime}</td>
                    <td>${sysLog.method}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--遍历表数据 /--%>

    <%--分页--%>
    <div id="div4">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/sysLog/findAll?condition=${condition}&page=1">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/sysLog/findAll?condition=${condition}&page=${pageInfo.pageNum-1}">上一页</a>
                </li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                    <c:if test="${pageInfo.pageNum==pageNum}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/sysLog/findAll?condition=${condition}&page=${pageNum}">${pageNum}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum!=pageNum}">
                        <li><a
                                href="${pageContext.request.contextPath}/sysLog/findAll?condition=${condition}&page=${pageNum}">${pageNum}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/sysLog/findAll?condition=${condition}&page=${pageInfo.pageNum+1}">下一页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/sysLog/findAll?condition=${condition}&page=${pageInfo.pages}">尾页</a>
                </li>
            </ul>
        </nav>
    </div>
    <%--分页 /--%>
</div>
</body>
</html>
