<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/jsp/common/common.jsp" %>
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
    <script src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/js/plugin/jquery/jquery.form.js"></script>
    <!-- 移动端1：1缩放达到缩放布局不乱的效果 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<form id="add_task_form" class="form-inline" role="form" method="post" enctype="multipart/form-data" target="nm_iframe"
      onsubmit="return addTask()"
      action="<%=MyPropertyPlaceholder.staticResourceUrl()%>/taskManagement/addTask">
    <div class="form-group">
        <label class="sr-only" for="task_content">Task</label>
        <input type="text" class="form-control" id="task_content" name="task_content" placeholder="请输入名称">
    </div>
    <div class="form-group">
        <label class="sr-only" for="pic">图片</label>
        <input type="file" id="pic" name="pic">
    </div>
    <input type="submit" class="btn btn-default">
</form>
<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>

<div class="container-fluid">
    <table class="table table-bordered table-striped" id="user_table">
        <tbody id="user_table_tbody">
        </tbody>
    </table>
</div>

</body>
<script type="application/javascript">
    var contextPath = '${pageContext.request.contextPath}';

    //批量生成表格数据
    var tbody = document.getElementById("user_table_tbody");

    function queryTasks() {
        CanDoUtils.jqueryAjax(contextPath + "/taskManagement/tasksInfo", {
            task_id: $("#task_id").val()
        }, dealData, null, 'json');
    }

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


    function dealData(data) {
        var innerHtml = "";
        for (var i = 0, temObj, lens = data.length; i < lens; i++) {
            temObj = data[i];

            innerHtml += "<tr><td>" + temObj["0"] + "</td><td>" + temObj["1"] + "</td><td>" + dealImageNames(temObj["2"]) + "</td></tr>"
        }
        tbody.innerHTML = innerHtml;
    }

    function dealImageNames(imgNames) {
        var htmlStr = "";
        if (!CanDoUtils.isEmptyStr(imgNames)) {
            var imgNamesArr = imgNames.split(/;/g);
            for (var i = 0, temObj, lens = imgNamesArr.length; i < lens; i++) {
                temObj = imgNamesArr[i];
                if (/\./g.test(temObj)) {//文件名中包含'.'
                    htmlStr += '<img style="max-width: 580px;" src="/taskManagement/loadImg?imgName=' + temObj + '">'
                } else {
                    htmlStr += temObj;
                }
            }
        }
        return htmlStr;
    }

    function addTask() {
        if (CanDoUtils.isEmptyStr($("#task_content").val())) {
            $("#task_content").focus();
            return false;
        }
        var options = {
            url: '<%=MyPropertyPlaceholder.staticResourceUrl()%>/taskManagement/addTask',   //同action
            type: 'post',
            beforeSend: function (xhr) {//请求之前

            },
            success: function (data) {
                $("#pic").val("");
                $("#task_content").val("");
                queryTasks();
            },
            complete: function (xhr) {//请求完成

            },
            error: function (xhr, status, msg) {

            }
        };
        $("#add_task_form").ajaxSubmit(options);
        return false;
    }

    queryTasks();

</script>
</html>

