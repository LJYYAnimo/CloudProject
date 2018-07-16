layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;


    table.render({
        elem: '#xinkai'
        , url: '/schoolType/pager'
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , contentType: "application/json"
        , method: 'post'
        , response: {
            statusName: 'code' //数据状态的字段名称，默认：code
            , statusCode: 200 //成功的状态码，默认：0
            , msgName: 'msg' //状态信息的字段名称，默认：msg
            , countName: 'total' //数据总数的字段名称，默认：count
            , dataName: 'rows' //数据列表的字段名称，默认：data
        }
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: '序号', type: 'numbers'}
            , {field: 'name', title: '类型', align: 'center'}
            , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
        ]]
        , id: 'idTest'
        , page: true
    });

    $("#add").click(function () {
        layer.open({
            type: 1,
            title: '学校类型添加',
            shadeClose: true,
            area: ['380px', '175px'],
            content: $('#addDiv')
        });
    });
    //监听提交
    form.on('submit(schoolTypeAdd)', function (data) {
        $.ajax({
            url: "/schoolType/save",
            data: JSON.stringify(data.field),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (response) {
                if (response.code == 0) {
                    layer.closeAll();
                    layer.msg(response.message, {icon: 6});
                    $('#reset').click();
                    return table.reload("idTest");
                }
                layer.msg(response.message, {icon: 5});
            }, error: function (response) {
                layer.msg("接口请求异常", {icon: 5})
            }
        });
        return false;
    });

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                , btn: ['删除', '取消']
                , yes: function (index) {
                    $.ajax({
                        url: "/schoolType/delete",
                        data: JSON.stringify(data),
                        type: "POST",
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function (response) {
                            if (response.code == 0) {
                                layer.close(index);
                                layer.msg(response.message, {icon: 6});
                                return table.reload("idTest");
                            }
                            layer.msg(response.message, {icon: 5});
                        }, error: function (response) {
                            layer.msg("接口请求异常", {icon: 5})
                        }
                    });
                }
            });
        } else if (obj.event === 'query') {
            layer.open({
                type: 2,
                title: '所有学校',
                area: ['1165px', '475px'],
                fixed: false, //不固定
                maxmin: true,
                content: '/school/page',
                success: function (layero, index) {
                    // 向子页面传递参数
                    var iframe = window['layui-layer-iframe' + index];
                    iframe.child(obj.data);
                }
            });
        }
    });

});