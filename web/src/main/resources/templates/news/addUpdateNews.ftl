<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>省</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
</head>
<body style="padding-top: 20px">
<form class="layui-form" action="" lay-filter="example">

    <div class="layui-form-item">
        <label class="layui-form-label">封面图片</label>
        <div class="layui-input-block">
            <div class="layui-upload-list">
                <a href="javascript:void(0);"><img class="layui-upload-img" id="uploadImg" style="width: 600px;height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg"></a>
            </div>
        </div>
        <#--<div class="layui-upload">-->
            <#--<button type="button" class="layui-btn" id="uploadImg">上传封面图片</button>-->
            <#--<div class="layui-upload-list">-->
                <#--<img class="layui-upload-img" id="demo1">-->
                <#--<p id="demoText"></p>-->
            <#--</div>-->
        <#--</div>-->
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">输入框</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="desc"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="btn" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/news/addupdatenews.js"></script>

</body>
</html>