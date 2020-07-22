<%--
    管理员登录
--%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>请登录</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/user/login" method="post">
        <h2 class="form-signin-heading">请登录</h2>

        <label for="username" class="sr-only">username</label>
        <input type="text" name="username" id="username" class="form-control" placeholder="username" required autofocus>

        <label for="password" class="sr-only">password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="password" required>

        <font color="red">${loginErrorMsg}</font>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe" value="remember-me"> 记住我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>

        <font color="gray">有特殊需求可向群主索要密码</font>
    </form>

</div> <!-- /container -->
</body>
</html>

