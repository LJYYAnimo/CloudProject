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
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">大赛基本信息</li>
        <li>大赛表彰</li>
        <li>大赛介绍</li>
        <li>大赛规则</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                <label class="layui-form-label">大赛标题</label>
                <div class="layui-input-block">
                    <input type="text" name="title" id="title"  autocomplete="off"  disabled placeholder="请输入标题" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
                <label class="layui-form-label ">比赛简介</label>
                <div class="layui-input-block">
                    <p id="matchAbout"></p>
                </div>
            </div>

            <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
                <label class="layui-form-label ">开始时间</label>
                <div class="layui-input-block">
                    <input type="text" name="startTime" id="startTime"  placeholder="yyyy-MM-dd"  autocomplete="off"  disabled  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
                <label class="layui-form-label ">结束时间</label>
                <div class="layui-input-block">
                    <input type="text" name="endTime" id="endTime"  placeholder="yyyy-MM-dd" autocomplete="off"  disabled  class="layui-input">
                </div>
            </div>

            <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                <label class="layui-form-label">比赛奖金</label>
                <div class="layui-input-block">
                    <input type="text" name="matchBonus" id="matchBonus" lay-verify="required|number" disabled autocomplete="off" placeholder="请输入标题" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                <label class="layui-form-label">比赛类型</label>
                <div class="layui-input-block">
                    <input type="text" name="matchType" id="matchType" lay-verify="title" autocomplete="off" disabled placeholder="请输入类型" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-tab-item">
            <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
                <label class="layui-form-label ">大赛表彰</label>
                <div class="layui-input-block">
                    <p id="commend"></p>
                </div>
            </div>
        </div>
        <div class="layui-tab-item">
            <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
                <label class="layui-form-label ">大赛介绍</label>
                <div class="layui-input-block">
                    <p id="matchIntroduction"></p>
                </div>
            </div>
        </div>
        <div class="layui-tab-item">
            <div class="layui-form-item layui-form-text layui-col-xs11 layui-col-sm11 layui-col-md11">
                <label class="layui-form-label ">大赛规则</label>
                <div class="layui-input-block">
                    <p id="matchRules"></p>
                </div>
            </div>
        </div>

    </div>
</div>


</fieldset>


<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/match/article.js"></script>
</body>
</html>