<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文章页</title>
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
<body>
<fieldset class="layui-elem-field layui-field-title layui-form">
    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">实物名称</label>
        <div class="layui-input-block">
            <input type="text" name="entityName" id="entityName"   autocomplete="off"  disabled placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
        <label class="layui-form-label ">实物图片</label>
        <div class="layui-input-block ">
            <div class="layui-upload-list">
                <img class="layui-upload-img layui-col-md12" id="imgs"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">兑换开始时间</label>
        <div class="layui-input-block">
            <input type="text" name="entityStartTime" id="entityStartTime"    autocomplete="off"  disabled placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">兑换结束时间</label>
        <div class="layui-input-block">
            <input type="text" name="entityOverTime" id="entityOverTime"   autocomplete="off"  disabled placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">所需积分</label>
        <div class="layui-input-block">
            <input type="text" name="theIntegral" id="theIntegral"   autocomplete="off"  disabled placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">实物数量</label>
        <div class="layui-input-block">
            <input type="text" name="entityNum" id="entityNum"   autocomplete="off"  disabled placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
        <label class="layui-form-label ">简介</label>
        <div class="layui-input-block">
           <p id="entityIntro"></p>
        </div>
    </div>
</fieldset>


<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/entity/article.js"></script>
</body>
</html>