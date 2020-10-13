<%--
  邀请码的详情页面
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
    <title>详情页面</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        #div1 {
            padding-left: 1%;
        }

        #div6 {
            padding-left: 1%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">

    <div id="div1">
        <%--邀请码的详细信息--%>
        <div class="col-md-4">

            <div id="div3">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/invitationCode/findAll">返回</a>
            </div>
            <br>
            <div id="div2">
                <form action="${pageContext.request.contextPath}/invitationCode/updateInvitationCodeDetials">
                    <input type="hidden" name="invitationCode" value="${invitationCode.invitationCode}">
                    <div class="form-group">
                        <label for="exampleInputEmail1">邀请码</label>
                        <input type="text" class="form-control" value="${invitationCode.invitationCode}"
                               id="exampleInputEmail1" disabled>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword12">用户名</label>
                        <input type="text" name="username" class="form-control" value="${invitationCode.username}"
                               id="exampleInputPassword12">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword17">userId</label>
                        <input type="text" name="userId" class="form-control" value="${invitationCode.userId}"
                               id="exampleInputPassword17">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword13">账户类型</label>
                        <input type="text" name="accountType" class="form-control" value="${invitationCode.accountType}"
                               id="exampleInputPassword13">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword14">添加时间</label>
                        <input type="text" class="form-control"
                               value=" <fmt:formatDate value="${invitationCode.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                               id="exampleInputPassword14" disabled>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword15">登记总数</label>
                        <input type="text" name="sum" class="form-control" value="${invitationCode.sum}"
                               id="exampleInputPassword15">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword16">今日剩余</label>
                        <input type="text" name="last" class="form-control" value="${invitationCode.last}"
                               id="exampleInputPassword16">
                    </div>
                    <button type="submit" class="btn btn-default">保存</button>
                </form>
            </div>
        </div>
        <%--邀请码的详细信息 /  --%>

        <%--登记过的书--%>
        <div id="div6" class="col-md-8">
            <h5>登记过的书</h5>
            共<strong>${pageInfo.total}</strong>条记录
            <%--遍历表数据--%>
            <div id="div4" class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>书名</th>
                        <th>登记时间</th>
                        <th>邮箱</th>
                        <th>结果</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="regiBook">
                        <tr>
                            <td>${regiBook.bookName}</td>
                            <td><fmt:formatDate value="${regiBook.regiDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${regiBook.email}</td>
                            <td>${regiBook.result}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%--遍历表数据/--%>

            <%--分页--%>
            <div id="div5">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}&page=1">首页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}&page=${pageInfo.pageNum-1}">上一页</a>
                        </li>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                            <c:if test="${pageInfo.pageNum==pageNum}">
                                <li class="active"><a
                                        href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}&page=${pageNum}">${pageNum}</a>
                                </li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum!=pageNum}">
                                <li><a
                                        href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}&page=${pageNum}">${pageNum}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li>
                            <a href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}&page=${pageInfo.pageNum+1}">下一页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}&page=${pageInfo.pages}">尾页</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <%--分页 /--%>
        </div>
        <%--登记过的书/--%>
    </div>
</div>
</body>
</html>
