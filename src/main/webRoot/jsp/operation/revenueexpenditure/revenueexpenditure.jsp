<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <%--让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
    <h1>我的第一个 Bootstrap 页面</h1>
    <p>重置浏览器大小查看效果!</p>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>第一列</h3>
            <p>菜鸟教程</p>
            <p>学的不仅是技术，更是梦想！！！</p>
        </div>
    </div>
</div>

</body>
</html>