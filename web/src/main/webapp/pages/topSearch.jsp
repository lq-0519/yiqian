<%--
  书库热搜
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>查询结果</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <style>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="col-md-6">
        <div>
            共<strong>${pageInfo.total}</strong>条记录
        </div>
        <div class="col-md-10">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>书名</th>
                    <th>搜索次数</th>
                </tr>
                </thead>
                <tbody>
                <%--遍历表数据--%>
                <c:forEach items="${pageInfo.list}" var="topSearch">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/findByBookName?bookName=${topSearch.bookName}&isSave=0">${topSearch.bookName}</a>
                        </td>
                        <td>${topSearch.numberOfSearches}</td>
                    </tr>
                </c:forEach>
                <%--遍历表数据 /--%>
                </tbody>
            </table>
        </div>
        <%--分页--%>
        <div >
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="${pageContext.request.contextPath}/searchHistory/showTopSearch?page=1">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/searchHistory/showTopSearch?page=${pageInfo.pageNum-1}">上一页</a>
                    </li>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageInfo.pageNum==pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/searchHistory/showTopSearch?page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=pageNum}">
                            <li><a
                                    href="${pageContext.request.contextPath}/searchHistory/showTopSearch?page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/searchHistory/showTopSearch?page=${pageInfo.pageNum+1}">下一页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/searchHistory/showTopSearch?page=${pageInfo.pages}">尾页</a>
                    </li>
                </ul>
            </nav>
        </div>
        <%--分页 /--%>
    </div>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
