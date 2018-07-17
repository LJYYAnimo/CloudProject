<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>权限</title>
    <link rel="stylesheet" href="/ztree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="/layui/css/layui.css" type="text/css">

</head>
<body style="padding-top:20px">

<div>
<ul id="treeDemo" class="ztree" style="float: left;"></ul>

<form class="layui-form" style="display: none" id="permissionEdit">
    <div class="layui-form-item">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" required lay-verify="required" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图标</label>
        <div class="layui-input-inline">
            <input type="text" name="icon" required lay-verify="required" placeholder="请输入图标" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图标样式</label>
        <div class="layui-input-inline">
            <input type="text" name="iconClass" required lay-verify="required" placeholder="请输入图标样式" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">父菜单</label>
        <div class="layui-input-inline">
            <select name="pId" lay-verify="required">
                <option value=""></option>
                <option value="0">系统管理</option>
                <option value="1">权限管理</option>
                <option value="2">云平台</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">权限地址</label>
        <div class="layui-input-inline">
            <input type="text" name="jurUrl" required lay-verify="required" placeholder="请输入权限地址" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">注解权限</label>
        <div class="layui-input-inline">
            <input type="text" name="jurPer" required lay-verify="required" placeholder="请输入注解权限" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <textarea name="des" placeholder="请输入菜单描述" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</div>
<script type="text/javascript" src="/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script type="text/javascript" src="/js/qs.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script type="text/javascript" src="/js/permission/permission.js"></script>
</body>
</html>