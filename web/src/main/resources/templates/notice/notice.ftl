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
    <legend>公告管理</legend>
    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <input type="button" class="layui-btn" id="add" value="添加公告">
            </div>

            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="title" name="title" autocomplete="off" class="layui-input" placeholder=" 输入标题">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="editor" name="editor" autocomplete="off" class="layui-input" placeholder="请输入编辑">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="author" name="author" autocomplete="off" class="layui-input" placeholder="请输入作者名称">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="dept" name="dept" autocomplete="off" class="layui-input" placeholder="请输入来源">
                </div>
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="search">搜索</button>
            <button type="reset" class="layui-btn layui-btn-primary cz">重置</button>
            <!--<button class="layui-btn" data-type="exportExcel">导出Excel</button>-->
        </div>
    </form>

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
<script src="/js/notice/notice.js"></script>
</body>
</html>