<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>省</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>

</head>
<body style="padding-top: 20px">
<fieldset class="layui-elem-field site-demo-button" >
    <legend>资讯管理</legend>
    <div>
        <button class="layui-btn" id="addNews">添加资讯</button>
    </div>
</fieldset>
<table id="xinkai"  lay-filter="demo"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-xs" lay-event="query">查看详情</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="update">更新</a>
</script>

<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/news/news.js"></script>
</body>
<#--格式化LOGO图片-->
<script type="text/html" id="sdTitleImg">
    {{# if(d.titleImg == '' || d.titleImg == null){ }}
    <span style="color: red;">暂无图片</span>
    {{# }else{ }}
    <div><a class="" href="{{d.titleImg}}"  alt="{{ d.titleImg }}"><img src="{{ d.titleImg }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>
</html>