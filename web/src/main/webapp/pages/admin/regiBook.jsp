<%--
  登记情况
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登记情况</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        .form1 {
            margin: 0px;
        }

        .td1 {
            width: 38%;
        }

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
            <li role="presentation" class="active"><a
                    href="${pageContext.request.contextPath}/regiBook/findByUntreated">未处理</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/regiBook/findByIsFundAdmin">已处理</a></li>
        </ul>
    </div>

    <div id="div2">
        <div id="div3">
            共<strong>${pageInfo.total}</strong>条记录
        </div>
        <div id="div4">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>用户</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>备注</th>
                    <th>日期</th>
                    <th>操作</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody>
                <%--遍历表数据--%>
                <c:forEach items="${pageInfo.list}" var="regiBook">
                    <tr>
                        <td style="vertical-align:middle;"><a
                                href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${regiBook.invitationCodeId}">${regiBook.invitationCode.username}</a>
                        </td>
                        <td style="vertical-align:middle;">${regiBook.bookName}</td>
                        <td style="vertical-align:middle;">${regiBook.author}</td>
                        <td style="vertical-align:middle;">${regiBook.remarks}</td>
                        <td style="vertical-align:middle;"><fmt:formatDate value="${regiBook.regiDate}"
                                                                           pattern="MMdd"/></td>
                        <td class="td1">
                                <%--更新找书结果--%>
                            <form action="${pageContext.request.contextPath}/regiBook/updateResult"
                                  class="form-inline form1">
                                <input type="hidden" name="id" value="${regiBook.id}">
                                <input type="hidden" name="regiDate" value="<fmt:formatDate value="${regiBook.regiDate}"
                                                                           pattern="MMdd"/>">
                                <input type="hidden" name="yearAndMonth" value="<fmt:formatDate value="${regiBook.regiDate}"
                                                                           pattern="yyyyMM"/>">
                                <label class="radio-inline">
                                    <input type="radio" name="regiBookResult" id="inlineRadio1" value="0"> 已找到
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="regiBookResult" id="inlineRadio2" value="1"> 未找到
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="regiBookResult" id="inlineRadio3" value="2">
                                    书库中有
                                </label>
                                <div class="form-group">
                                    <label class="sr-only" for="exampleInputEmail3"></label>
                                    <input type="text" name="remarks" class="form-control" id="exampleInputEmail3"
                                           placeholder="备注">
                                </div>
                                <button type="submit" class="btn btn-default">更新</button>
                            </form>
                                <%--更新找书结果 /--%>
                        </td>
                        <td style="vertical-align:middle;"><a
                                href="${pageContext.request.contextPath}/regiBook/findById?id=${regiBook.id}">详情</a>
                        </td>
                    </tr>
                </c:forEach>
                <%--遍历表数据 /--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
