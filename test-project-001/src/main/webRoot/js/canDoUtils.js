var canDoUtils = (function () {

    Date.prototype.Format = function (fmt) {
        var o =
            {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };

    Date.prototype.addDays = function (d) {
        this.setDate(this.getDate() + d);
    };

    Date.prototype.addWeeks = function (w) {
        this.addDays(w * 7);
    };

    Date.prototype.addMonths = function (m) {
        var d = this.getDate();
        this.setMonth(this.getMonth() + m);
        if (this.getDate() < d)
            this.setDate(0);
    };

    Date.prototype.addYears = function (y) {
        var m = this.getMonth();
        this.setFullYear(this.getFullYear() + y);
        if (m < this.getMonth()) {
            this.setDate(0);
        }
    };

    /**
     * 判断值是否未定义
     * @param value
     * @returns {boolean}
     */
    function isUndefinedOrNull(value) {
        if (typeof value === "undefined" || null === value) {
            return true;
        }
        return false;
    }

    /**
     * 空字符串
     * @param value
     * @returns {boolean}
     */
    function isEmptyStr(value) {
        if (isUndefinedOrNull(value) || "" === value) {
            return true;
        }
        return false;
    }

    /**
     * 获取指定月的天数，默认取当前月
     * @param year [1910-2910]
     * @param month [1-12]
     */
    function daysOfSpecificMonth(year, month) {
        if (isEmptyStr(year) || isEmptyStr(month) || isNaN(year) || isNaN(month)) {
            var now = new Date();
            year = now.getFullYear();
            month = now.getMonth() + 1;
        }
        var specificDate = new Date(year + '-' + month);
        specificDate.addMonths(1);
        specificDate.addDays(-1);
        return specificDate.getDate();
    }

    /**
     * 计算字符串长度
     * 函数说明：计算字符串长度，半角长度为1，全角长度为2
     * @param str 字符串
     * @return 字符串长度
     */
    function getStrLen(str) {
        var len = 0;
        if (!isUndefinedOrNull(str)) {
            var c;
            for (var i = 0; i < str.length; i++) {
                c = str.charCodeAt(i);
                if (isDbcCase(c)) { //半角
                    len = len + 1;
                } else { //全角
                    len = len + 2;
                }
            }
        }
        return len;
    }

    /**
     * 判断字符是全角还是半角
     * 函数说明：判断字符是全角还是半角
     * @param c 字符
     * @return true：半角 false：全角
     */
    function isDbcCase(c) {
        // 基本拉丁字母（即键盘上可见的，空格、数字、字母、符号）
        if (c >= 32 && c <= 127) {
            return true;
        }
        // 日文半角片假名和符号
        else if (c >= 65377 && c <= 65439) {
            return true;
        }
        return false;
    }

    /**
     * url中获取请求参数值
     */
    function paramFromUrl(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var url = window.location.href;
        var search = url.substring(url.indexOf("?"), url.length);
        var r = search.substr(1).match(reg);
        if (r != null) return decodeURI(r[2]);
        return null;
    }

    /**
     * 精确度
     */
    function fixNumber(num, n) {
        if (isUndefinedOrNull(num)) {
            return "--";
        }
        if (isUndefinedOrNull(n)) {
            n = 2;
        }
        if ($.isNumeric(num)) {
            return parseFloat(num).toFixed(n);
        } else {
            return "--";
        }
    }

    /**
     * 浏览器控制台打log
     */
    function logger(msg) {
        try {
            if (typeof(console) != "undefined") {
                console.log(msg)
            }
        } catch (e) {
        }
    }

    /**
     * 小于10的数字前补0
     */
    function zeroFill(value) {
        return value < 10 ? '0' + value : value;
    }

    /**
     * new cookie
     */
    function jqueryAjax (url, params, successFunc, failFunc, dataType, type) {
        if (isUndefinedOrNull(url) || url === '') {
            return;
        }
        var request = $.ajax({
            url: url,
            method: isUndefinedOrNull(type)? "POST": type,
            data: params,
            dataType: isUndefinedOrNull(dataType)?"json": dataType
        });

        request.done(function( msg ) {
            if (!isUndefinedOrNull(successFunc) && typeof successFunc === 'function') {
                successFunc(msg);
            }
        });

        request.fail(function( jqXHR, textStatus ) {
            // alert( "Request failed: " + textStatus );
            // failFunc();
        });
    }

    return {
        getStrLen: getStrLen,
        isEmptyStr: isEmptyStr,
        isUndefinedOrNull: isUndefinedOrNull,
        daysOfSpecificMonth: daysOfSpecificMonth,
        paramFromUrl: paramFromUrl,
        fixNumber: fixNumber,
        logger: logger,
        zeroFill: zeroFill,
        jqueryAjax: jqueryAjax,
    };
})();