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
    <form class="layui-form" style="padding-top: 20px;" lay-filter="Form">
        <input type="hidden" id="ids" name="id">
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
        <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
            <label class="layui-form-label ">LOGO</label>
            <div class="layui-input-block ">
                <div class="layui-upload-list">
                    <a  id="uploadImg" href="javascript:void(0);"><img class="layui-upload-img layui-col-md12" id="imgs"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg"></a>
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-col-xs12 layui-col-sm10 layui-col-md8">
            <label class="layui-form-label ">封面</label>
            <div class="layui-input-block ">
                <div class="layui-upload-list">
                    <a  id="uploadImg1" href="javascript:void(0);"><img class="layui-upload-img layui-col-md12" id="imgs1"  style="height: 400px" src="http://www.3dimperial.com/upload/attachedNew/image/20170707/20170707100224_705.jpg"></a>
                </div>
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
<div id="StatusDiv" style="display: none;padding-top: 20px">
    <form id="schoolType" class="layui-form">
        <input type="hidden" id="id" name="id" />
        <input type="hidden" id="deletLoge" name="deletLoge" />
        <input type="hidden" id="deletImg" name="deletImg" />
        <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11 ">
            <label class="layui-form-label " style="width: 120px" id="statustext">审核不通过原因</label>
            <div class="layui-col-xs8">
                <textarea name="scDes" id="scDes"  placeholder="请输入内容"  class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item ">
            <div class="layui-input-block">
                <input id="statusYse" type="button" class="layui-btn" lay-submit lay-filter="statusYse" value="通过"/>
                <input id="statusNo"  type="button" class="layui-btn layui-btn-danger" lay-submit lay-filter="statusNo" value="不通过" />
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/html" id="barDemo">

    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    {{# if(d.auditStatus == 0 ){ }}
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="status">审核</a>
    {{# }else if(d.auditStatus == 1 ){ }}
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="status">冻结</a>
    {{# }else if(d.auditStatus == 2 ){ }}
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="status">重新审核</a>
    {{# }  }}
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="update">更新</a>
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
    {{# if(d.auditStatus === 0 ){ }}
    <span style="color: red;">未审核</span>
    {{# }else if(d.auditStatus === 1 ){ }}
    <span style="color: #74ff66;">审核通过</span>
    {{# }else if (d.auditStatus === 2 ) { }}
    <span style="color: #4590ff;">审核未通过</span>
    {{# } }}
</script>

<#--格式化LOGO图片-->
<script type="text/html" id="sdSchoolLogo">
    {{# if(d.schoolLoge == '' || d.schoolLoge == null){ }}
        <span style="color: red;">暂无图片</span>
    {{# }else{ }}
        <div><a class="" href="{{ d.schoolLoge }}"  alt="{{ d.schoolLoge }}"><img src="{{ d.schoolLoge }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
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