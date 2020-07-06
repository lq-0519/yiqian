<%--
  管理员
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>其他</title>
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">

    <div class="col-md-12">
        <div class="col-md-7">
            <form class="col-md-4" action="${pageContext.request.contextPath}/variable/updateFooterInfo">
                <div class="form-group">
                    <label for="qqGroup">售后QQ群</label>
                    <input type="text" value="${qqGroup}" class="form-control" name="qqGroup" id="qqGroup"
                           placeholder="售后QQ群">
                </div>
                <div class="form-group">
                    <label for="adminQQ">维护人QQ</label>
                    <input type="text" value="${adminQQ}" class="form-control" name="adminQQ" id="adminQQ"
                           placeholder="维护人QQ">
                </div>
                <input type="hidden" name="name" value="noticeIndex">
                <button type="submit" class="btn btn-default">更新</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
