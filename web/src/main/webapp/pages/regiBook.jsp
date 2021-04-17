<%--
  缺书登记
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>缺书登记</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <style>
        #div3 {
            padding-top: 8%;
            margin-bottom: 3%;
        }
    </style>

    <script>

        /**
         * 检验书名是否为空
         * @returns {boolean}
         */
        function checkBookName() {
            var bookName = $("#bookName").val();
            if (bookName.length == 0) {
                $("#div5").addClass("has-error")
                $("#span1").text("书名不能为空!");
                return false;
            } else {
                $("#div5").removeClass("has-error")
                $("#span1").text("");
                return true;
            }
        }

        /**
         * 检验邀请码是否为空
         * @returns {boolean}
         */
        function checkInvitationCode() {
            var invitationCode = $("#invitationCode").val();
            if (invitationCode.length == 0) {
                $("#div6").addClass("has-error")
                $("#span2").text("邀请码不能为空!");
                return false;
            } else {
                $("#div6").removeClass("has-error")
                $("#span2").text("");
                return true;
            }
        }

        $(function () {
            /**
             * 缺书登记的表单检验
             */
            $("#form1").submit(function () {
                checkBookName();
                checkInvitationCode();
                return checkInvitationCode() && checkBookName();
            })
            /**
             * 绑定离焦事件
             */
            $("#bookName").blur(function () {
                checkBookName()
            })
            /**
             * 绑定离焦事件
             */
            $("#invitationCode").blur(function () {
                checkInvitationCode()
            })
        })

    </script>
</head>
<body>
<%--导入页头--%>
<jsp:include page="header.jsp"/>
<div id="div1" class="container">
    <div class="col-md-8 col-md-offset-2">

        <div id="div2" class="panel panel-default">
            <div class="panel-heading">
                <div class="text-center">
                    <h3 class="panel-title">缺书登记</h3><br>
                    为提高找书效率，请尽量正确填写如下信息!
                </div>
            </div>
            <div id="div3" class="panel-body col-md-offset-2">
                <form id="form1" class="form-horizontal" action="${pageContext.request.contextPath}/regiBook/save"
                      method="post">
                    <div class="form-group">
                        <label for="bookName" class="col-sm-2 control-label">书名</label>
                        <div id="div5" class="col-sm-7">
                            <input type="text" value="${bookName}" class="form-control" name="bookName" id="bookName"
                                   placeholder="">
                            <span id="span1" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="invitationCode" class="col-sm-2 control-label">邀请码</label>
                        <div id="div6" class="col-sm-7">
                            <input type="text" value="${invitationCode}" name="invitationCodeId" class="form-control"
                                   id="invitationCode" placeholder="没有请与群主联系">
                            <span id="span2" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="author" class="col-sm-2 control-label">作者</label>
                        <div class="col-sm-7">
                            <input type="text" value="${author}" name="author" class="form-control" id="author"
                                   placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remarks" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-7">
                            <input type="text" value="${remarks}" name="remarks" class="form-control" id="remarks"
                                   placeholder="例:章节不全 有错字">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--                    <div class="form-group">--%>
                    <%--                        <label for="email" class="col-sm-2 control-label">邮箱</label>--%>
                    <%--                        <div class="col-sm-7">--%>
                    <%--                            <input type="email" value="${email}" name="email" class="form-control" id="email"--%>
                    <%--                                   placeholder="填写之后 找书结果会以邮箱的形式通知">--%>
                    <%--                            <span class="help-block"></span>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <div id="div4" class="form-group">
                        <div class="col-sm-offset-4 col-sm-7">
                            <button type="submit" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<%--
    检查传递过来的错误信息error
--%>
<c:if test="${error==1}">
    <script>
        alert("邀请码不存在或已失效!")
    </script>
</c:if>

<c:if test="${error==0}">
    <script>
        alert("登记成功! 今天还能登记${last}本")
    </script>
</c:if>

<c:if test="${error==2}">
    <script>
        alert("登记失败! 今天的登记次数已用完, 每天01:00刷新次数! ")
    </script>
</c:if>

<c:if test="${error==3}">
    <script>
        alert("登记成功! 今天的登记次数已用完, 每天01:00刷新次数! ")
    </script>
</c:if>

<%--导入页脚--%>
<jsp:include page="footer.jsp"/>
</body>
</html>
