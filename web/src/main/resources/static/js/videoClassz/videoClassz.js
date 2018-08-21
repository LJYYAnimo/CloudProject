layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;


    table.render({
        elem: '#xinkai'
        , url: '/videoClassz/pager'
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , method: 'post'
        , dataType: 'json'
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
            , {field: 'name', title: '类型', align: 'center',edit: 'text'}
            , {field: 'status', title: '状态', align: 'center',templet: '#Status'}
            , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
        ]]
        , id: 'idTest'
        , page: true
    });

    //监听单元格编辑
    table.on('edit(demo)', function(obj){
        $.ajax({
            url: "/videoClassz/update",
            data: obj.data,
            type: "POST",
            dataType: "json",
            success: function (response) {
                if(response.code == 0){
                    layer.msg(response.message,{icon:6});
                    table.reload("idTest");
                }else {
                    layer.msg(response.message,{icon:5});
                }
            },error:function (response) {
                layer.msg('接口请求异常',{icon: 5})
            }
        });
    });

    function openAddUpdate(title) {
        layer.open({
            type: 1,
            title:title ,
            shadeClose: true,
            area: ['380px', '175px'],
            content: $('#addDiv')
        });
    }

    var url;

    $("#add").click(function () {
        url ='/videoClassz/save';
        openAddUpdate('作品类型添加');
    });

    //监听提交
    form.on('submit(schoolTypeAdd)', function (data) {
        axios.post(url, Qs.stringify(data.field)).then(function (response) {
            if (response.data.code == 0) {
                layer.closeAll();
                layer.msg(response.data.message, {icon: 6});
                $('#reset').click();
                return table.reload("idTest");
            }
            layer.msg(response.data.message, {icon: 5});
        }).catch(function (error) {
            layer.msg(error);
        });
        return false;
    });

    function reloads() {
        table.reload('idTest', {
            page: {
                curr: 1
            }
        });
    }

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                , btn: ['删除', '取消']
                , yes: function (index) {
                    axios.post('/videoClassz/delete', Qs.stringify(data)).then(function (response) {
                        if (response.data.code == 0) {
                            layer.close(index);
                            layer.msg(response.data.message, {icon: 6});
                            reloads();
                        }
                        layer.msg(response.data.message, {icon: 5});
                    }).catch(function (error) {
                        layer.msg(error);
                    });
                }
            });
        }else if(obj.event === 'status'){
            if(data.status ===0){
                data.status=1;
            }else if(data.status ===1){
                data.status=0;
            }
            axios.post('/videoClassz/updateStatus', Qs.stringify(data)).then(function (response) {
                reloads();
                return response.data.message==0?layer.msg(response.data.message,{icon:5}):layer.msg(response.data.message,{icon:6});
            }).catch(function (error) {
                layer.msg(error);
            });

        }
    });

});