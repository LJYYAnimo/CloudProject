<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>省</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>

</head>
<body style="padding-top: 20px">
<fieldset class="layui-elem-field site-demo-button" >
    <legend>作品管理</legend>

        <form class="layui-form">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <input type="button" class="layui-btn" id="add" value="添加软件">
                </div>

                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <input type="text" id="softwareName" name="softwareName" autocomplete="off" class="layui-input" placeholder="输入内容">
                    </div>
                </div>
                <div class="layui-inline">
                    <select name="softwareAudit" id="softwareAudit" >
                        <option value="">请选择审核状态</option>
                        <option value="1">未审核</option>
                        <option value="2">审核通过</option>
                        <option value="3">审核不通过</option>
                    </select>
                </div>
                <div class="layui-inline">
                    <select name="softwareModel" id="softwareModel" >
                        <option value="">选择软件类型</option>
                        <option value="收费">收费</option>
                        <option value="免费">免费</option>
                    </select>
                </div>
                <button class="layui-btn" lay-submit="" lay-filter="search">搜索</button>
                <button type="reset" class="layui-btn layui-btn-primary cz">重置</button>
                <!--<button class="layui-btn" data-type="exportExcel">导出Excel</button>-->
            </div>
        </form>

</fieldset>
<table id="xinkai"  lay-filter="demo"></table>
<#--学校类型添加-->
<div id="addDiv" style="display: none;padding-top: 20px">
    <form id="schoolType" class="layui-form">
        <input type="hidden" id="id" name="id" />
        <div class="layui-form-item layui-col-xs10 layui-col-sm12 layui-col-md11 ">
            <label class="layui-form-label " style="width: 120px" id="statustext">审核不通过原因</label>
            <div class="layui-col-xs8">
                <textarea name="auditUnreason" id="auditUnreason"  placeholder="请输入内容"  class="layui-textarea"></textarea>
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
    {{# if(d.softwareAudit == 1 ){ }}
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="status">审核</a>
    {{# }else if(d.softwareAudit == 2 ){ }}
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="status">冻结</a>
    {{# }else if(d.softwareAudit == 3 ){ }}
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="status">重新审核</a>
    {{# }  }}
    <a class="layui-btn layui-btn-xs" lay-event="query">查看详情</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="update">更新</a>
</script>


<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/xiangcecss/js/baguetteBox.min.js"></script>
<script src="/js/software/software.js"></script>
</body>
<#--格式化LOGO图片-->
<script type="text/html" id="imgURL">
    {{# if(d.softwareImg == '' || d.softwareImg == null){ }}
    <span style="color: red;">暂无图片</span>
    {{# }else{ }}
    <div><a class="" href="{{d.softwareImg}}"  alt="{{ d.softwareImg }}"><img src="{{ d.softwareImg }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>
    {{# } }}
</script>
<script type="text/html" id="software32">
    {{# if(d.software32 == '' || d.software32 == null ){ }}
    <span style="color: red;">暂无附件</span>
    {{# }else{ }}
    <a class="layui-btn layui-btn-normal layui-btn-xs"   href="{{d.software32}}"  alt="{{ d.software32 }}">下载附件</a>
    {{# } }}
</script>
<script type="text/html" id="software64">
    {{# if(d.software64 == '' || d.software64 == null ){ }}
    <span style="color: red;">暂无附件</span>
    {{# }else{ }}
    <a class="layui-btn layui-btn-normal layui-btn-xs"   href="{{d.software64}}"  alt="{{ d.software64 }}">下载附件</a>
    {{# } }}
</script>
<script type="text/html" id="status">
    {{# if(d.softwareAudit === 1 ){ }}
    <span style="color: red;">未审核</span>
    {{# }else if(d.softwareAudit === 2 ){ }}
    <span style="color: #74ff66;">审核通过</span>
    {{# }else if (d.softwareAudit === 3 ) { }}
    <span style="color: #4590ff;">审核未通过</span>
    {{# } }}
</script>
</html>