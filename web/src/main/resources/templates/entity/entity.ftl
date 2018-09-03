<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>省</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>

</head>
<body style="padding-top: 20px">

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">积分商品</li>
        <li >订单管理</li>
        <li >已确认订单</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <fieldset class="layui-elem-field site-demo-button" >
                <legend>积分管理</legend>
                <div>
                    <button class="layui-btn" id="addNews">添加积分物品</button>
                </div>
            </fieldset>
            <table id="xinkai"  lay-filter="demo"></table>
        </div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
    </div>
</div>


<script type="text/html" id="barDemo">
    {{# if(d.openOrNot == 0 ){ }}
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="status" title="1">激活</a>
    {{# }else if(d.openOrNot == 1 ){ }}
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="status" title="0">冻结</a>
    {{# } }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-xs" lay-event="query">查看详情</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="update">更新</a>
</script>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/entity/entity.js"></script>
</body>
<#--格式化LOGO图片-->
<script type="text/html" id="entityCoverImg">
    {{# if(d.entityCover == '' || d.entityCover == null){ }}
    <span style="color: red;">暂无图片</span>
    {{# }else{ }}
    <div><a class="" href="{{d.entityCover}}"  alt="{{ d.entityCover }}"><img src="{{ d.entityCover }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>
<script type="text/html" id="Status">
    {{# if(d.openOrNot == 0 ){ }}
    <span style="color: red;">未激活</span>
    {{# }else if(d.openOrNot == 1 ){ }}
    <span style="color: #74ff66;">已激活</span>
    {{# } }}
</script>
</html>