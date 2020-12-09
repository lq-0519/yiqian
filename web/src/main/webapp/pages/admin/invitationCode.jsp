<%--
  邀请码
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>邀请码</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        #div1 {
            padding-left: 2%;
        }
    </style>

    <script type="text/javascript">
        /**
         * 删除的确认操作
         * @param id
         */
        function del(id) {
            if (confirm("确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/invitationCode/deleteById?id=" + id;
            }
        }

        /**
         * 复制内容到剪贴板
         * @param Url2
         */
        function copyContact(Url2) {
            var oInput = document.createElement('input');
            oInput.value = Url2;
            document.body.appendChild(oInput);
            oInput.select(); // 选择对象
            document.execCommand("Copy"); // 执行浏览器复制命令
            oInput.className = 'oInput';
            oInput.style.display = 'none';
            alert('复制成功');
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div id="div1" class="col-md-12">
        <%--搜索--%>
        <div id="div2">
            <form class="form-inline" action="${pageContext.request.contextPath}/invitationCode/findAll">
                <div class="form-group">
                    <label class="sr-only" for="exampleInputEmail3"></label>
                    <input type="text" name="condition" class="form-control" id="exampleInputEmail3"
                           placeholder="邀请码 用户名 userId">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
                <span style="padding-left: 3%">
            <a href="${pageContext.request.contextPath}/pages/admin/addInvitationCode.jsp"
               class="btn btn-success">添加邀请码</a>
            </span>
            </form>
        </div>
        <%--搜索 /--%>
        <span onclick="copyContact(this.innerHTML)">${invitationCodeMsg}</span><%--显示邀请码添加成功之后的信息--%>
        ${msgSearch}<%--显示你搜索的内容--%>
        &nbsp 共计<strong>${pageInfo.total}</strong>条<br>
        <%--遍历表数据--%>
        <div id="div3" class="col-md-9 table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>邀请码</th>
                    <th>用户名</th>
                    <th>账户类型</th>
                    <th>userId</th>
                    <th>添加时间</th>
                    <th>登记总数</th>
                    <th>今日剩余</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="invitationCode">
                    <tr>
                        <td>${invitationCode.invitationCode}</td>
                        <td>${invitationCode.username}</td>
                        <td>${invitationCode.accountType}</td>
                        <td>${invitationCode.userId}</td>
                        <td><fmt:formatDate value="${invitationCode.createDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${invitationCode.sum}</td>
                        <td>${invitationCode.last}</td>
                        <td>
                            <a onclick="del('${invitationCode.invitationCode}')"> 删除</a>
                            <a href="${pageContext.request.contextPath}/invitationCode/showInvitationCodeDetials?id=${invitationCode.invitationCode}">详情</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--遍历表数据 /--%>

        <%--分页--%>
        <div id="div4" class="col-md-11">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="${pageContext.request.contextPath}/invitationCode/findAll?condition=${condition}&page=1">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/invitationCode/findAll?condition=${condition}&page=${pageInfo.pageNum-1}">上一页</a>
                    </li>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageInfo.pageNum==pageNum}">
                            <li class="active"><a
                                    href="${pageContext.request.contextPath}/invitationCode/findAll?condition=${condition}&page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=pageNum}">
                            <li><a
                                    href="${pageContext.request.contextPath}/invitationCode/findAll?condition=${condition}&page=${pageNum}">${pageNum}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/invitationCode/findAll?condition=${condition}&page=${pageInfo.pageNum+1}">下一页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/invitationCode/findAll?condition=${condition}&page=${pageInfo.pages}">尾页</a>
                    </li>
                </ul>
            </nav>
        </div>
        <%--分页 /--%>
    </div>
</div>
</body>
</html>
