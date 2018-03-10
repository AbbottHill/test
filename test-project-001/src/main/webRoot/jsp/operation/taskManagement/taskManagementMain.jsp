<%--<%@ page import="com.cd.test.common.JspUtils"%>--%>
<%@ page import="com.cd.test.common.MyPropertyPlaceholder" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="renderer" content="ie-comp">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <title>task management</title>
    <style>
        th {
            text-align: center;
        }

        table {
            text-align: center;
        }

        .fixedhead {
            position: fixed;
            background: white;
        }

    </style>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery-3.2.1.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/canDoUtils.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugin/bootstrap/bootstrap.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">--%>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/js/plugin/bootstrap/bootstrap.js"></script>
    <!-- 移动端1：1缩放达到缩放布局不乱的效果 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

</head>
<body>
<div>
    fdsafdsagaqewqrewq
</div>

<div class="container-fluid">
    <!-- 仅含表头的表格，与下面的表格表头必须一致，然后将此表的css设置为position:fixed，脱离文档流，达到表头固定的效果-->
    <table class="table table-bordered table-striped fixedhead" id="fixedhead">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>状态</th>
        </tr>
        </thead>

    </table>
    <!-- 含有数据的表格，实际上表头的内容不会被显示，因为会被上面的表覆盖，但也不要删除表头，因为需要占位，否则表中第一行数据无法看到。-->
    <table class="table table-bordered table-striped" id="user_table">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody id="user_table_tbody">
        </tbody>
    </table>
</div>
</body>
<script type="application/javascript">
    var contextPath = '${pageContext.request.contextPath}';

    //固定表头的宽度，自适应user_table的宽度
    function autoWidth() {
        document.getElementById("fixedhead").style.width = document.getElementById("user_table").offsetWidth;

    }

    window.onresize = function () {
        //当窗口重绘，重新适应宽度
        autoWidth();
    };
    window.onload = function () {
        //页面加载完毕，表头表的自适应宽度
        autoWidth();
    };

    //批量生成表格数据
    var tbody = document.getElementById("user_table_tbody");

    canDoUtils.jqueryAjax(contextPath + "/taskManagement/tasksInfo", {
        task_id: $("#task_id").val()
    }, dealData, null, 'json');

//
//    var inner = "";
//    for (var i = 0; i < 100; i++) {
//        inner += "<tr>";
//        for (var j = 0; j < 3; j++) {
//            inner += "<td>" + i + j + "</td>";
//        }
//        inner += "</tr>"
//    }
//    tbody.innerHTML = inner;


    var innerHtml = "";
    function dealData(data) {
        for(var i = 0, temObj, lens = data.length; i < lens; i ++) {
            temObj = data[i];
            innerHtml += "<tr><td>" + temObj["0"] + "</td><td>" + temObj["1"] + "</td><td>" + temObj["2"] + "</td></tr>"
        }
        tbody.innerHTML = innerHtml;
    }


</script>
</html>

