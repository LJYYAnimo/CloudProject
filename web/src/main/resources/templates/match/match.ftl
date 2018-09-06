<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>省</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
    <link rel="stylesheet" href="/layui/css/button.css" />
</head>
<body style="padding-top: 20px">
<fieldset class="layui-elem-field site-demo-button" >
    <legend>大赛管理</legend>
    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <input type="button" class="layui-btn" id="add" value="添加比赛">
            </div>

            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="title" name="title" autocomplete="off" class="layui-input" placeholder=" 输入标题">
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



<div style="display: none;" id="Setting">
    <form class="layui-form" action=""  lay-filter="matchForm">
        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">大赛基本设置</li>
                <li>大赛表彰</li>
                <li>大赛介绍</li>
                <li>大赛规则</li>
            </ul>
            <div class="layui-tab-content">

                <input type="hidden" id="matchId" name="id" />
                <div class="layui-tab-item layui-show">
                    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                        <label class="layui-form-label">比赛标题</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                        <label class="layui-form-label">比赛简介</label>
                        <div class="layui-input-block">
                            <textarea name="matchAbout" id="matchAbout" lay-verify="required"  placeholder="请输入简介" class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                        <label class="layui-form-label">开始时间</label>
                        <div class="layui-input-block">
                            <input type="text" name="startTime" id="startTime" lay-verify="date"  placeholder="请输入开始时间" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                        <label class="layui-form-label">结束时间</label>
                        <div class="layui-input-block">
                            <input type="text" name="endTime" id="endTime" lay-verify="date" placeholder="请输入结束时间" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                        <label class="layui-form-label">比赛奖金</label>
                        <div class="layui-input-block">
                            <input type="text" name="matchBonus" id="matchBonus" lay-verify="required|number" autocomplete="off" placeholder="请输入标题" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11">
                        <label class="layui-form-label">比赛类型</label>
                        <div class="layui-input-block">
                            <input type="text" name="matchType" id="matchType" lay-verify="title" autocomplete="off" placeholder="请输入类型" class="layui-input">
                        </div>
                    </div>
                    <#--<input id="commend" name="commend" type="hidden"/>-->
                    <#--<input id="matchIntroduction" name="matchIntroduction" type="hidden"/>-->
                    <#--<input id="matchRules" name="matchRules" type="hidden"/>-->
                </div>
                <div class="layui-tab-item">
                    <div class="layui-form-item layui-form-text layui-col-xs12 layui-col-sm12 layui-col-md12">
                        <div >
                            <textarea id="demo1"  name="commend" lay-verify="content1" style="display: none;"></textarea>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-form-item layui-form-text layui-col-xs12 layui-col-sm12 layui-col-md12">
                        <div >
                            <textarea id="demo2" name="matchIntroduction" lay-verify="content2" style="display: none;"></textarea>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-form-item layui-form-text layui-col-xs12 layui-col-sm12 layui-col-md12">
                        <div >
                            <textarea id="demo3" name="matchRules" lay-verify="content3" style="display: none;"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit=""  lay-filter="addMatche">立即提交</button>
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>


<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/match/match.js"></script>
</body>
</html>