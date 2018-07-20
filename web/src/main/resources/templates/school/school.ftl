<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>所有学校</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title" id="">
        <#list schoolTypes as item>
            <#if item_index==0>
                <li class="layui-this">${item.name}</li>
                <#continue>
            </#if>
            <li>${item.name}</li>
        </#list>
    </ul>
    <div class="layui-tab-content"><table id="xinkai" lay-filter="demo"></table></div>
</div>

<#list schoolTypes as item>
    <input hidden class="xinkai_frist" value="${item.name}">
    <#break>
</#list>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/school/school.js"></script>
</body>
</html>