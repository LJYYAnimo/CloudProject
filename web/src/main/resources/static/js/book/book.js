

layui.use(['table','upload','form'], function(){
    var table = layui.table,
        form = layui.form;
    var $ = layui.$;
    var worksTypeList;
    table.render({
        elem: '#xinkai'
        ,url: '/book/pager'
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
            ,{field:'title', title:'书名',align: 'center'}
            ,{field:'type', title:'是否出版',align: 'center',templet:'#Type'}
            ,{field:'bookType', title:'书籍类型',align: 'center',templet:'#BookType'}
            ,{field:'des', title:'简介',align: 'center'}
            ,{field:'url', title:'下载链接',align: 'center',templet:'#urlURL'}
            ,{field:'img',width:170, title:'作品封面',align: 'center',templet:'#imgURL'}
            ,{field:'userName', title:'上传者',align: 'center'}
            ,{field:'bookAudit', title:'审核状态',align: 'center',templet:'#status'}
            ,{field:'auditTime', title:'审核时间',align: 'center'}
            ,{field:'bookUnreason', title:'审核不通过原因',align: 'center'}
            ,{field:'updateTime', title:'最近更新时间',align: 'center'}
            ,{field:'createTime', title:'创建时间',align: 'center'}
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
                title: $("#title").val()
                ,type: $("#type").val()
                ,bookType: $('#bookType').val()
                ,bookAudit: $("#bookAudit").val()
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
        var height;
        layer.open({
            type: 2,
            title: title,
            fixed: false, //不固定
            maxmin: true,
            shadeClose: true,
            resize:false,
            move: false,
            area: ['65%',"60%"],
            content: '/book/addUpdateBook',
            success: function (layero, index) {
                height = index;
                // 向子页面传递参数
                var iframe = window['layui-layer-iframe' + index];
                data.worksTypeList = worksTypeList;
                iframe.child(data);
            },end:function(index){
                // reloads();
            },full:function () {
                // 向子页面传递参数
                $('#layui-layer-iframe' + height).css({"height":$(window).height()*0.9});
            },restore :function () {
                $('#layui-layer-iframe' + height).css({"height":$(window).height()*0.53});
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
        var text =$("#bookUnreason").val();
        if(text<=2){
            layer.close(index);
            return layer.msg("请输入原因", {icon: 5});
        }
        statusform(data,3);
        return false;
    });

    function statusform(data,stats) {
        data.field.bookAudit=stats;
        axios.post('/book/updateStatus', Qs.stringify(data.field)).then(function (response) {
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
        openNews(data,"添加书籍");
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
                    axios.post('/book/deletBook', Qs.stringify(data)).then(function (response) {
                        reloads();
                        return layer.msg(response.data.message,{icon:6});
                    }).catch(function (error) {
                        layer.msg(error);
                    });
                }
            });
        }else if(obj.event === 'query'){
            if(data!=null&&data!=undefined){
                var height;
                layer.open({
                    type: 2,
                    title: '书籍详情',
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    resize:false,
                    move: false,
                    area: ['65%',"60%"],
                    content: '/book/article',
                    success: function (layero, index) {
                        height = index;
                        // 向子页面传递参数
                        var iframe = window['layui-layer-iframe' + index];
                        iframe.child(data);
                    },end:function(index){
                        // reloads();
                    },full:function () {
                        // 向子页面传递参数
                        $('#layui-layer-iframe' + height).css({"height":$(window).height()*0.9});
                    },restore :function () {
                        $('#layui-layer-iframe' + height).css({"height":$(window).height()*0.53});
                    }
                });
            }

        }else if(obj.event === 'update'){
            openNews(data,"更新书籍");
        }else if(obj.event === 'queryStl'){
            var height ;
            layer.open({
                type: 2,
                title: '预览效果',
                fixed: false, //不固定
                maxmin: true,
                shadeClose: true,
                resize:false,
                move: false,
                area: ['65%',"60%"],
                content: '/works/queryStl',
                success: function (layero, index) {
                    height = index;
                    // 向子页面传递参数
                    var iframe = window['layui-layer-iframe' + index];
                    iframe.child(data);
                },end:function(index){
                    // reloads();
                },full:function () {
                    // 向子页面传递参数
                    $('#layui-layer-iframe' + height).css({"height":$(window).height()*0.9});
                },restore :function () {
                    $('#layui-layer-iframe' + height).css({"height":$(window).height()*0.53});
                }
            });
        }else if(obj.event === 'status'){
            layer.open({
                type: 1,
                title: '审核',
                shadeClose: true,
                area: ['520px', '275px'],
                content: $('#addDiv')
            });
            $("#id").val(data.id);
            if(data.bookAudit==2){
                $("#statustext").html("冻结原因");
                $("#statusYse").addClass("layui-hide");
                $("#statusNo").val("冻结");
            }else if(data.bookAudit==3){
                $("#statustext").html("审核不通过原因");
                $("#statusYse").removeClass("layui-hide");
                $("#statusNo").val("不通过");
            }
        }
    });

});