<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%-- todo forbid 403--%>
    <%--<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css?t=1522709297490" media="all">
    <script src="//res.layui.com/layui/dist/layui.js?t=1522709297490"></script>--%>
    <%@include file="/jsp/common/common.jsp" %>
    <style>
        /* Make the image fully responsive */
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-md bg-primary navbar-dark fixed-top">
    <!-- Brand -->
    <a class="navbar-brand" href="#">CanDo</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Msg</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">...</a>
            </li>
        </ul>
    </div>
</nav>

<div id="demo" class="carousel slide" data-ride="carousel">

    <!-- 指示符 -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- 轮播图片 -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="http://static.runoob.com/images/mix/img_fjords_wide.jpg">
            <div class="carousel-caption">
                <h3>
                    <a href="<%=MyPropertyPlaceholder.staticResourceUrl()%>/jsp/mytest/myTest.jsp"
                       style="color: white; text-decoration: none">Where there is a will there is a way</a>
                </h3>
                <p>有志者事竟成</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="http://static.runoob.com/images/mix/img_nature_wide.jpg">
            <div class="carousel-caption">
                <h3>The rose's in her hand, the flavor in mine. To be a warm person.</h3>
                <p>予人玫瑰，手有余香</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="http://static.runoob.com/images/mix/img_mountains_wide.jpg">
            <div class="carousel-caption">
                <h3>You have to believe in yourself. That's the secret of success.</h3>
                <p>古今多少事，都付笑谈中</p>
            </div>
        </div>
    </div>

    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>

<div class="container">
    <div class="list-group">
        <a href="<%=MyPropertyPlaceholder.staticResourceUrl()%>/jsp/mytest/myTest.jsp"
           class="list-group-item list-group-item-action">myTest</a>
        <a href="/toPage?url=operation/revenueexpenditure/revenueexpenditure&vx=<%=MyPropertyPlaceholder.appVersion()%>"
           class="list-group-item list-group-item-action">Revenue & Expend</a>
        <a href="/toPage?url=operation/taskManagement/taskManagementMain&vx=<%=MyPropertyPlaceholder.appVersion()%>"
           class="list-group-item list-group-item-action">Task Management</a>
        <a href="#" class="list-group-item list-group-item-action">Second item</a>
        <a href="#" class="list-group-item list-group-item-action">Second item</a>
        <a href="#" class="list-group-item list-group-item-action">Second item</a>
        <a href="#" class="list-group-item list-group-item-action">Second item</a>
        <a href="#" class="list-group-item list-group-item-action">Second item</a>
        <a href="#" class="list-group-item list-group-item-action">Second item</a>
        <a href="#" class="list-group-item list-group-item-action">Third item</a>
    </div>
</div>

<!-- 模态框 -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">Login In</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <%--模态框内容..--%>
                <form>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> Remember me
                        </label>
                    </div>
                    <%--<button type="submit" class="btn btn-primary">Submit</button>--%>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Submit</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>