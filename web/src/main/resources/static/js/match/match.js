layui.use(['table','upload','form','laydate','element','layedit'], function(){
    var table = layui.table,
        upload = layui.upload,
        laydate = layui.laydate,
        form = layui.form;
    var $ = layui.$;
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/match/adduploadImg' //富文本插入图片时的接口
            ,type: 'post' //默认post
        }
    });


    table.render({
        elem: '#xinkai'
        ,url: '/match/pager'
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
            ,{field:'title', title:'大赛标题',align: 'center'}
            ,{field:'startTime', title:'开始时间',align: 'center'}
            ,{field:'endTime', title:'结束时间',align: 'center'}
            ,{field:'notice', title:'比赛通知',align: 'center'}
            ,{field:'commend', title:'比赛表彰',align: 'center'}
            ,{field:'createTime', title:'创建时间',align: 'center'}
            ,{field:'updateTime', title:'更新时间',align: 'center'}
            // ,{field:'titleImg',width:170, title:'标题封面',align: 'center',templet:'<div><a class="" href="{{ d.titleImg }}"  alt="{{ d.titleImg }}">' +
            // '<img src="{{ d.titleImg }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>'}
            ,{field:'matchAbout', title:'参赛简介',align: 'center'}
            ,{field:'matchBonus', title:'比赛奖金',align: 'center'}
            ,{field:'matchType', title:'比赛类型',align: 'center'}
            ,{field:'matcherCount', title:'参赛人数',align: 'center'}
            ,{field:'caozuo',width:200,title: '操作',toolbar: '#barDemo',fixed: 'right'}
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


    function reloads() {
        table.reload('idTest', {
            page: {
                curr: 1
            }
        });
    }

    //监听提交
    form.on('submit(addMatche)', function (data) {
        // layedit.getContent(index1)
        // layedit.getContent(index2)
        // layedit.getContent(index3)
        console.log(data);
        axios.post('/match/addMatch', Qs.stringify(data.field)).then(function (response) {
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

    function openNews(data,title) {
        layer.open({
            type: 1,
            title: '添加比赛',
            shadeClose: true,
            area: ['900px', '650px'],
            content: $('#Setting')
            ,success: function(layero, index){  //层弹出后的成功回调方法
                //开始时间选择器
                var index1 = layedit.build('demo1',{ height: 350,with:750 }); //建立编辑器
                var index2 = layedit.build('demo2',{ height: 350,with:750 }); //建立编辑器
                var index3 = layedit.build('demo3',{ height: 350,with:750 }); //建立编辑器
                laydate.render({
                    elem: '#startTime'
                    ,calendar: 'true'
                    ,done: function(value, date){
                        console.log(value)
                    }
                });
                //结束时间选择器
                laydate.render({
                    elem: '#endTime'
                    ,calendar: 'true'
                    ,done: function(value, date){
                        console.log(value)
                    }
                });
            }
        });


    }

    $("#add").click(function () {
        openNews("","添加比赛");
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
                    axios.post('/news/deletNew', Qs.stringify(data)).then(function (response) {
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
                    title: '资讯详情',
                    area: ['1000px', '730px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '/news/article',
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
            openNews(data,"更新资讯");
        }
    });

});