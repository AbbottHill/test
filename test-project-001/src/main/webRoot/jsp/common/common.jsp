<%@ page import="com.cd.test.utils.MyPropertyPlaceholder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="shortcut icon" href="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/favicon.ico"/>
<script>
    var contextPath = '${pageContext.request.contextPath}';
</script>
<script type="application/javascript" src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/js/plugin/jquery/jquery-3.2.1.js"></script>
<script src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/js/plugin/jquery/jquery.form.js"></script>
<script type="application/javascript" src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/js/utils/CanDoUtils.js"></script>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>