<%--
  添加邀请码
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
    <title>添加邀请码</title>
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
    <script>
        //检查用户名是否为空
        function checkUsername() {
            var username = $("#username").val();
            if (username.length == 0) {
                $("#div5").addClass("has-error")
                $("#span1").text("用户名不能为空!");
                return false;
            } else {
                $("#div5").removeClass("has-error")
                $("#span1").text("");
                return true;
            }
        }

        //检查userId是否为空
        function checkUserId() {
            var userId = $("#userId").val();
            if (userId.length == 0) {
                $("#div6").addClass("has-error")
                $("#span2").text("userId不能为空!");
                return false;
            } else {
                $("#div6").removeClass("has-error")
                $("#span2").text("");
                return true;
            }
        }


        $(function () {
            /**
             * 添加邀请码的表单检验
             */
            $("#form1").submit(function () {
                return checkUsername() && checkUserId();
            })
            /**
             * 绑定离焦事件
             */
            $("#username").blur(function () {
                checkUsername()
            })
            $("#userId").blur(function () {
                checkUserId()
            })
        })
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div id="div1" class="col-md-4">

        <form id="form1" action="${pageContext.request.contextPath}/invitationCode/addInvitationCode">
            <div id="div5" class="form-group">
                <label for="username">用户名</label>
                <input name="username" type="text" class="form-control" id="username">
                <span id="span1" class="help-block"></span>
            </div>
            <div id="div6" class="form-group">
                <label for="userId">userId</label>
                <input name="userId" type="text" class="form-control" id="userId">
                <span id="span2" class="help-block"></span>
            </div>
            <strong>账户类型</strong> <br>
            <%--账户类型--%>
            <label class="radio-inline">
                <input type="radio" name="accountType" id="inlineRadio1" value="0"> QQ
            </label>
            <label class="radio-inline">
                <input type="radio" name="accountType" id="inlineRadio2" value="1"> 微信
            </label>
            <label class="radio-inline">
                <input type="radio" name="accountType" id="inlineRadio3" value="2"> 淘宝
            </label>
            <label class="radio-inline">
                <input type="radio" name="accountType" id="inlineRadio4" value="3"> 其他
            </label>
            <%--账户类型 /--%>
            <br>
            <br>
            <button type="submit" class="btn btn-default">添加</button>
        </form>
    </div>
</div>
</body>
</html>
