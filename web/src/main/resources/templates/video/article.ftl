<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文章页</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title layui-form">
    <form class="layui-form" action="" lay-filter="newsForm">
        <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
            <label class="layui-form-label">教学标题</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="title"  disabled autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text layui-col-xs10 layui-col-sm12 layui-col-md11">
            <label class="layui-form-label">教学类型</label>
            <div class="layui-input-block">
                <input type="text" name="classzName" id="classzName"  disabled autocomplete="off"  class="layui-input">
            </div>
        </div>


        <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
            <label class="layui-form-label">教学简介</label>
            <div class="layui-input-block">
                <p id="synopsis"></p>
            </div>
        </div>

        <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
            <label class="layui-form-label ">封面</label>
            <div class="layui-input-block ">
                <div class="layui-upload-list">
                   <img class="layui-upload-img layui-col-md12" id="imgs"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg">
                </div>
            </div>
        </div>

        <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
            <label class="layui-form-label ">教学视频</label>
            <div class="layui-input-block">
                <a class="layui-btn layui-btn-normal layui-btn-xs"   id="videoPath" >下载视频</a>
            </div>
        </div>

    </form>
</fieldset>


<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/video/article.js"></script>
</body>
</html>