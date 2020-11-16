<%--
  找书结果
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>找书结果</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <style>
        #p1 {
            font-size: 19px;
        }

        #div1 {
            /*padding-left: 5%;*/
            padding-bottom: 30px;
        }

        h2 {
            padding-top: 12px;
        }

    </style>
</head>
<body style="background-image:url('../img/watermark.png'); background-size: 40%">
<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div id="div1" class="col-md-10">
        <div>
            <p class="lead col-lg-9" id="p1">${applicationScope.noticeRigiBookResult}</p>
        </div>
        <div id="div2" class="table-responsive col-md-8">
            <%--根据日期展示数据--%>
            <fmt:formatDate var="oldDay" value="${pageInfo.list[0].regiDate}" pattern="MM月dd日"/>
            <h2>${oldDay}</h2>
            <table class="table table-hover">
                <c:forEach items="${pageInfo.list}" var="regiBook">
                <fmt:formatDate var="newDay" value="${regiBook.regiDate}" pattern="MM月dd日"/>
                <c:if test="${oldDay==newDay}">
                    <tr>
                        <td> ${regiBook.bookName}</td>
                        <td>${regiBook.result}</td>
                    </tr>
                </c:if>
                <c:if test="${oldDay!=newDay}">
            </table>
            <h2>${newDay}</h2>
            <c:set var="oldDay" value="${newDay}"/>
            <table class="table table-hover">
                <tr>
                    <td> ${regiBook.bookName} </td>
                    <td>${regiBook.result}</td>
                </tr>
                </c:if>
                </c:forEach>
            </table>
            <%--根据日期展示数据 /--%>
        </div>
        <%--分页--%>
        <div id="div3" class="col-md-9">
            <%--分页--%>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/regiBook/findByIsFund?page=1">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/regiBook/findByIsFund?page=${pageInfo.pageNum-1}">上一页</a>
                    </li>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageInfo.pageNum==pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/regiBook/findByIsFund?page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=pageNum}">
                            <li><a
                                    href="${pageContext.request.contextPath}/regiBook/findByIsFund?page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/regiBook/findByIsFund?page=${pageInfo.pageNum+1}">下一页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/regiBook/findByIsFund?page=${pageInfo.pages}">尾页</a>
                    </li>
                </ul>
            </nav>
            <%--分页 /--%>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
