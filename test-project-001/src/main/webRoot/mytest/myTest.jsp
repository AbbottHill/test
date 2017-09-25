<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
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

    <link rel="stylesheet" href="./css/zTreeStyle.css" type="text/css">
    <script type="application/javascript" src="./jquery-3.2.1.js"></script>
    <script type="application/javascript" src="./jquery.validate.min.js"></script>
    <script type="application/javascript" src="./messages_zh.min.js"></script>
    <script type="application/javascript" src="./jquery.ztree.core.js"></script>
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
        <ul id="treeDemo" class="ztree"></ul>
    </li>

    <li class="element">
    </li>

    <li class="element">
    </li>
</ul>
</body>
<script type="application/javascript">
    var contextPath = '${pageContext.request.contextPath}';
    /**
     * ztree
     */
    (function () {
//ztree
        var zTreeObj;

        function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
//            alert(msg);
        };

        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            async: {
                enable: true,
                url: contextPath + "/servlet_01",
                dataType: "json",
                type: "post",
                autoParam: ["id=zId"],
                otherParam: { "id":"1", "name":"test"}
            },
            callback: {
                onAsyncSuccess: zTreeOnAsyncSuccess
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: 0
                }
            }

        };
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
        var zNodes = [
            {id: 1, pId: 0, name: "父节点1"},
            {id: 11, pId: 1, name: "子节点1"},
            {id: 12, pId: 1, name: "子节点2", isParent: true}
        ];
        $(document).ready(function () {
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
    })();


    //canvas
    (function () {
        return
        drawEle();
        function preDraw() {
            drawEle();
        }

        window.setInterval(preDraw, 4000);

        function drawEle() {
            var canvas = document.getElementById('canvas');
            var stps = 100;
            if (canvas.getContext) {
                var ctx = canvas.getContext('2d');
                ctx.clearRect(0, 0, canvas.width, canvas.height);
//                var p = new Path2D("M10 10 h 80 v 80 h -80 Z");
//                ctx.stroke(p);

                drawLine(ctx, 50, 30, 390, 30, '#c8c8c8');
                drawLine(ctx, 210, 30, 210, 200, '#c8c8c8');
                drawImags(ctx);
//                setTimeout(drawLine(ctx, 50, 30, 190, 30, 'green'), 100);

                var times = 0;
                var node1 = 170;

                function drawFrame() {
                    var rad = 340 / stps;
                    window.requestAnimationFrame(drawFrame, canvas);
                    if (times > stps) {
                        return;
                    }
                    drawLine(ctx, 50, 30, 50 + times * rad, 30, 'green');
                    if (times * rad < node1) {
                        drawLine(ctx, 390, 40, 380 - times * rad, 40, 'yellow');
                    } else {
                        drawLine(ctx, 390, 40, 380 - 170, 40, 'yellow');
                        drawLine(ctx, 380 - 170, 40, 380 - 170, 40 + (times * rad - 180), 'yellow');
                    }
                    times++;
                }

                drawFrame();
            }
        }

        function drawElectricity() {

        }

        function drawLine(cont, xstart, ystart, xend, yend, color) {
            cont.beginPath();
            cont.moveTo(xstart, ystart);
            cont.strokeStyle = color;
            cont.lineWidth = 10; //设置线宽
//                cont.lineCap = 'round';
            cont.lineTo(xend, yend);
            cont.stroke();
            cont.closePath();
        }

        function drawImags(ctx) {
            var img = new Image();
            img.onload = function () {
                ctx.drawImage(img, 10, 15);
                /*ctx.beginPath();
                 ctx.moveTo(30,96);
                 ctx.lineTo(70,66);
                 ctx.lineTo(103,76);
                 ctx.lineTo(170,15);*/
                ctx.stroke();
            };
            img.src = contextPath + '/screen_5.0/images/ps.png';

            var img2 = new Image();
            img2.onload = function () {
                ctx.drawImage(img2, 400, 0);
            };
            img2.src = contextPath + '/screen_5.0/images/store.png';

            var img3 = new Image();
            img3.onload = function () {
                ctx.drawImage(img3, 200, 190);
            };
            img3.src = contextPath + '/screen_5.0/images/wind.png';
        }
    })();


    (function () {
        $(".testPolygon").click(function () {
//        alert("click div");
            event.stopPropagation();
        });

        $("#polygon_li").click(function () {
            alert("click li");
        });

        $().ready(function () {
            // 在键盘按下并释放及提交后验证提交表单
            $("#signupForm").validate({
                onfocusout: function (element) {
                    $(element).valid();
                },
                rules: {
                    firstname: "required"
                }
            });

            $("#checkBtn").unbind().bind('click', function () {
                alert($("#signupForm").valid());
            });
        });


//scope
        var btns = $(".btn");
        for (var i = 0; i < btns.length; i++) {
            var obj = btns[i];
//        btns.unbind().bind("click", function (e) {
//            debugger;
//            $(".btnsLi").append("btn-" + i);
//        })

            $(obj).unbind().bind("click", (function (index) {
                return function () {
                    $(".btnsLi").append("btn-" + index);
                };
            })(i));
//        obj.onclick = (function(index) {
//            return function(evt) {
//                $(".btnsLi").append("btn-" + index);
//            };
//        })(i);

        }
    })();
</script>
</html>
