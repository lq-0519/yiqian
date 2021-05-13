<%--
页头
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    /**
     * 检查查询的书名是不是空, 空就返回false
     * @returns {boolean}
     */
    function checkSearchCondition() {
        var searchCondition = $("#searchCondition").val();
        if (searchCondition.length == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 查询书库的表单检验
     */
    $(function () {
        $("#form2").submit(function () {
            return checkSearchCondition();
        })
    })

</script>
<div class="">
    <nav class="navbar navbar-default container-fluid">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">壹仟书库</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/pages/regiBook.jsp">缺书登记</a></li>
                    <li><a href="${pageContext.request.contextPath}/regiBook/findByIsFund">找书结果</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">常用教程 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a target="_blank"
                                   href="https://jingyan.baidu.com/article/59a015e342a165f795886545.html">kindle导入电子书</a>
                            </li>
                            <li><a target="_blank"
                                   href="https://jingyan.baidu.com/article/656db918c1f032e381249c16.html">kindle邮箱传书</a>
                            </li>
                            <li><a target="_blank" href="https://convertio.co/zh/ebook-converter/">在线电子书格式转换</a></li>
                        </ul>
                    </li>
                </ul>
                <form id="form2" class="navbar-form navbar-left"
                      action="${pageContext.request.contextPath}/book/findByBookName" method="get">
                    <div class="form-group">
                        <input type="text" id="searchCondition" name="bookName" class="form-control" placeholder="输入书名">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
                <p class="navbar-text">已产生${searchTotal}次搜索</p>
                <%--管理员登录--%>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">更多 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/searchHistory/showTopSearch">
                                <span class="glyphicon glyphicon-sort-by-attributes-alt" aria-hidden="true"></span>
                                书库热搜
                            </a></li>
                            <li><a target="_blank" href="https://github.com/lq-0519/yiqian/commits/master">
                                <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                                最近更新
                            </a></li>
                            <li role="separator" class="divider"></li>
                            <li><a data-toggle="modal" data-target=".bs-example-modal-sm">
                                <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                                支持群主
                            </a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/user/isLogin">
                                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                    管理员
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <%--管理员登录 /--%>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

<!-- Small modal -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">感谢支持！</h4>
            </div>
            <img class="img-responsive " src="../img/sponsor.JPG">
            <p style="width: 93%; padding-left: 5%; padding-top: 1%;">
                如果你使用网站查到了你想看的书，或者通过缺书登记找到了你想看的书，那么欢迎打赏群主，有你的支持定能更进一步！</p>
        </div>
    </div>
</div>
