<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/1
  Time: 11:30
  user google tile
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="map_main" style="height: 100%; width: 80%"></div>
</body>
<%--<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.0&key=3a96bfcb5f18ddce4f670a5dd096e13b"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/amaps.js"></script>
<script>
    var MyAMap = {};
    (function () {
//        try {

            MyAMap.defaultLayer = new AMap.TileLayer({
                getTileUrl: function(x,y,z){
                    return 'http://mt1.google.cn/vt/lyrs=m@142&hl=zh-CN&gl=cn&x='+ x +'&y='+ y +'&z='+ z +'&s=Galil'; //google 默认图层
                }
            });
            MyAMap.satellLayer = new AMap.TileLayer.Satellite({
                getTileUrl: function(x,y,z){
                    // return 'http://mt1.google.cn/vt/lyrs=m@142&hl=zh-CN&gl=cn&x='+ x +'&y='+ y +'&z='+ z +'&s=Galil'; //google 默认图层
                    return 'http://mt1.google.cn/maps/vt?lyrs=s%40746&hl=zh-CN&gl=CN&x='+ x +'&y='+ y +'&z='+ z +''; //google 卫星图层
                }
            });

            MyAMap.AMap = new AMap.Map('map_main', {
                resizeEnable: true,
                zoom: 14,
                zooms: [4, 16],
                layers: [
                    MyAMap.defaultLayer,//默认图层
                    // MyAMap.satellLayer,//卫星图层
                ],
                center: [116.480983, 40.0958]
            });
            if (sysLang == "en" || sysLang == "_en_us") {
                MyAMap.AMap.setLang("en");
            }
            // MyAMap.AMap.setLang("zh_en");
            // MyAMap.AMap.setLang("zh_cn");
//        } catch (e) {
//            alert("network!");
//            return;
//        }
    })();
</script>
</html>
