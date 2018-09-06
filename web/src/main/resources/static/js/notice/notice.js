layui.use(['table','upload','form'], function(){
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;

    table.render({
        elem: '#xinkai'
        ,url: '/notice/pager'
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
            ,{field:'title', title:'标题',align: 'center'}
            ,{field:'editor', title:'编辑人',align: 'center'}
            ,{field:'dept', title:'来源',align: 'center'}
            ,{field:'author', title:'作者',align: 'center'}
            // ,{field:'shooter', title:'摄影',align: 'center'}
            ,{field:'createTime', title:'创建时间',align: 'center'}
            ,{field:'updateTime', title:'更新时间',align: 'center'}
            ,{field:'titleImg',width:170, title:'标题封面',align: 'center',templet:'<div><a class="" href="{{ d.titleImg }}"  alt="{{ d.titleImg }}">' +
            '<img src="{{ d.titleImg }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>'}
            ,{field:'about', title:'关于',align: 'center'}
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
                ,editor: $("#editor").val()
                ,author: $('#author').val()
                ,dept: $("#dept").val()
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
            content: '/notice/addUpdateNotice',
            success: function (layero, index) {
                // 向子页面传递参数
                var iframe = window['layui-layer-iframe' + index];
                iframe.child(data);
            },end:function(index){
                // reloads();
            }
        });
    }

    $("#add").click(function () {
        openNews("","添加公告");
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
                    axios.post('/notice/deletNotice', Qs.stringify(data)).then(function (response) {
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
                    title: '公告详情',
                    area: ['70%', '730px'],
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    content: '/notice/article',
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
            openNews(data,"更新公告");
        }
    });

});