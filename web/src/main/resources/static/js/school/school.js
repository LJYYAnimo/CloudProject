var value;

function child(d) {
    value = null;
    if (d != null) {
        console.log(d);
        value = d;
        console.log(value);
    }
}


layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;

    table.render({
        elem: '#xinkai'
        , url: '/school/pager'
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , contentType: "application/json"
        , method: 'post'
        , where: value
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
            , {field: 'schoolName', title: '学校名称', align: 'center'}
            , {field: 'schoolAddress', title: '学校所在县', align: 'center'}
            , {field: 'schoolType', title: '学校类型', align: 'center'}
            , {field: 'creatTime', title: '添加时间', align: 'center'}
            , {field: 'area_id', title: '所在区', align: 'center'}
            , {field: 'city_id', title: '所在市', align: 'center'}
            , {field: 'directly_states', title: '是否直属', align: 'center'}
            , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
        ]]
        , id: 'idTest'
        , page: true
    });

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                , btn: ['删除', '取消']
                , yes: function (index) {
                    layer.close(index);
                    layer.msg("删除成功", {icon: 6});
                }
            });
        } else if (obj.event === 'query') {
            layer.msg("查看用户");
        }
    });

});