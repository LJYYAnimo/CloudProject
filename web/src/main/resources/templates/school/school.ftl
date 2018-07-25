<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>所有学校</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
</head>
<body>

<fieldset class="layui-elem-field site-demo-button" style="margin-top: 30px;">
    <legend>所有学校</legend>
    <div>
        <button class="layui-btn" id="add">添加</button>
    </div>
</fieldset>

<div id="addDiv" style="display: none;">
    <form class="layui-form" style="padding-top: 20px;">
        <div class="layui-inline">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-block">
                <select id="schoolTypeid" name="schoolTypeid" lay-verify="required">
                    <option value=""></option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="schoolName" required lay-verify="required" placeholder="请输入学校名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="detailedAddress" required lay-verify="required" placeholder="请输入学校地址" autocomplete="off" class="layui-input">
                <#--<div class="layui-form-mid layui-word-aux" id='open_BaiDuMap' style="cursor: pointer;" >百度地图</div>-->
            </div>
        </div>
        <p style="padding-top: 20px;"></p>
        <div class="layui-form-item layui-form-text" >
            <label class="layui-form-label">简介</label>
            <div class="layui-input-block">
                <textarea name="schoolAbout" placeholder="请输入学校简介" class="layui-textarea" style="width: 730px;"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title" id="">
        <#list schoolTypes as item>
            <#if item_index==0>
                <li class="layui-this">${item.name}</li>
                <#continue>
            </#if>
            <li>${item.name}</li>
        </#list>
    </ul>
    <div class="layui-tab-content">
        <table id="xinkai" lay-filter="demo"></table>
    </div>
</div>

<#list schoolTypes as item>
    <input hidden class="xinkai_frist" value="${item.name}">
    <#break>
</#list>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/public.js"></script>
<script src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/school/school.js"></script>
</body>
<#--格式化审核状态-->
<script type="text/html" id="sdSchoolStatus">
    {{#  if(d.auditStatus == 0){ }}
        未审核
    {{#  } else if(d.auditStatus == 1){ }}
        通过
    {{#  } else if(d.auditStatus == 2){ }}
        未通过
    {{#  } }}
</script>

<#--格式化LOGO图片-->
<script type="text/html" id="sdSchoolLogo">
    {{# if(d.schoolLoge == '' || d.schoolLoge == null){ }}
        <span style="color: red;">暂无图片</span>
    {{# }else{ }}
        <div><a class="" href="d.schoolLoge"  alt="{{ d.schoolLoge }}"><img src="{{ d.schoolLoge }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>

<#--格式化封面图片-->
<script type="text/html" id="sdSchoolCover">
    {{# if(d.schoolCover == '' || d.schoolCover == null){ }}
        <span style="color: red;">暂无图片</span>
    {{# }else{ }}
        <div><a class="" href="{{ d.schoolCover }}"  alt="{{ d.schoolCover }}"><img src="{{ d.schoolCover }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>
</html>