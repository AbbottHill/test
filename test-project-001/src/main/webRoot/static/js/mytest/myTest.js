var MyTestObj = (function () {

    // 将金额类型转为数字类型
    function toNum(str) {
        return str.replace(/\,|\￥/g, "");
    }

    // 保留两位小数（四舍五入）
    function toPrice(num) {
        num = parseFloat(toNum(num)).toFixed(2).toString().split(".");
        num[0] = num[0].replace(new RegExp('(\\d)(?=(\\d{3})+$)','ig'),"$1,");
        return num.join(".");
    }

    // 保留两位小数（不四舍五入）
    function toPrice1(num) {
        num = parseFloat(toNum(num).replace(/(\.\d{2})\d+$/,"$1")).toFixed(2).toString().split(".");
        num[0] = num[0].replace(new RegExp('(\\d)(?=(\\d{3})+$)','ig'),"$1,");
        return num.join(".");;
    }

    // 使用千位分隔符
    function employThousandSplitSymbol(num) {
        var source = toNum(num).split(".");
        source[0] = source[0].replace(new RegExp('(\\d)(?=(\\d{3})+$)','ig'),"$1,");
        return source.join(".");
    }

    return {
        employThousandSplitSymbolOnValue: function () {
            $("#result_thousand_split_symbol").html(employThousandSplitSymbol($("#original_value").val()))
        },

        calculateLen: function () {
            var inputStr = $("#inputStr").val();
            var len = CanDoUtils.getStrLen(inputStr)
            $("#showLength").html(len);
        },

        queryJson: function () {

            var params = {};
            params["p"] = "p1";
            $.ajax({
                url: "/mvc/queryJson",
                type: "post",
                data: params,
                dataType: "json",
                timeout: 1000 * 10,             // async: false，temeout 属性无效
                beforeSend: function () {

                },
                success: function (data) {
                    $(".resultArea").val('1：' + data);
                    try {
                        $(".resultArea").val($(".resultArea").val() + '\n2：' + JSON.parse(data));
                    } catch (e) {

                    }
                    try {
                        $(".resultArea").val($(".resultArea").val() + '\n3：' + eval('(' + data + ')'));
                    } catch (e) {

                    }
                },
                error: function () {
                }
            });

        },

        RESTful: function () {
            
        }

    }

})();

MyTestObj.calculateLen();

/**
 * OOP
 */
(function () {
    function fun() {
        return this.brand + ' run ' + this.speed;
    }

    function Car(brand, speed) {
        this.brand = brand;
        this.speed = speed;
        this.run = fun;
    }

    var Ferrari = new Car('Ferrari', 300);
    var LandRover = new Car('LandRover', 200);

    console.info(Ferrari.run());
    console.info(LandRover.run());

})();


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
            otherParam: {"id": "1", "name": "test", "method": "queryTreeNodes", "service": "testService"}
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
        {id: 2, pId: 0, name: "父节点2", isParent: true},
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
                firstname: "required",
                age: {
                    required: true,
                    number: true,
                    range:[5,10]
                }
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


$(function () {
    var myChart = echarts.init(document.getElementById('echarts_container'));

    // 指定图表的配置项和数据
    var option = {
        grid: {
            x: 100
        },
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [0.20, 0.21, 0.45]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
});
