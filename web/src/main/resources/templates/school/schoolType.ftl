<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>学校类型</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
</head>
<body style="padding-top: 20px">

<#--学校类型添加-->
<div id="addDiv" style="display: none;padding-top: 20px">
    <form id="schoolType" class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">学校类型</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入学校类型" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="schoolTypeAdd">立即提交</button>
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<button id="add" class="layui-btn layui-btn-sm layui-btn">添加</button>

<table id="xinkai" lay-filter="demo"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="query">查看学校</a>
</script>

<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/school/schoolType.js"></script>
</body>
</html>