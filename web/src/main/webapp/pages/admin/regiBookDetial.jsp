<%--
  登记的书的详情页面
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情页面</title>
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
<div id="div1" class="col-md-4">
    <form action="${pageContext.request.contextPath}/regiBook/updateById_bookName_author">
        <input type="hidden" name="id" value="${regiBook.id}">
        <div class="form-group">
            <label for="exampleInputEmail1">用户名</label>
            <input type="text" class="form-control" value="${regiBook.invitationCode.username}" id="exampleInputEmail1" disabled>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword12">书名</label>
            <input type="text" name="bookName" class="form-control" value="${regiBook.bookName}" id="exampleInputPassword12">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword13">作者</label>
            <input type="text" name="author" class="form-control" value="${regiBook.author}" id="exampleInputPassword13">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword14">备注</label>
            <textarea id="exampleInputPassword14" disabled class="form-control"
                      rows="2">${regiBook.remarks}</textarea>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword15">登记时间</label>
            <input type="text" class="form-control" value="<fmt:formatDate value="${regiBook.regiDate}" pattern="yyyy-MM-dd HH:MM:ss"/>" id="exampleInputPassword15" disabled>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword16">登记使用的邀请码</label>
            <input type="text" class="form-control" value="${regiBook.invitationCodeId}" id="exampleInputPassword16" disabled>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword18">登记使用的邮箱</label>
            <input type="email" class="form-control" value="${regiBook.email}" id="exampleInputPassword18" disabled>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword17">当前邀请码登记总数</label>
            <input type="text" class="form-control" value="${regiBook.invitationCode.sum}" id="exampleInputPassword17" disabled>
        </div>
        <button type="submit" class="btn btn-default">保存</button>
    </form>
</div>
</body>
</html>
