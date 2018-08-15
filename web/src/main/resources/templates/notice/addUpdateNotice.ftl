<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>添加资讯</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
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
        <label class="layui-form-label">公告标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" id="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">关于</label>
        <div class="layui-input-block">
            <textarea name="about" id="about" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <#--<div >-->
        <#--<div class="banner" >-->
            <#--<span style="font-size:12px; color:#616161; margin-left:10px">欢迎访问南京林业大学人事处</span>-->
            <#--<div class="login-regist-quit">-->

            <#--<#if frontuser != null>-->
                <#--<div class="login-item">-->
                    <#--<div class="login-image"><img src="/DFS//template/183//images/small-user.png" /></div>-->
                    <#--<div class="login-buttom"><a class="buttom-name" onclick="showIportal(${frontuser.iid});">${frontuser.realName}</a></div>-->
                <#--</div>-->
                <#--<div class="login-gap"><img src="/DFS//template/183//images/gap.png" /></div>-->
                <#--<div class="login-item">-->
                    <#--<div class="login-image"><img src="/DFS//template/183//images/small-quit.png" /></div>-->
                    <#--<div class="login-buttom"><a class="buttom-name" id="quit">退出</a></div>-->
                <#--</div>-->
            <#--<#else>-->
                <#--<div class="login-item">-->
                    <#--<div class="login-image"><img src="/DFS//template/183//images/small-user.png" /></div>-->
                    <#--<div class="login-buttom"><a class="buttom-name" id="login">登录</a></div>-->
                <#--</div>-->
                <#--<div class="login-gap"><img src="/DFS//template/183//images/gap.png" /></div>-->
                <#--<div class="login-item">-->
                    <#--<div class="login-image"><img src="/DFS//template/183//images/small-regist.png" /></div>-->
                    <#--<div class="login-buttom"><a class="buttom-name" id="regist">注册</a></div>-->
                <#--</div>-->
                <#--<div style="clear:both;"></div>-->
            <#--</#if>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->

    <div class="layui-form-item layui-form-text layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">公告来源</label>
        <div class="layui-input-block">
            <input placeholder="请输入内容" id="dept"  class="layui-input" name="dept" />
        </div>
    </div>

    <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
        <label class="layui-form-label ">公告内容</label>
        <div class="layui-input-block">
            <textarea id="demo" style="display: none;"></textarea>
        </div>
    </div>
</form>

<div class="layui-form-item layui-col-md-offset4 layui-col-xs4 ">
    <div class="layui-input-block">
        <button id="btn" class="layui-btn " lay-submit="" lay-filter="demo1">立即提交</button>
        <button id="btnform" class="layui-btn layui-hide" lay-submit="" lay-filter="demo1">立即提交</button>
    </div>
</div>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/notice/addupdateNotice.js"></script>

</body>
</html>