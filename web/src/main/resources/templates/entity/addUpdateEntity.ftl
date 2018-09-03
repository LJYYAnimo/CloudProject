<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>添加资讯</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
    <style type="text/css">
        .layui-form-label {
            width: 90px;
        }
        .layui-input, .layui-textarea {
            width: 80%;
        }
        .layui-input-block {
            margin-left: 120px;
        }
    </style>
</head>
<body style="padding-top: 20px">
<form class="layui-form" action="" lay-filter="newsForm">

    <input type="hidden" name="id"  id="ids" />

    <input type="hidden" name="deletImg"  id="deletImg"/>

    <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
        <label class="layui-form-label ">封面图片</label>
        <div class="layui-input-block ">
            <div class="layui-upload-list">
                <a id="uploadImg" href="javascript:void(0);"><img class="layui-upload-img layui-col-md12" id="imgs"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg"></a>
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">实物名称</label>
        <div class="layui-input-block">
            <input type="text" name="entityName" id="entityName" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">兑换开始时间</label>
        <div class="layui-input-block">
            <input type="text" name="entityStartTime" id="entityStartTime" lay-verify="date"  placeholder="请输入物品兑换开始时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">兑换结束时间</label>
        <div class="layui-input-block">
            <input type="text" name="entityOverTime" id="entityOverTime" lay-verify="date" placeholder="请输入物品兑换结束时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">所需积分</label>
        <div class="layui-input-block">
            <input placeholder="请输入内容" id="theIntegral"  class="layui-input" name="theIntegral" />
        </div>
    </div>

    <div class="layui-form-item layui-form-text layui-col-xs10 layui-col-sm11 layui-col-md11">
        <label class="layui-form-label ">实物数量</label>
        <div class="layui-input-block">
            <input placeholder="请输入内容" id="entityNum"  class="layui-input" name="entityNum" />
        </div>
    </div>

    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">简介</label>
        <div class="layui-input-block">
            <textarea name="entityIntro" id="entityIntro" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

</form>

<div class="layui-form-item layui-col-md-offset4 layui-col-xs4 ">
    <div class="layui-input-block">
        <button id="btn" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        <button id="btnform" class="layui-btn layui-hide" lay-submit="" lay-filter="demo1">立即提交</button>
    </div>
</div>

<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/entity/addupdateEntity.js"></script>

</body>
</html>