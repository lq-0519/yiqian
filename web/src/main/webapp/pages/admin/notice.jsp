<%--
  修改通知
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
    <title>通知</title>
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

        #div2 {
            padding-bottom: 1%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div id="div1">
        <%--主页通知--%>
        <div id="div2" class="col-md-7">
            <form class="col-md-7" action="${pageContext.request.contextPath}/variable/updateNotice">
                <div class="form-group">
                    <label for="noticeIndex">主页</label>
                    <textarea id="noticeIndex" name="value" class="form-control"
                              rows="3">${applicationScope.noticeIndex}</textarea>
                </div>
                <input type="hidden" name="name" value="noticeIndex">
                <button type="submit" class="btn btn-default">更新</button>
            </form>
        </div>
        <%--主页通知 /--%>
        <%--找书结果通知--%>
        <div class="col-md-7">
            <form class="col-md-7" action="${pageContext.request.contextPath}/variable/updateNotice">
                <div class="form-group">
                    <label for="noticeRigiBookResult">缺书登记</label>
                    <textarea id="noticeRigiBookResult" name="value" class="form-control"
                              rows="3">${applicationScope.noticeRigiBookResult}</textarea>
                </div>
                <input type="hidden" name="name" value="noticeRigiBookResult">
                <button type="submit" class="btn btn-default">更新</button>
            </form>
        </div>
        <%--找书结果通知 /--%>
    </div>
</div>

</body>
</html>
