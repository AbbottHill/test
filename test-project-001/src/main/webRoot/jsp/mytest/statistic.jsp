<html>
<head>
<title>Threads</title>
<style>
body {font-size:8pt;}
ol {line-height:18px;}
</style>
    <script>
        setInterval(function(){
            window.location.reload();
        },  1000);
    </script>
</head>
<body>
<strong>java.io.tmpdir:</strong>
<ul>
<li><%=System.getProperty("java.io.tmpdir")%></li>
</ul>
<br/>
<strong>Memory:</strong>
<ol>
    <li>currentMemory=<input type="text" id="freeMemory"> M</li>
<li>freeMemory=<%=Runtime.getRuntime().freeMemory()/(1024*1024)%>M</li>
    <li>totalMemory=<%=Runtime.getRuntime().totalMemory()/(1024*1024)%>M</li>
    <li>maxMemory=<%=Runtime.getRuntime().maxMemory()/(1024*1024)%>M</li>
</ol>
<br/>
<strong>Thread:</strong>
<ol>
<%for(Thread t : list_threads()){%>
<li><%=t.getName()%>(<b><%=t.getState()%></b>) : <%=t.getClass().getName()%></li>
<%}%>
</ol>
<%!
public static java.util.List<Thread> list_threads(){
    int tc = Thread.activeCount();
    Thread[] ts = new Thread[tc];
    Thread.enumerate(ts);
    return java.util.Arrays.asList(ts);
}
%>
</body>
</html>