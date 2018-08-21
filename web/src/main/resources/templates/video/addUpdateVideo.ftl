<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>添加视频</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
</head>
<body style="padding-top: 20px">
<form class="layui-form" action="" lay-filter="newsForm" >

    <input type="hidden" name="id"  id="ids" />

    <input type="hidden" name="deletImg"  id="deletImg"/>
    <input type="hidden" name="deletfileVideo"  id="deletfileVideo"/>

    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">视频标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" id="title" lay-verify="worksTitle" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">视频类型</label>
        <div class="layui-input-block">
            <select name="classzId" id="classzId" lay-filter="typeId">
                <option value="">选择视频类型</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
        <label class="layui-form-label">视频简介</label>
        <div class="layui-input-block">
            <textarea name="synopsis" id="synopsis" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
        <label class="layui-form-label ">视频封面</label>
        <div class="layui-input-block ">
            <div class="layui-upload-list">
                <a  id="uploadImg" href="javascript:void(0);"><img class="layui-upload-img layui-col-md12" id="imgs"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg"></a>
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
        <label class="layui-form-label ">视频</label>
        <div class="layui-upload">
            <button type="button" class="layui-btn layui-btn-normal" id="videoPath">选择视频文件(MP4、webm、ogg后缀文件)</button>
            <span class="layui-inline " id="Videotext"></span>
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
<script src="/js/video/addupdatevideo.js"></script>

</body>
</html>