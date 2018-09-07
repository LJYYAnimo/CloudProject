layui.use(['table', 'element', 'form'], function () {
    var table = layui.table,
        element = layui.element,
        form = layui.form;
    var $ = layui.$;
    var value =$(".xinkai_frist").val();
    tableData(value);

    var uid;

    element.on('tab(docDemoTabBrief)', function(data){
        value = this.textContent;
        tableData(value);
    });

    axios.post('/role/list').then(function (response) {
        for (var i=0;i<response.data.data.length;i++){
            $('#role').append("<option value="+response.data.data[i].id+">"+response.data.data[i].role+"</option>");
        }
        form.render();
    }).catch(function (error) {
        layer.msg(error,{icon:5});
    });

    function tableData(value){
        table.render({
            elem: '#xinkai'
            , url: '/user/pager'
            , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , method: 'post'
            ,dataType:'json'
            ,where:{name:value,
                userName: $("#userName").val()
                ,email: $("#email").val()
                ,phone: $('#phone').val()
                ,realName: $("#realName").val()
                ,sex: $("#sex").val()
            }
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
                , {field: 'userName', title: '账号', align: 'center'}
                , {field: 'creatTime', title: '创建时间', align: 'center',width:120}
                , {field: 'email', title: '邮箱', align: 'center',width:190}
                , {field: 'grade', title: '年级', align: 'center'}
                , {field: 'phone', title: '手机号码', align: 'center',width:120}
                , {field: 'school', title: '学校', align: 'center'}
                , {field: 'sex', title: '性别', align: 'center',templet:'#userGender'}
                , {field: 'brithday', title: '生日', align: 'center',width:120}
                , {field: 'realName', title: '姓名', align: 'center'}
                , {field: 'des', title: '个性签名', align: 'center'}
                , {field: 'province', title: '省', align: 'center'}
                , {field: 'city', title: '市', align: 'center'}
                , {field: 'address', title: '区/县', align: 'center'}
                , {field: 'betterAddress', title: '详细地址', align: 'center'}
                , {field: 'caozuo', width: 250, title: '操作', toolbar: '#barDemo', fixed: 'right'}
            ]]
            , id: 'idTest'
            , page: true
        });
    }

    form.on('submit(search)', function(data){
        artSearch();
        return false;
    });
    //监听提交
    form.on('submit(formDemo)', function(data){
        var userRole = {
            rid:data.field.rid,
            uid:uid
        };
        axios.post('/user/saveRole',Qs.stringify(userRole)).then(function (response) {
            if(response.data.code == 0){
                return layer.msg(response.data.message,{icon:6});
            }
            layer.msg(response.data.message,{icon:5});
        }).catch(function (error) {
            layer.msg(error,{icon:5});
        });
        return false;
    });

    function artSearch(){
        table.reload('idTest', {
            page: {
                curr: 1
            }
            ,where: {
                userName: $("#userName").val()
                ,email: $("#email").val()
                ,phone: $('#phone').val()
                ,realName: $("#realName").val()
                ,sex: $("#sex").val()
                ,name: value
            }
        });
    }



    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'details') {
            layer.msg("详情");
        } else if (obj.event === 'reset') {
            layer.msg('确定重置？', {
                time: 0 //不自动关闭
                , btn: ['重置', '取消']
                , yes: function (index) {
                    axios.post('/user/reset',Qs.stringify(data)).then(function (response) {
                        if(response.data.code == 0){
                            layer.alert(response.data.message, {
                                skin: 'layui-layer-molv' //样式类名
                                ,closeBtn: 0
                            })
                        }else {
                            layer.msg(response.data.message,{icon:5});
                        }
                    }).catch(function (error) {
                        layer.msg(error,{icon:5});
                    });
                }
            });
        } else if(obj.event === 'allot'){
            layer.open({
                type: 1,
                title: '分配权限',
                shadeClose: true,
                area: ['50%', '50%'],
                content: $('#roleDiv')
            });
            uid = data.id
        }
    });

});