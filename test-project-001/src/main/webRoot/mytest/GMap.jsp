<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/5
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 100%;
        }

        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="map"></div>
<script>
    var map;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
    }
</script>
<%--<script src="https://maps.googleapis.cn/maps/api/js?key=AIzaSyAHU0XNaqVq4n-AGFwAPviDpXcGEJTlKyU&callback=initMap" async defer></script>--%>
<script src="https://maps.google.cn/maps/api/js?key=AIzaSyAHU0XNaqVq4n-AGFwAPviDpXcGEJTlKyU&callback=initMap" async defer></script>
</body>
</html>
