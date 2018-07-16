<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台首页</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/css/app.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">SpringBoot-staging</div>
        <div class="layui-nav layui-layout-left kit-nav">
            <div class="layui-nav-item">
                <!-- 天气信息-->
                <div class="weather" pc>
                    <div id="tp-weather-widget"></div>
                    <script>(function (T, h, i, n, k, P, a, g, e) {
                        g = function () {
                            P = h.createElement(i);
                            a = h.getElementsByTagName(i)[0];
                            P.src = k;
                            P.charset = "utf-8";
                            P.async = 1;
                            a.parentNode.insertBefore(P, a)
                        };
                        T["ThinkPageWeatherWidgetObject"] = n;
                        T[n] || (T[n] = function () {
                            (T[n].q = T[n].q || []).push(arguments)
                        });
                        T[n].l = +new Date();
                        if (T.attachEvent) {
                            T.attachEvent("onload", g)
                        } else {
                            T.addEventListener("load", g, false)
                        }
                    }(window, document, "script", "tpwidget", "//widget.seniverse.com/widget/chameleon.js"))
                    </script>
                    <script>
                        tpwidget("init", {
                            "flavor": "slim",
                            "location": "WX4FBXXFKE4F",
                            "geolocation": "enabled",
                            "language": "zh-chs",
                            "unit": "c",
                            "theme": "chameleon",
                            "container": "tp-weather-widget",
                            "bubble": "disabled",
                            "alarmType": "badge",
                            "color": "#FFFFFF",
                            "uid": "U9EC08A15F",
                            "hash": "039da28f5581f4bcb5c799fb4cdfb673"
                        });
                        tpwidget("show");
                    </script>
                </div>
            </div>
        </div>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/images/face.jpg" class="layui-nav-img">
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" id="info">基本资料</a></dd>
                    <dd><a href="/logout">注销</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javaScript:;" id="shouye"><i class="fa fa-sign-out" aria-hidden="true"></i> 首页</a>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="layui-icon" aria-hidden="true">&#xe603;</i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul id="animo" class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                <#list permissionVo.permissionVoList as items>
                <li class="layui-nav-item">
                    <a href="javascript:;"><span>${items.permission.title}</span></a>
                    <#list items.permissionList as item>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'${item.jurUrl}',icon:'&#xe770;',title:'${item.title}',id:'${item.id}'}">
                                <i class="layui-icon">&#xe770;</i><span>${item.title}</span></a>
                        </dd>
                    </dl>
                    </#list>
                </li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">主体内容加载中,请稍等...</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        2018 &copy;
        <a href="">技术支持：Animo</a>

    </div>
</div>

<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script type="text/javascript" src="/js/home.js"></script>
</body>
</html>