<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title" id="">
        <#list userTypeList as item>
            <#if item_index==0>
                <li class="layui-this">${item.name}</li>
                <#continue>
            </#if>
            <li>${item.name}</li>
        </#list>
    </ul>

    <div class="layui-tab-content"><table id="xinkai" lay-filter="demo"></table></div>
</div>

<#list userTypeList as item>
    <input hidden class="xinkai_frist" value="${item.name}">
    <#break>
</#list>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="query">查看用户</a>
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/user/user.js"></script>
</body>
</html>