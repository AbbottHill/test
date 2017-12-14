<%@ page import="com.cd.test.project.common.JspUtils"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String socPath = "ws://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>websocketIndex</title>
    <script>
        var ctx = 'ws://${pageContext.request.contextPath}';
        var ctx = '<%=socPath%>'
    </script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/mytest/websocket.js?vx=<%=JspUtils.resourceVersion()%>"></script>
</head>
<body>
<input type="text" id="writeMsg"/>
<input type="button" value="sendSmgToServer" onclick="sendMsg()"/>
<br>
<span id="testSpan">
    server send you a msg!
    </span>
</body>
</html>

