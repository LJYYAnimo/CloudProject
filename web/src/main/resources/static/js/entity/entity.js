layui.use(['table','upload','element'], function(){
    var table = layui.table,
        element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
    var $ = layui.$;


    element.on('tab(docDemoTabBrief)', function(data){
        // tableData(null,this.textContent);


    });


    table.render({
        elem: '#xinkai'
        ,url: '/entity/pager'
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
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: '序号', type: 'numbers'}
            , {field: 'entityName', title: '物品名称', align: 'center'}
            , {field: 'userName', title: '物品上传者', align: 'center'}
            , {field: 'theIntegral', title: '所需积分', align: 'center'}
            , {field: 'entityNum', title: '实物数量', align: 'center'}
            , {field: 'entityIntro', title: '简介', align: 'center'}
            , {field: 'openOrNot', title: '物品状态', align: 'center',templet: '#Status'}
            , {field: 'entityCover', width: 170, title: '实物封面', align: 'center', templet: '#entityCoverImg'}
            , {field: 'entityStartTime', title: '实物兑换开始时间', align: 'center'}
            , {field: 'entityOverTime', title: '实物兑换结束时间', align: 'center'}
            , {field: 'creatTime', title: '创建时间', align: 'center'}
            , {field: 'caozuo', width: 250, title: '操作', toolbar: '#barDemo', fixed: 'right'}
        ]]
        , id: 'idTest'
        , page: true,
        done: function (res, curr, count) {
            if (!$(".layui-table").is("tz-gallery")) {
                $(".layui-table").addClass("tz-gallery")
            }

            baguetteBox.run('.tz-gallery');

        }
    });





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
            content: '/admin/entity/addUpdateEntity',
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

    $("#addNews").click(function () {
        openNews("","添加物品");
    });

    //监听工具条
    table.on('tool(demo)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                ,btn: ['删除', '取消']
                ,yes: function(index){
                    layer.close(index);
                    axios.post('/entity/deletEntity', Qs.stringify(data)).then(function (response) {
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
                    title: '实物详情',
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    resize:false,
                    move: false,
                    area: ['65%',"60%"],
                    content: '/admin/entity/article',
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
            openNews(data,"更新实物");
        }else if(obj.event === 'status'){
            if(data.openOrNot ===0){
                data.openOrNot=1;
            }else if(data.openOrNot ===1){
                data.openOrNot=0;
            }
            axios.post('/entity/updateStatus', Qs.stringify(data)).then(function (response) {
                reloads();
                parent.layer.msg(response.data.message, {
                    time: 1000, icon:response.data.code==0?6:5
                });
            }).catch(function (error) {
                layer.msg(error);
            });

        }
    });

});