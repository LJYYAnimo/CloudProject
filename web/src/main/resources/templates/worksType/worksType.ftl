<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>学校类型</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
</head>
<body style="padding-top: 20px">

<fieldset class="layui-elem-field site-demo-button" >
    <legend>作品类型</legend>
    <div>
        <button class="layui-btn" id="add">添加</button>
    </div>
</fieldset>

<table id="xinkai" lay-filter="demo"></table>

<#--学校类型添加-->
<div id="addDiv" style="display: none;padding-top: 20px">
    <form id="schoolType" class="layui-form" lay-filter="worksTypeForm">
        <input type="hidden" name="id"   class="layui-input">
        <div class="layui-form-item">
            <label class="layui-form-label">作品类型</label>
            <div class="layui-input-inline">
                <input type="text" name="worksType" required lay-verify="required" placeholder="请输入学校类型" autocomplete="off"
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

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <#--<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="update">更新</a>-->
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/worksType/worksType.js"></script>
</body>
</html>