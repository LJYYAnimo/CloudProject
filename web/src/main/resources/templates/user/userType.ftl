<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
</head>
<body style="padding-top: 20px">

<fieldset class="layui-elem-field site-demo-button" >
    <legend>用户类型</legend>
    <div>
        <button class="layui-btn" id="add">添加</button>
    </div>
</fieldset>

<table id="xinkai" lay-filter="demo"></table>

<#--用户类型添加-->
<div id="addDiv" style="display: none;padding-top: 20px">
    <form id="schoolType" class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入用户类型" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="userTypeAdd">立即提交</button>
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/user/userType.js"></script>
</body>
</html>