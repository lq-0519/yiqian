<%--
  已经处理的缺书登记
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已处理</title>
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

        #div2 {
            padding-top: 1%;
        }

        #div3 {
            padding-left: 1%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="div1" class="col-md-12">
    <div>
        <ul class="nav nav-tabs">
            <li role="presentation"><a href="${pageContext.request.contextPath}/regiBook/findByUntreated">未处理</a></li>
            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin">已处理</a></li>
        </ul>
    </div>
    <div id="div2">
        <div id="div3">
            共<strong>${pageInfo.total}</strong>条记录
        </div>
        <%--遍历表数据--%>
        <div id="div4">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>用户</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>备注</th>
                    <th>邮箱</th>
                    <th>日期</th>
                    <th>结果</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="regiBook">
                    <tr>
                        <td style="vertical-align:middle;"><a href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${regiBook.invitationCodeId}">${regiBook.invitationCode.username}</a></td>
                        <td style="vertical-align:middle;">${regiBook.bookName}</td>
                        <td style="vertical-align:middle;">${regiBook.author}</td>
                        <td style="vertical-align:middle;">${regiBook.remarks}</td>
                        <td style="vertical-align:middle;">${regiBook.email}</td>
                        <td style="vertical-align:middle;"><fmt:formatDate value="${regiBook.regiDate}"
                                                                           pattern="MMdd"/></td>
                        <td style="vertical-align:middle;">${regiBook.result}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--遍历表数据 /--%>

        <%--分页--%>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin?page=1">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin?page=${pageInfo.pageNum-1}">上一页</a>
                    </li>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageInfo.pageNum==pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin?page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=pageNum}">
                            <li><a
                                    href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin?page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin?page=${pageInfo.pageNum+1}">下一页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin?page=${pageInfo.pages}">尾页</a>
                    </li>
                </ul>
            </nav>
        </div>
        <%--分页 /--%>
    </div>
</div>
</body>
</html>
