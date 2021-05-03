<%--suppress ELValidationInJSP --%>
<%--
  首页
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>首页</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <style>

        #p1 {
            /*padding-left: 7%;*/
            font-size: 18px;
        }

        img{
            padding-bottom: 3%;
        }
    </style>
</head>
<body>
<jsp:include page="pages/header.jsp"/>
<%--<%@include file="pages/header.jsp"%>--%>
<div class="container-fluid">
    <p id="p1" class="lead col-md-offset-1">${applicationScope.noticeIndex}</p>
    <div>
        <img class="img-responsive col-md-7 " src="img/img1.jpeg" alt="">
        <img class="img-responsive col-md-7 " src="img/img2.JPEG">
        <img class="img-responsive col-md-7 " src="img/img3.JPEG">
        <img class="img-responsive col-md-7 " src="img/img4.jpeg">
        <div class="col-md-7">
            <img class="img-responsive col-md-6 col-md-offset-2" src="img/img5.JPG">
        </div>
        <img class="img-responsive col-md-7 " src="img/img6.jpeg">
        <img class="img-responsive col-md-7 " src="img/img7.JPEG">
        <img class="img-responsive col-md-7 " src="img/img8.jpeg">

    </div>
</div>
<jsp:include page="pages/footer.jsp"/>
</body>
</html>
