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
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="details">详情</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="reset">重置密码</a>
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="allot">分配权限</a>
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/user/user.js"></script>
</body>
<#--格式化性别-->
<script type="text/html" id="userGender">
    {{# if(d.sex == 0){ }}
        女
    {{# }else if(d.sex == 1){ }}
        男
    {{# } }}
</script>
</html>