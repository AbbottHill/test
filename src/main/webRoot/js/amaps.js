(function (config) {
    var ba = navigator.userAgent.toLowerCase(), fa = window, ga = document, ha = ga.documentElement;

    function ka(a) {
        return -1 !== ba.indexOf(a)
    }

    var la = window.location.href, na = /([a-z0-9]*\d+[a-z0-9]*)/;

    function oa() {
        var a = pa;
        if (!a)return null;
        var a = a.toLowerCase(), b = null;
        if (b = a.match(/angle \((.*)\)/)) a = b[1], a = a.replace(/\s*direct3d.*$/, "");
        a = a.replace(/\s*\([^\)]*wddm[^\)]*\)/, "");
        if (0 <= a.indexOf("intel")) {
            b = ["Intel"];
            0 <= a.indexOf("mobile") && b.push("Mobile");
            (0 <= a.indexOf("gma") || 0 <= a.indexOf("graphics media accelerator")) && b.push("GMA");
            if (0 <= a.indexOf("haswell")) b.push("Haswell"); else if (0 <= a.indexOf("ivy")) b.push("HD 4000"); else if (0 <= a.indexOf("sandy")) b.push("HD 3000"); else if (0 <= a.indexOf("ironlake")) b.push("HD");
            else {
                0 <= a.indexOf("hd") && b.push("HD");
                var c = a.match(na);
                c && b.push(c[1].toUpperCase())
            }
            return b = b.join(" ")
        }
        return 0 <= a.indexOf("nvidia") || 0 <= a.indexOf("quadro") || 0 <= a.indexOf("geforce") || 0 <= a.indexOf("nvs") ? (b = ["nVidia"], 0 <= a.indexOf("geforce") && b.push("geForce"), 0 <= a.indexOf("quadro") && b.push("Quadro"), 0 <= a.indexOf("nvs") && b.push("NVS"), a.match(/\bion\b/) && b.push("ION"), a.match(/gtx\b/) ? b.push("GTX") : a.match(/gts\b/) ? b.push("GTS") : a.match(/gt\b/) ? b.push("GT") : a.match(/gs\b/) ? b.push("GS") : a.match(/ge\b/) ?
            b.push("GE") : a.match(/fx\b/) && b.push("FX"), (c = a.match(na)) && b.push(c[1].toUpperCase().replace("GS", "")), 0 <= a.indexOf("titan") ? b.push("TITAN") : 0 <= a.indexOf("ti") && b.push("Ti"), b = b.join(" ")) : 0 <= a.indexOf("amd") || 0 <= a.indexOf("ati") || 0 <= a.indexOf("radeon") || 0 <= a.indexOf("firegl") || 0 <= a.indexOf("firepro") ? (b = ["AMD"], 0 <= a.indexOf("mobil") && b.push("Mobility"), c = a.indexOf("radeon"), 0 <= c && b.push("Radeon"), 0 <= a.indexOf("firepro") ? b.push("FirePro") : 0 <= a.indexOf("firegl") && b.push("FireGL"), 0 <= a.indexOf("hd") &&
        b.push("HD"), 0 <= c && (a = a.substring(c)), (c = a.match(na)) && b.push(c[1].toUpperCase().replace("HD", "")), b = b.join(" ")) : a.substring(0, 100)
    }

    var qa = "microsoft basic render driver;vmware svga 3d;Intel 965GM;Intel B43;Intel G41;Intel G45;Intel G965;Intel GMA 3600;Intel Mobile 4;Intel Mobile 45;Intel Mobile 965".split(";"), ra = "ActiveXObject" in fa, sa = "devicePixelRatio" in fa && 1 < fa.devicePixelRatio || ra && "matchMedia" in fa && fa.matchMedia("(min-resolution:144dpi)") && fa.matchMedia("(min-resolution:144dpi)").matches, ta = ka("windows nt"), ua = -1 !== ba.search(/windows nt [1-5]\./), wa = -1 !== ba.search(/windows nt 5\.[12]/), xa = ua && !wa;
    ka("windows nt 10");
    var ya = ka("windows phone"), za = ka("macintosh"), Aa = ka("Mb2345Browser"), Ba = ka("ipad;") || ka("ipad "), Ca = Ba && sa, Da = ka("ipod touch;"), Ea = ka("iphone;") || ka("iphone "), Fa = Ea || Ba || Da, Ga = Fa && -1 !== ba.search(/ os [456]_/);
    Fa && ba.search(/ os [4-8]_/);
    var Ha = Fa && -1 !== ba.search(/ os [78]_/);
    Fa && ka("os 8_");
    var Ia = Fa && ka("os 10_"), Ja = ka("android"), Ka = -1 !== ba.search(/android [123]/), La = ka("android 4");
    Ja && -1 === ba.search(/android [1-4]/) || ba.search(/android 4.4/);
    var Ma = Ja ? "android" : Fa ? "ios" : ta ? "windows" : za ? "mac" : "other", Na = ra && !fa.XMLHttpRequest, Qa = ra && !ga.querySelector, Ra = ra && !ga.addEventListener, Sa = ra && ka("ie 9"), Ta = ra && ka("msie 10"), Ua = ra && ka("rv:11"), Va = ka("edge"), Wa = ka("qtweb"), Xa = ka("ucbrowser"), Ya = ka("alipay") || Ja && Xa, Za = ka("miuibrowser"), $a = ka("micromessenger"), ab = ka("mqqbrowser"), bb = ka("baidubrowser"), chrome = (ka("chrome") || ka("crios")) && !$a && !bb && !ab && !Va && !Za, cb = chrome && ka("chromium"), db = chrome && !cb && 30 < parseInt(ba.split("chrome/")[1]), eb = ka("firefox"),
        fb = eb && 27 < parseInt(ba.split("firefox/")[1]), gb = (za || Fa) && ka("safari") && ka("version/"), hb = za && gb && 7 < parseInt(ba.split("version/")[1]), ib = Fa && ka("aliapp"), jb = Fa && (!ab && !Xa && !$a && !chrome && !eb && !gb || ib && !Xa), kb = Ja || Fa || ya || ka("mobile"), lb = fa.navigator && fa.navigator.msPointerEnabled && !!fa.navigator.msMaxTouchPoints, mb = fa.navigator && fa.navigator.pointerEnabled && !!fa.navigator.maxTouchPoints, nb = mb || lb, ob = "ontouchstart" in ga || nb, pb = function () {
            if (!kb)return fa.devicePixelRatio || 1;
            var a = document.getElementsByTagName("meta");
            if (window.parent && window.parent !== window)try {
                if (window.parent.location.origin === window.location.origin) a = window.parent.document.getElementsByTagName("meta"); else return 1
            } catch (b) {
                return 1
            }
            for (var c = a.length - 1; 0 <= c; c -= 1)if ("viewport" === a[c].name) {
                var c = a[c].content, d;
                -1 !== c.indexOf("initial-scale") && (d = parseFloat(c.split("initial-scale=")[1]));
                a = -1 !== c.indexOf("minimum-scale") ? parseFloat(c.split("minimum-scale=")[1]) : 0;
                c = -1 !== c.indexOf("maximum-scale") ? parseFloat(c.split("maximum-scale=")[1]) : Infinity;
                if (d) {
                    if (c >= a)return d > c ? c : d < a ? a : d
                } else if (c >= a)return 1 <= a ? 1 : Math.min(c, 1);
                console && console.log && console.log("viewport\u53c2\u6570\u4e0d\u5408\u6cd5");
                return null
            }
        }(), qb = sa && (!kb || !!pb && 1 <= pb), rb = ra && "transition" in ha.style, sb = !!ga.createElementNS && !!ga.createElementNS("http://www.w3.org/2000/svg", "svg").createSVGRect, tb = ga.createElement("canvas"), ub = !(!tb || !tb.getContext), vb = window.URL || window.webkitURL, wb = !ra && !(Xa && Ja) && window.Worker && vb && vb.createObjectURL && window.Blob, zb = "", pa = "", Ab = 0, Bb = {
            alpha: !0,
            antialias: !0, depth: !0, failIfMajorPerformanceCaveat: !0, preserveDrawingBuffer: !0, stencil: !1
        }, Cb = la.split("checkWebgl="), Db = function (a) {
            if (!ub || !wb || jb && "strict" === a)return !1;
            for (var b = ["webgl", "experimental-webgl", "moz-webgl"], c = null, d = 0; d < b.length; d += 1) {
                try {
                    c = tb.getContext(b[d], Bb)
                } catch (e) {
                }
                if (c) {
                    if (c.drawingBufferWidth !== tb.width || c.drawingBufferHeight !== tb.height)break;
                    if ("loose" === a)return !0;
                    if (!c.getShaderPrecisionFormat || !c.getParameter || !c.getExtension)break;
                    Ab = c.getParameter(c.MAX_RENDERBUFFER_SIZE);
                    a = c.getParameter(c.MAX_VIEWPORT_DIMS);
                    if (!a)break;
                    Ab = Math.min(Ab, a[0], a[1]);
                    gb && "mac" === Ma && (Ab = Math.min(Ab, 4096));
                    a = Math.max(screen.width, screen.height);
                    qb && (a *= Math.min(2, window.devicePixelRatio || 1));
                    if (a > Ab)break;
                    if (23 > c.getShaderPrecisionFormat(35632, 36338).precision || 23 > c.getShaderPrecisionFormat(35633, 36338).precision)break;
                    pa = c.getExtension("WEBGL_debug_renderer_info") ? c.getParameter(37446) : null;
                    if ((c = oa()) && -1 !== qa.indexOf(c))break;
                    zb = b[d];
                    return !0
                }
            }
            return !1
        }(2 > Cb.length ? "strict" : Cb[1].split("&")[0]),
        Eb = Db && (db || fb || hb) && ("mac" === Ma || "windows" === Ma) && !kb, Fb = !ub || Wa || ya || kb && eb || Sa || Ga || Ca || Da || Ka || ka("gt-n710") || xa, Gb = !Fb && !Eb && (La || Ha || Fa && $a || !kb), Hb = Eb ? "vw" : Fb ? "d" : Gb ? "dv" : "v", Ib = ka("webkit"), Jb = "WebKitCSSMatrix" in fa && "m11" in new window.WebKitCSSMatrix, Kb = "MozPerspective" in ha.style, Lb = "OTransition" in ha.style, Mb = rb || Jb || Kb || Lb, Nb = void 0 !== config[8] ? config[8] : !0, Ob = void 0 !== config[9] ? config[9] : !0, Pb = void 0 !== config[10] ? config[10] : !0, Qb = void 0 !== config[11] ? config[11] : !0, Rb = void 0 !== config[12] ?
            config[12] : null, Sb = !sb && kb && ub, Tb = !0;
    try {
        if ("undefined" === typeof fa.localStorage) Tb = !1; else {
            var Ub = (new Date).getTime() + "";
            fa.localStorage.setItem("_test", Ub);
            fa.localStorage.getItem("_test") !== Ub && (Tb = !1);
            fa.localStorage.removeItem("_test")
        }
    } catch (Vb) {
        Tb = !1
    }
    config.l = {
        size: Ea ? 100 : Ja ? 200 : 500,
        Kx: za,
        bea: ta,
        PO: Fa,
        P4: Ia,
        Zg: Ja,
        qaa: Ka,
        HN: Ya,
        Iq: Ma,
        sC: bb,
        Rca: ab,
        $Q: gb,
        V9: $a,
        pq: ra,
        ih: Na,
        Bt: Qa,
        Lba: Sa,
        C4: Ta,
        Jd: Ra,
        E4: ra && !Ua,
        v5: Aa,
        Pk: Tb,
        le: Tb && Qb && !kb && chrome,
        Uj: Rb,
        geolocation: kb || ra && !Ra || Va,
        Ty: Xa && !chrome,
        chrome: chrome,
        hD: sa && chrome,
        FN: eb,
        W: kb,
        mca: kb && Ib,
        A5: kb && Jb,
        lca: kb && fa.opera,
        Oc: sa,
        Xy: pb,
        ca: qb,
        Yd: ob,
        G5: lb,
        nQ: mb,
        oQ: nb,
        G1: 57 <= parseInt(ba.split("chrome/")[1]),
        T9: Ib,
        Kba: rb,
        U9: Jb,
        dba: Kb,
        vca: Lb,
        lC: Mb,
        Jk: sb,
        Ht: ub,
        bP: wb,
        gr: Pb,
        Oe: Eb,
        iS: zb,
        jS: Bb,
        XD: pa,
        u5: Ab,
        m$: !1,
        uN: Nb,
        Tw: Nb && !Fb,
        c1: Nb ? Hb : "d",
        sk: Nb ? Db : !1,
        Lt: Nb && (!Fb || Db),
        lm: Ob && !!fa.WebSocket && !bb,
        tca: Sb,
        k6: ub || Sb ? "c" : "d"
    };
    var fa = window, Wb = {
        overlay: ["style"],
        "AMap.IndoorMap": ["AMap.CustomLayer", "cvector"],
        "AMap.MarkerList": ["AMap.TplUtils"],
        Map3D: ["vectorlayer", "wgl"]
    }, Xb = "http map anip layers overlay0 brender mrender".split(" ");
    config.we = "main";
    config.l.Yd && (Xb += ",touch", config.we += "t");
    config.l.W || (Xb += ",mouse", config.we += "m");
    config.we += "c";
    config.l.Lt && (config.we += "v", Xb += ",vectorlayer,overlay", config.l.Oe ? (config.we += "w", Xb += ",wgl") : (config.we += "cg", Xb += ",cmng,cgl"));
    if (config[7]) {
        for (var Yb = [], Zb = config[7].split(","), $b = 0; $b < Zb.length; $b += 1) {
            var ac = Zb[$b];
            Wb[ac] && Yb.push.apply(Yb, Wb[ac]);
            Yb.push(ac)
        }
        Xb += "," + Yb.join(",");
        config.we += config[7].replace(",", "").replace(eval("/AMap./gi"), "")
    }
    config.Wp = Wb;
    Xb += ",sync";
    config.UR = Xb.split(",");
    window.AMap = window.AMap || {version: "v1.4.0"};
    config.wh = "1504670922595";
    var bc = window.AMap.EG = {}, cc = config[2].split(",")[0], dc = cc + "/css/v" + config[4] + "/style1504670922595.css", qc = document.head || document.getElementsByTagName("head")[0];
    if (qc) {
        var rc = document.createElement("link");
        rc.setAttribute("rel", "stylesheet");
        rc.setAttribute("type", "text/css");
        rc.setAttribute("href", dc);
        qc.insertBefore(rc, qc.firstChild)
    } else document.write("<link rel='stylesheet' href='" + dc + "'/>");
    function sc(a) {
        var b = document, c = b.createElement("script");
        c.charset = "utf-8";
        c.src = a;
        (a = b.body || qc) && a.appendChild(c)
    }

    function tc() {
        for (var a = cc + "/maps/main?v=" + config[4] + "&key=" + config[0] + "&m=" + config.UR.join(",") + "&vrs=1504670922595", b = document.getElementsByTagName("script"), c, d = 0; d < b.length; d += 1)if (0 === b[d].src.indexOf(cc.split(":")[1] + "/maps?")) {
            c = b[d];
            break
        }
        config[5] || c && c.async ? sc(a) : (document.write('<script id="amap_main_js" src=\'' + a + "' type='text/javascript'>\x3c/script>"), setTimeout(function () {
            document.getElementById("amap_main_js") || sc(a)
        }, 1))
    }

    var uc = (new Date).getTime();
    bc.__load__ = function (a) {
        a(config, uc);
        bc.__load__ = null
    };
    try {
        if (window.localStorage) {
            var vc = window.localStorage["_AMap_" + config.we], wc = !1;
            vc ? (vc = JSON.parse(vc), vc.version === config.wh ? (eval(vc.script), bc.loaded = !0) : wc = !0) : wc = !0;
            if (wc)for ($b in window.localStorage)window.localStorage.hasOwnProperty($b) && 0 === $b.indexOf("_AMap_") && window.localStorage.removeItem($b)
        }
    } catch (xc) {
    }
    bc.loaded || (tc(), delete config.UR);
})(["3a96bfcb5f18ddce4f670a5dd096e13b", [116.687475, 30.95099, 117.966038, 32.536642, 117.283042, 31.86119], "http://webapi.amap.com", 1, "1.4.0", null, "340100", "", true, true, true, true, "1508851419-1"])