<%--
  搜索记录
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>搜索记录</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        #div1 {
            padding-left: 2%;
            padding-top: 1%;
        }

        #div4 {
            padding-left: 2%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="div4">
    <div id="div1">
        今天<strong>${todayTotal}条</strong><br>
        昨天<strong>${yesterdayTotal}</strong>条<br>
        累计<strong>${pageInfo.total}</strong>条
    </div>
    <%--具体的搜索记录--%>
    <div id="div2" class="table-responsive col-md-8">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ip</th>
                <th>时间</th>
                <th>书名</th>
                <th>结果</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="searchHistory">
                <tr>
                    <td><a href="https://www.baidu.com/s?ie=UTF-8&wd=${searchHistory.ip}">${searchHistory.ip}</a></td>
                    <td><fmt:formatDate value="${searchHistory.searchTime}" pattern="MM/dd - HH:mm:ss"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/findByBookName?bookName=${searchHistory.bookName}&isSave=0">${searchHistory.bookName}</a>
                    </td>
                    <td>${searchHistory.result}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--具体的搜索记录 /--%>
    <%--分页--%>
    <div id="div3" class="col-md-9">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li><a href="${pageContext.request.contextPath}/searchHistory/showSearchHistory?page=1">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/searchHistory/showSearchHistory?page=${pageInfo.pageNum-1}">上一页</a>
                </li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                    <c:if test="${pageInfo.pageNum==pageNum}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/searchHistory/showSearchHistory?page=${pageNum}">${pageNum}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum!=pageNum}">
                        <li><a
                                href="${pageContext.request.contextPath}/searchHistory/showSearchHistory?page=${pageNum}">${pageNum}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/searchHistory/showSearchHistory?page=${pageInfo.pageNum+1}">下一页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/searchHistory/showSearchHistory?page=${pageInfo.pages}">尾页</a>
                </li>
            </ul>
        </nav>
    </div>
    <%--分页 /--%>
</div>
</body>
</html>
