

layui.use(['table','upload','form'], function(){
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;
    var typeIdList;
    table.render({
        elem: '#xinkai'
        ,url: '/software/pager'
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        // ,contentType: "application/json"
        ,method:'post'
        ,response: {
            statusName: 'code' //数据状态的字段名称，默认：code
            ,statusCode: 200 //成功的状态码，默认：0
            ,msgName: 'msg' //状态信息的字段名称，默认：msg
            ,countName: 'total' //数据总数的字段名称，默认：count
            ,dataName: 'rows' //数据列表的字段名称，默认：data
        }
        ,cols: [[
            {checkbox: true, fixed: true}
            ,{field:'id', title:'序号',type:'numbers'}
            ,{field:'softwareName', title:'软件名称',align: 'center'}
            ,{field:'softwareModel', title:'类型',align: 'center'}
            ,{field:'softwareApply', title:'适用范围',align: 'center'}
            ,{field:'software32',width:200, title:'下载地址1',align: 'center',templet:'#software32'}
            ,{field:'software64',width:200, title:'下载地址2',align: 'center',templet:'#software64'}
            ,{field:'softwareImg',width:170, title:'软件封面',align: 'center',templet:'#imgURL'}
            ,{field:'softwareAudit', title:'审核状态',align: 'center',templet:'#status'}
            ,{field:'auditTime', title:'审核时间',align: 'center'}
            ,{field:'auditUnreason', title:'审核不通过原因',align: 'center'}
            ,{field:'creatTime', title:'创建时间',align: 'center'}
            ,{field:'updateCreatTime', title:'更新时间',align: 'center'}
            ,{field:'provinceId', title:'省',align: 'center'}
            ,{field:'cityId', title:'市',align: 'center'}
            ,{field:'areaId', title:'区',align: 'center'}
            ,{field:'caozuo',width:260,title: '操作',toolbar: '#barDemo',fixed: 'right'}
        ]]
        ,id: 'idTest'
        ,page:true,
        done: function(res, curr, count){
            if(!$(".layui-table").is("tz-gallery")){
                $(".layui-table").addClass("tz-gallery")
            }

            baguetteBox.run('.tz-gallery');

        }
    });
    form.on('submit(search)', function(data){
        artSearch();
        return false;
    });
    function artSearch(){
        table.reload('idTest', {
            page: {
                curr: 1
            }
            ,where: {
                softwareName: $("#softwareName").val()
                ,softwareAudit: $("#softwareAudit").val()
                ,softwareModel: $("#softwareModel").val()
            }
        });
    }

    function reloads() {
        table.reload('idTest', {
            page: {
                curr: 1
            }
        });
    }

    function openNews(data,title) {
        layer.open({
            type: 2,
            title: title,
            area: ['70%', '730px'],
            fixed: false, //不固定
            maxmin: true,
            shadeClose: true,
            content: '/software/addUpdateSoftware',
            success: function (layero, index) {
                // 向子页面传递参数
                var iframe = window['layui-layer-iframe' + index];
                data.typeIdList = typeIdList;
                iframe.child(data);
            },end:function(index){
                // reloads();
            }
        });
    }

    //监听提交
    form.on('submit(statusYse)', function (data) {
        index = layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
        statusform(data,2);
        return false;
    });



//监听提交
    var index;
    form.on('submit(statusNo)', function (data) {
        index = layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
        //自定义验证规则
        // form.verify({
        //     noCheckedReason: function(value){
        //         if(value.length < 2){
        //             return '请输入不通过原因';
        //         }
        //     }
        // });
        var text =$("#auditUnreason").val();
        if(text<=2){
            layer.close(index);
            return layer.msg("请输入原因", {icon: 5});
        }
        statusform(data,3);
        return false;
    });

    function statusform(data,stats) {
        data.field.softwareAudit=stats;
        axios.post('/software/updateStatus', Qs.stringify(data.field)).then(function (response) {
            if (response.data.code == 0) {
                layer.closeAll();
                layer.msg(response.data.message, {icon: 6});
                $('#reset').click();
                layer.close(index);
                return table.reload("idTest");
            }
            layer.msg(response.data.message, {icon: 5});
        }).catch(function (error) {
            layer.msg(error);
        });

    }

    $("#add").click(function () {
        var data={};
        openNews(data,"添加软件");
    });
    // table.on('tool(demo)', function(obj){
    //监听工具条
    table.on('tool(demo)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                ,btn: ['删除', '取消']
                ,yes: function(index){
                    layer.close(index);
                    axios.post('/software/deletSoftware', Qs.stringify(data)).then(function (response) {
                        reloads();
                        return layer.msg(response.data.message,{icon:6});
                    }).catch(function (error) {
                        layer.msg(error);
                    });
                }
            });
        }else if(obj.event === 'query'){
            if(data!=null&&data!=undefined){
                layer.open({
                    type: 2,
                    title: '软件详情',
                    area: ['70%', '730px'],
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    content: '/software/article',
                    success: function (layero, index) {
                        // 向子页面传递参数
                        var iframe = window['layui-layer-iframe' + index];
                        iframe.child(data);
                    },end:function(index){
                        // reloads();
                    }
                });
            }

        }else if(obj.event === 'update'){
            openNews(data,"更新软件信息");
        }else if(obj.event === 'status'){
            layer.open({
                type: 1,
                title: '审核',
                shadeClose: true,
                area: ['520px', '275px'],
                content: $('#addDiv')
            });
            $("#id").val(data.id);
            if(data.softwareAudit==2){
                $("#statustext").html("冻结原因");
                $("#statusYse").addClass("layui-hide");
                $("#statusNo").val("冻结");
            }else if(data.softwareAudit==3){
                $("#statustext").html("审核不通过原因");
                $("#statusYse").removeClass("layui-hide");
                $("#statusNo").val("不通过");
            }
        }
    });

});