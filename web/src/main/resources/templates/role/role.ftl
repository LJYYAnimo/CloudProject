<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>角色</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body style="padding-top: 20px">
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