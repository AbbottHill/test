<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/14
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String socPath = "ws://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>spring websocket</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        var socPath = '<%=socPath%>'
        var ws = null;
        $(function () {
            console.log("abc");
            $.ajax({
                url: "${pageContext.request.contextPath}/login/abcd", success: function (result) {
                    console.log(result);
                    var ws = new WebSocket(socPath + "/myHandler");
                    ws.onopen = function () {
                        console.log("onpen");
                        ws.send("{}");
                    };
                    ws.onclose = function () {
                        console.log("onclose");
                    };
                    ws.onmessage = function (msg) {
                        document.getElementById("testSpan").innerHTML = document.getElementById("testSpan").innerHTML + "<br>" + msg.data;
                    }
                }
            });
        });

        function sendMsg() {
            ws.send(document.getElementById('writeMsg').value);
        }

        function sendAjax() {
            $.ajax({
                url: "${pageContext.request.contextPath}/message", success: function (result) {
                }
            });
        }

    </script>
</head>
<body>
Spring WebSocket: <a onclick="sendAjax()" style="border: 1px black solid; border-radius: 5px; padding: 5px; cursor: pointer">sendAjax</a>
<hr>
<span id="testSpan">
    server send you a msg!
</span>

</body>
</html>
