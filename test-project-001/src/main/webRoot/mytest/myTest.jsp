<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.cd.test.project.common.JspUtils"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="renderer" content="ie-comp">
    <title>mytest</title>
    <style>
        body {
            background-color: #c7edcc;
        }

        .error {
            color: red;
        }

        .content {
            width: 100%;
            list-style-type: none;
        }

        .content .element {
            width: 31%;
            height: 100px;
            border: 1px solid royalblue;
            border-radius: 5px;
            margin-left: 1%;
            margin-top: 5px;
            float: left;
        }

        .testPolygon {
            cursor: pointer;
            width: 452px;
            height: 88px;
            margin: 0 10px 5px 0;
            background-color: #0e90d2;
            background-size: 100% 100%;
            -webkit-shape-outside: polygon(0 0, 333px 0, 100% 50%, 333px 100%, 50% 50px, 10px 100%);
            -webkit-clip-path: polygon(0 0, 333px 0, 100% 50%, 333px 100%, 50% 50px, 10px 100%);
            shape-outside: polygon(0 0, 333px 0, 100% 50%, 333px 100%, 50% 50px, 10px 100%);
            clip-path: polygon(0 0, 333px 0, 100% 50%, 333px 100%, 50% 50px, 10px 100%);
        }

        .iMarquee li {
            width: 400px;
            display: inline-block;
        }

        #canvas_test {
            /*position: absolute;*/
        }

    </style>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugin/css/zTreeStyle.css" type="text/css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery-3.2.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.validate.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/messages_zh.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.ztree.core.js"></script>
</head>
<body>
<ul class="content">
    <%--<li class="element btnsLi">
        <button class="btn">1</button>
        <button class="btn">2</button>
        <button class="btn">3</button>
    </li>
    <li class="element">
        <form class="cmxform" id="signupForm" method="get" action="">
            <fieldset>
                <legend>验证完整的表单</legend>
                <label for="firstname">名字</label>
                <input id="firstname" name="firstname" type="text">
            </fieldset>
        </form>
    </li>
    <li class="element">
        <input class="checkbox_input" type="checkbox" name="userId" value="0" checked="true">0
        <input class="checkbox_input" type="checkbox" name="userId" value="1" checked="true">1
        <input class="checkbox_input" type="checkbox" name="userId" value="2" checked="true">2
    </li>
    <li class="element">
        <form autocomplete="off">
            1:<input type="text">
            2:<input type="text" onfocus="this.type='password'">
            <input type="submit" onclick="return false;">
        </form>
    </li>
    <li class="element" id="polygon_li">
        <div class="testPolygon" style="background: url('test.png')">
            测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；
            测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；测试polygon；
        </div>
    </li>
    <li class="element">
        <marquee behavior="scroll" scrollamount="13" direction="left" class="light" id="ps_scroll">
            <div class="iMarquee" style="white-space: nowrap; display: inline-block;">
                <ul>
                    <li>
                        <div class="button">青松食品有限公司423.36kw分布式</div>
                        <span class="arrowB"></span>
                        <div class="dataCon"><span><span class="name">装机容量</span><span
                                class="num">423.36</span><label class="unit">kWp</label></span></div>
                    </li>
                    <li>
                        <div class="button">小南京6MW分布式的电站</div>
                        <span class="arrowB"></span>
                        <div class="dataCon"><span><span class="name">装机容量</span><span class="num">5.65</span><label
                                class="unit">MWp</label></span></div>
                    </li>
                    <li>
                        <div class="button">宿州埇桥尖山1.8MW电站</div>
                        <span class="arrowB"></span>
                        <div class="dataCon"><span><span class="name">装机容量</span><span class="num">1.8</span><label
                                class="unit">MWp</label></span></div>
                    </li>
                </ul>
            </div>
        </marquee>
    </li>

    <li class="element">
        <canvas id="canvas" width="540px" height="540px"></canvas>
    </li>
    <li class="element">
        <div>test1</div>
        <canvas id="canvas_test" width="540px" height="80px"></canvas>
        <div>test2</div>
    </li>
    <li class="element">
        <script>
            function clickDownload(aLink) {
                var str = "栏位1,栏位2,栏位3\n值1,值2,值3";
                str = encodeURIComponent(str);
                aLink.href = "data:text/csv;charset=utf-8,\ufeff" + str;
//                        aLink.click();
            }
        </script>
        <a id="test" onclick="clickDownload(this)" download="downlaod.csv" href="#">download</a>&nbsp;&nbsp;&nbsp;
        <a onclick="clickDownload_ie()" href="#">IE download</a>
    </li>--%>

    <li class="element">
        <a href="${pageContext.request.contextPath}/mytest/AMap.jsp">AMap</a>
        <a href="${pageContext.request.contextPath}/mytest/GMap.jsp">GMap</a>
        <a href="${pageContext.request.contextPath}/mvc/hello">Hello</a> |
        <a href="${pageContext.request.contextPath}/jointJs/main.html">Joint</a>
    </li>

    <li class="element">
        <ul id="treeDemo" class="ztree"></ul>
    </li>

    <li class="element">
    </li>
</ul>
</body>
<script type="application/javascript">
    var contextPath = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/js/myTest.js?vx=<%=JspUtils.resourceVersion()%>"></script>
</html>
