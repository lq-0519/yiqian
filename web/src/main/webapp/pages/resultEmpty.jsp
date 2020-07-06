<%--
  查询书库 啥也没查到
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
    <title>啥也没查到</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <style>
        #div1 {
            padding-left: 4%;
            padding-top: 0.4%;
            width: 450px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div id="div1" class="">
        你搜索的是：<strong>${bookName}</strong> &nbsp 搜索的书名不存在！<br>
        建议：<br>
        &nbsp 1、检查书名是否有误<br>
        &nbsp 2、缩小关键字的长度再试一下
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
