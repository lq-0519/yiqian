<%--
  显示查询书库的结果
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
        #div1 {
            padding-left: 2%;
            padding-right: 2%;
        }

        #div2 {
            padding-left: 3%;
        }

        #div3 {
            padding-left: 3%;
        }

        #div4 {
            padding-bottom: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="div4" class="container-fluid">
    <div id="div2">
        你搜索的是:&nbsp <strong>${bookName}</strong><br>
        共搜到<strong>${pageInfo.total}</strong>个结果<br>
        手机端向左滑动查看路径
    </div>

    <div id="div1" class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>书名</th>
                <th>路径</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.bookName}</td>
                    <td>${book.path}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--分页--%>
    <div id="div3">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li><a href="${pageContext.request.contextPath}/book/findByBookName?bookName=${bookName}&page=1&isSave=0">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/book/findByBookName?bookName=${bookName}&page=${pageInfo.pageNum-1}&isSave=0">上一页</a>
                </li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                    <c:if test="${pageInfo.pageNum==pageNum}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/book/findByBookName?bookName=${bookName}&page=${pageNum}&isSave=0">${pageNum}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum!=pageNum}">
                        <li><a
                                href="${pageContext.request.contextPath}/book/findByBookName?bookName=${bookName}&page=${pageNum}&isSave=0">${pageNum}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="${pageContext.request.contextPath}/book/findByBookName?bookName=${bookName}&page=${pageInfo.pageNum+1}&isSave=0">下一页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/book/findByBookName?bookName=${bookName}&page=${pageInfo.pages}&isSave=0">尾页</a>
                </li>
            </ul>
        </nav>
    </div>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
