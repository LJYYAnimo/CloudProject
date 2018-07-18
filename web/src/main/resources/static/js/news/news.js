layui.use(['table','upload','form'], function(){
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;

    table.render({
        elem: '#xinkai'
        ,url: '/news/pager'
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
            ,{field:'title', title:'资讯名称',align: 'center'}
            ,{field:'dept', title:'来源',align: 'center'}
            ,{field:'author', title:'通讯员',align: 'center'}
            ,{field:'shooter', title:'摄影',align: 'center'}
            ,{field:'editor', title:'作者',align: 'center'}
            ,{field:'createTime', title:'创建时间',align: 'center'}
            ,{field:'updateTime', title:'更新时间',align: 'center'}
            ,{field:'titleImg', title:'标题封面',align: 'center',templet:'<div><a class="" href="{{ d.titleImg }}"  alt="{{ d.titleImg }}">' +
            '<img src="{{ d.titleImg }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>'}
            ,{field:'about', title:'简介',align: 'center'}
            ,{field:'caozuo',width:150,title: '操作',toolbar: '#barDemo',fixed: 'right'}
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

    $("#addNews").click(function () {
        layer.open({
            type: 2,
            title:'添加资讯',
            area: ['1000px', '730px'],
            fixed: false, //不固定
            maxmin: true,
            content: '/news/addUpdateNews'
        });
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
                        return layer.msg(response.data.message,{icon:6});
                    }).catch(function (error) {
                        layer.msg(error);
                    });

                }
            });
        }else if(obj.event === 'query'){
            layer.msg("查看区域");
        }
    });

});