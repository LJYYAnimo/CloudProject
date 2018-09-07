<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/xiangcecss/css/baguetteBox.min.css" media="all"/>
</head>
<body style="padding-top: 20px">
<fieldset class="layui-elem-field site-demo-button">
    <legend>用户管理</legend>
    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <input type="button" class="layui-btn" id="add" value="添加用户">
            </div>

            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="userName" name="userName" autocomplete="off" class="layui-input"
                           placeholder="请输入账号">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="email" name="email" autocomplete="off" class="layui-input"
                           placeholder="请输入邮箱">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="phone" name="phone" autocomplete="off" class="layui-input"
                           placeholder="请输入手机号码">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="realName" name="realName" autocomplete="off" class="layui-input"
                           placeholder="请输入需要查找的姓名">
                </div>
            </div>
            <div class="layui-inline">
                <select name="sex" id="sex">
                    <option value="">性别</option>
                    <option value="0">女</option>
                    <option value="1">男</option>
                </select>
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="search">搜索</button>
            <button type="reset" class="layui-btn layui-btn-primary cz">重置</button>
            <!--<button class="layui-btn" data-type="exportExcel">导出Excel</button>-->
        </div>
    </form>
</fieldset>
<div id="roleDiv" style="display: none">
    <form class="layui-form">
<div class="layui-form-item">
    <label class="layui-form-label">角色</label>
    <div class="layui-input-block">
        <select name="rid" id="role" lay-verify="required">
            <option value=""></option>
        </select>
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</div>
    </form>
</div>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title" id="">
    <#list userTypeList as item>
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

<#list userTypeList as item>
    <input hidden class="xinkai_frist" value="${item.name}">
    <#break>
</#list>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn layui-btn-xs" lay-event="details">详情</a>
     <@shiro.hasPermission name="role:chongzhi">
             <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="reset">重置密码</a>
     </@shiro.hasPermission>
    <@shiro.hasPermission name="role:fenpei">
	    <a class="layui-btn layui-btn layui-btn-xs" lay-event="allot">分配权限</a>
    </@shiro.hasPermission>
</script>

<script src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/js/public.js"></script>
<script src="/js/axios.min.js"></script>
<script src="/js/qs.js"></script>
<script src="/js/user/user.js"></script>
</body>
<#--格式化性别-->
<script type="text/html" id="userGender">
    {{# if(d.sex == 0){ }}
    女
    {{# }else if(d.sex == 1){ }}
    男
    {{# } }}
</script>
</html>