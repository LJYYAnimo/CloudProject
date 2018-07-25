<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>角色</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body style="padding-top: 20px">

<fieldset class="layui-elem-field site-demo-button" >
    <legend>角色</legend>
    <div>
        <button class="layui-btn" id="add">添加</button>
    </div>
</fieldset>

<#--学校类型添加-->
<div id="addDiv" style="display: none;padding-top: 20px">
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-inline">
                <input type="text" name="role" required lay-verify="required" placeholder="请输入角色名称" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-inline">
                <textarea name="description" placeholder="请输入描述" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="role">立即提交</button>
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<table id="xinkai" lay-filter="demo"></table>

<div id="ztreeDiv" style="display: none;">
    <ul id="treeDemo" class="ztree"></ul>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="distribution">分配权限</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script type="text/javascript" src="/js/qs.js"></script>
<script type="text/javascript" src="/js/role/role.js"></script>
</body>
</html>