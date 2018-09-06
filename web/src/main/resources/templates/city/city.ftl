<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>省下市区</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
</head>
<body style="padding-top: 20px">
<fieldset class="layui-elem-field site-demo-button" >
    <legend>所有市区</legend>
    <div class="layui-inline">
        <input type="button" class="layui-btn" id="add" value="添加市区">
    </div>
</fieldset>
<table id="xinkai" lay-filter="demo"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="query">查看区域</a>
</script>

<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/city/city.js"></script>
</body>
<#--格式化LOGO图片-->
<script type="text/html" id="city_city_banner">
    {{# if(d.city_banner == '' || d.city_banner == null){ }}
    <span style="color: red;">暂无图片</span>
    {{# }else{ }}
    <div><a class="" href="{{d.city_banner}}"  alt="{{ d.city_banner }}"><img src="{{ d.city_banner }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>

<#--格式化封面图片-->
<script type="text/html" id="city_city_logo">
    {{# if(d.city_logo == '' || d.city_logo == null){ }}
    <span style="color: red;">暂无图片</span>
    {{# }else{ }}
    <div><a class="" href="{{ d.city_logo }}"  alt="{{ d.city_logo }}"><img src="{{ d.city_logo }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>
</html>