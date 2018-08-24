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
            <label class="layui-form-label">书籍名称</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="title"  disabled autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text layui-col-xs10 layui-col-sm12 layui-col-md11">
            <label class="layui-form-label">出版类型</label>
            <div class="layui-input-block">
                <input type="text" name="type" id="type"  disabled autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
            <label class="layui-form-label ">书籍类型</label>
            <div class="layui-input-block">
                <input type="text" name="bookType" id="bookType"  disabled autocomplete="off"  class="layui-input">
            </div>
        </div>


        <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
            <label class="layui-form-label ">作品图片</label>
            <div class="layui-input-block ">
                <div class="layui-upload-list">
                   <img class="layui-upload-img layui-col-md12" id="imgs"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg">
                </div>
            </div>
        </div>

        <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
            <label class="layui-form-label ">zip格式文件</label>
            <div class="layui-input-block">
                <a class="layui-btn layui-btn-normal layui-btn-xs"  id="url">下载文件</a>
            </div>
        </div>


        <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
            <label class="layui-form-label">简介</label>
            <div class="layui-input-block">
                <p id="des"></p>
            </div>
        </div>

    </form>
</fieldset>


<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/book/article.js"></script>
</body>
</html>