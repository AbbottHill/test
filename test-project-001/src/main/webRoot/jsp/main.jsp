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
    <script type="application/javascript" src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/js/main.js?version=<%=MyPropertyPlaceholder.appVersion()%>"></script>
</head>
<body>
<%--<script src='//kefu.easemob.com/webim/easemob.js?configId=92b7b0d7-e652-4250-88d6-f7aa7d62b7a3'></script>--%>

<!--[if lt IE 9]>
<script src="https://g.alicdn.com/aliww/ww/json/json.js" charset="utf-8"></script>
<![endif]-->
<!-- 强制使用pc版本的kit -->
<!--<script src="https://g.alicdn.com/aliww/??h5.openim.sdk/1.0.6/scripts/wsdk.js,h5.openim.kit/0.3.3/scripts/kit.js?pc=1" charset="utf-8"></script>-->



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
                <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal" id="nav_user_name">User</a>
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
    <div class="list-group"><%--
        <a target="_blank" href="<%=MyPropertyPlaceholder.staticResourceUrl()%>/jsp/mytest/myTest.jsp"
           class="list-group-item list-group-item-action">myTest</a>
        <a target="_blank" href="/toPage?url=operation/revenueexpenditure/revenueexpenditure&vx=<%=MyPropertyPlaceholder.appVersion()%>"
           class="list-group-item list-group-item-action">Revenue & Expend</a>
        <a target="_blank" href="/toPage?url=operation/taskManagement/taskManagementMain&vx=<%=MyPropertyPlaceholder.appVersion()%>"
           class="list-group-item list-group-item-action">Task Management</a>--%>
        <a style="display: none;" target="_blank" href="/toPage?url=tencentIM/chartroom"
           class="list-group-item list-group-item-action chart_room_link">Chart Room</a><%--
        <a target="_blank" href="/static/tengxunIM/index.html"
           class="list-group-item list-group-item-action">腾讯 云通讯 demo</a>--%>
        <a style="display: none;" target="_blank" href="/static/aliopenim/enter.html"
           class="list-group-item list-group-item-action chart_room_link">百川云旺·即时通讯</a>
        <a target="_blank" href="/static/huanxin/index.html"
           class="list-group-item list-group-item-action">环信 demo</a>
        <%--
        <a target="_blank" href="/static/tencentIM/index.html"
           class="list-group-item list-group-item-action">Chart Room(html)</a>--%><%--
        <a target="_blank" href="#" class="list-group-item list-group-item-action">Second item</a>
        <a target="_blank" href="#" class="list-group-item list-group-item-action">Second item</a>
        <a target="_blank" href="#" class="list-group-item list-group-item-action">Second item</a>
        <a target="_blank" href="#" class="list-group-item list-group-item-action">Second item</a>
        <a target="_blank" href="#" class="list-group-item list-group-item-action">Third item</a>
        --%>
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
                <form id="login_form" role="form" method="post" target="nm_iframe"
                      onsubmit="return userLogin()"
                      action="<%=MyPropertyPlaceholder.staticResourceUrl()%>/user/login">
                    <div class="form-group">
                        <label for="user_account">Email:</label>
                        <input type="email" class="form-control" id="user_account" name="user_account" placeholder="Enter account">
                    </div>
                    <div class="form-group">
                        <label for="user_pwd">Password:</label>
                        <input type="password" class="form-control" id="user_pwd" name="user_pwd" placeholder="Enter password">
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> Remember me
                        </label>
                    </div>
                </form>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="MainObj.userLogin()">Submit</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<iframe name="nm_iframe" style="display:none;"></iframe>
</body>
</html>