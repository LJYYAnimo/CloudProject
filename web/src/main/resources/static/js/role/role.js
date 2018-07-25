layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;


    $("#add").click(function () {
        layer.open({
            type: 1,
            title: '角色添加',
            shadeClose: true,
            area: ['380px', '300px'],
            content: $('#addDiv')
        });
    });

    //监听提交
    form.on('submit(role)', function (data) {
        axios.post('/role/save', Qs.stringify(data.field)).then(function (response) {
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



    table.render({
        elem: '#xinkai'
        , url: '/role/pager'
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
            , {field: 'role', title: '角色', align: 'center'}
            , {field: 'description', title: '描述', align: 'center'}
            , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
        ]]
        , id: 'idTest'
        , page: true
    });

    var setting = {
        check: {
            enable: true,
            chkboxType: {
                Y: 'ps',
                N: 'ps'
            }
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        view: {
            showIcon: false
        }
    };

    var pagerLayui = {
        page: 1,
        limit: 100
    };

    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'distribution') {
            if(data.role == '超级管理员'){
                return layer.msg('无需分配',{icon:6});
            }
            layer.open({
                type: 1,
                title: '授权',
                shadeClose: true,
                area: ['333px', '300px'],
                maxmin: true,
                content: $('#ztreeDiv'),
                btn:['授权'],
                success: function () {
                    axios.post('/permission/pager', Qs.stringify(pagerLayui)).then(function (response) {
                        $.fn.zTree.init($("#treeDemo"), setting, response.data.rows);
                        var ztree = $.fn.zTree.getZTreeObj("treeDemo");
                        axios.post('/permission/getPermission', Qs.stringify(data)).then(function (response) {
                            if(response.data.code == 0){
                                var permissionVoList = response.data.data;
                                for(var i=0;i<permissionVoList.length;i++){
                                    ztree.checkNode(ztree.getNodeByParam("id", permissionVoList[i].permission.id, null));
                                    var permissionList = permissionVoList[i].permissionList;
                                    for(var j=0;j<permissionList.length;j++){
                                        ztree.checkNode(ztree.getNodeByParam("id", permissionList[j].id, null));
                                    }
                                }
                            }
                        }).catch(function (error) {
                            layer.msg(error,{icon:5});
                        });
                    }).catch(function (error) {
                        layer.msg(error,{icon:5});
                    });
                },yes:function (index) {
                    var ztree = $.fn.zTree.getZTreeObj("treeDemo");
                     nodes=ztree.getCheckedNodes(true),
                     v="";
                     if(nodes.length == 0){
                         return layer.msg("请选择授权信息",{icon:5});
                     }
                    for(var i=0;i<nodes.length;i++){
                        if(i==nodes.length-1){
                            v+=nodes[i].id
                        }else {
                            v+=nodes[i].id + ",";
                        }
                    }
                    var permissionIdsVo = {
                        ids:v,
                        rid:data.id
                    };
                    axios.post('/permission/save', Qs.stringify(permissionIdsVo)).then(function (response) {
                            if(response.data.code == 0){
                                layer.msg(response.data.message,{icon:6});
                                return layer.close(index);
                            }
                            layer.msg(response.data.message,{icon:5});
                    }).catch(function (error) {
                            layer.msg(error,{icon:5});
                    });
                }
            });
        } else if (obj.event === 'delete') {
            if(data.role == '超级管理员'){
                return layer.msg("不可删除",{icon:5});
            }
            axios.post('/role/delete',Qs.stringify(data)).then(function (response) {
                if(response.data.code == 0){
                    table.reload("idTest");
                    return layer.msg(response.data.message,{icon:6});
                }
                layer.msg(response.data.message,{icon:5});
                }).catch(function (error) {
                    layer.msg(error,{icon:5});
                });
        }

    });


});