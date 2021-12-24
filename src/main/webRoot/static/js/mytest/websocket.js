var url = ctx + "getServer";
var ws = null;
(function startWebSocket(url) {
    userLogin();
})(url);

function initWebSocket () {
    if ('WebSocket' in window) {
        ws = new WebSocket(url);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(url);
    } else {
        console.error("not support WebSocket!");
    }

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

        setSubscriberFlag();
    };
}

function sendMsg() {
    ws.send(document.getElementById('writeMsg').value);
}

/**
 * create redis subscriber
 */
function subscribe() {
    $.ajax({
        url: "/subscribe",
        type: "post",
        dataType: "json",
        timeout: 1000 * 10,             // async: false，temeout 属性无效
        beforeSend: function () {

        },
        success: function (data) {

        },
        error: function () {

        }
    });
}

/**
 * simulate user login
 */
function userLogin() {
    var abcd = "abcdefghij";
    var topic = abcd[parseInt(Math.random() * 10)] + abcd[parseInt(Math.random() * 10)];
    var topic = "aa";
    $.ajax({
        url: "/mvc/setTopic/" + topic, success: function (result) {
            console.log(result);
            initWebSocket();
        }
    });
}

/**
 * set subscriberFlag = 1
 */
function setSubscriberFlag() {
    $.ajax({
        url: "/mvc/subscriberFlag", success: function (result) {
            console.log(result);
        }
    });
}
