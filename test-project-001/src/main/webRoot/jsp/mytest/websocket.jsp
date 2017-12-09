<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/8
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
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
    <script type="text/javascript">
        var wsuri = "<%=socPath%>getServer";
        var ws = null;
        function startWebSocket() {
            if ('WebSocket' in window) {
                ws = new WebSocket(wsuri);
            }
            else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(wsuri);
            }
            else
                console.error("not support WebSocket!");
            ws.onmessage = function (evt) {
                document.getElementById("testSpan").innerHTML = document.getElementById("testSpan").innerHTML + "<br>" + evt.data;
                console.info(evt);
            };

            ws.onclose = function (evt) {
                console.info("close");
                console.info(evt);
            };

            ws.onopen = function (evt) {
                console.info("open");
                console.info(evt);
            };
        }
        ;

        function init() {
            startWebSocket();
        };
        init();

        function sendMsg() {
            ws.send(document.getElementById('writeMsg').value);
        }
    </script>
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

