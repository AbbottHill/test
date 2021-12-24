<%@ page import="com.cd.test.utils.MyPropertyPlaceholder" %>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="eng" lang="eng">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="author" content="Yigit Yigit Ce.[pulyavserdce.com]"/>
    <meta name="description" content="Site description"/>
    <meta name="keywords" content="keywords, keyword, seo, google"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <title>Coffee Break : 404</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.png"/>
    <link rel="icon" type="image/x-icon" href="favicon.png"/>
    <link rel="apple-touch-icon" href="favicon.png"/>
    <link rel="apple-touch-startup-image" href="favicon.png"/>

    <style>
        /*----------------------------
    i.-- font/imports
    -----------------------------*/

        @font-face{font-family:'Jenna Sue';src:url('../_fonts/jennasue-webfont.eot');src:url('../_fonts/jennasue-webfont.eot?#iefix') format('embedded-opentype'),url('<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/font/jennasue-webfont.woff') format('woff'),url('_fonts/jennasue-webfont.ttf') format('truetype'),url('_fonts/jennasue-webfont.svg#AsapRegular') format('svg');font-weight:normal;font-style:normal;}

        /*---------------------------- static/font/jennasue-webfont.woff
        ii.-- general
        -----------------------------*/

        * {
            margin: 0px;
            padding: 0px;
        }

        html, body, div, h1, h2, h3, ul, ol, li, dt, p, table, th, td, img {
            margin: 0;
            padding: 0;
            border: none;
        }

        body {
            width: 100%;
            height: 100%;
            background: #000000 url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/bg.jpg) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color: #2f2f2f;
            font-weight: normal;
            font-style: normal;
        }

        a:link, a:hover, a:visited {
            color: #2f2f2f;
            text-decoration: none;
        }

        .rotate {
            -o-transform: rotate(-10deg);
            -moz-transform: rotate(-10deg);
            -webkit-transform: rotate(-10deg);
            -ms-transform: rotate(-10deg);
        }

        .social {
            margin: 50px auto;
            width: 408px;
            padding-bottom: 50px;
        }

        .social-icons {
            display: block;
            height: 48px;
        }

        .social-icons li {
            display: inline-block;
            margin-left: 6px;
        }

        @media screen and (min-width: 802px) {
            /* 800+ resolution */
            .controller {
                width: 942px;
                margin: auto;
            }

            .objects {
                width: 100%;
                height: 673px;
                background: url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/objects.png) no-repeat center center;
            }

            .text-area {
                width: 300px;
                padding-top: 180px;
                margin-left: 40px;
                text-align: center;
            }

            .error {
                font: 86px Jenna Sue, Helvetica, Arial, sans-serif;
            }

            .details, .homepage {
                font: 42px Jenna Sue, Helvetica, Arial, sans-serif;
            }

            .homepage {
                background: url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/home.png) no-repeat;
                padding-left: 50px;
                float: right;
                right: 45px;
                top: -50px;
                position: relative;
                text-align: center;
            }

        }

        .copyrights {
            text-indent: -9999px;
            height: 0;
            line-height: 0;
            font-size: 0;
            overflow: hidden;
        }

        /*
        This is not legal version, preview only mode. If you're using this one, you're just fucking cheap. Seriously, It's about 5$, can't you afford it?
    */

        @media screen and (min-width: 602px) and (max-width: 801px) {
            /* 800- resolution */
            .controller {
                width: 800px;
                margin: auto;
            }

            .objects {
                width: 100%;
                height: 673px;
                background: url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/objects-800.png) no-repeat center center;
            }

            .text-area {
                width: 250px;
                padding-top: 190px;
                margin-left: 40px;
                text-align: center;
            }

            .error {
                font: 86px Jenna Sue, Helvetica, Arial, sans-serif;
            }

            .details, .homepage {
                font: 42px Jenna Sue, Helvetica, Arial, sans-serif;
            }

            .homepage {
                background: url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/home.png) no-repeat;
                padding-left: 50px;
                float: right;
                right: 25px;
                top: -50px;
                position: relative;
                text-align: center;
            }

        }

        @media screen and (min-width: 0px) and (max-width: 601px) {
            /* 600- resolution */
            .controller {
                width: 600px;
                margin: auto;
            }

            .objects {
                width: 100%;
                height: 673px;
                background: url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/objects-600.png) no-repeat center center;
            }

            .text-area {
                width: 200px;
                padding-top: 230px;
                margin-left: 20px;
                text-align: center;
            }

            .error {
                font: 56px Jenna Sue, Helvetica, Arial, sans-serif;
            }

            .details, .homepage {
                font: 32px Jenna Sue, Helvetica, Arial, sans-serif;
            }

            .homepage {
                background: url(<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/home-600.png) no-repeat;
                padding-left: 35px;
                float: right;
                right: 20px;
                top: -50px;
                position: relative;
                text-align: center;
            }

        }
    </style>

</head>
<body>
<div class="controller">
    <div class="objects">
        <!-- text area -->
        <div class="text-area rotate">
            <p class="error">Error 404</p>
            <p class="details">There was a problem<br/><br/>The page you are looking for is not here or moved.</p>
        </div>
        <!-- text area -->
        <!-- home page -->
        <div class="homepage rotate">
            <a href="/jsp/mytest/myTest.jsp">Back to homepage</a>
        </div> <!-- home page -->
    </div> <!-- social-icons -->
    <div class="social">
        <ul class="social-icons">
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/forrst.png" alt="Forrst"/></a></li>
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/dribbble.png" alt="Dribbble"/></a></li>
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/deviantart.png" alt="DeviantArt"/></a></li>
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/flickr.png" alt="Flickr"/></a></li>
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/twitter.png" alt="Twitter"/></a></li>
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/facebook.png" alt="Facebook"/></a></li>
            <li><a href="#"><img src="<%=MyPropertyPlaceholder.staticResourceUrl()%>/static/images/skype.png" alt="Skype"/></a></li>
        </ul>
    </div>
    <!-- social-icons -->
</div>

</body>
</html>