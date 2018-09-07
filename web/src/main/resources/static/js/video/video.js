

layui.use(['table','upload','form'], function(){
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;
    var classzIdList;
    table.render({
        elem: '#xinkai'
        ,url: '/video/pager'
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
            ,{field:'classzName', title:'类型',align: 'center'}
            ,{field:'synopsis', title:'简介',align: 'center'}
            ,{field:'upDate', title:'上传时间',align: 'center'}
            ,{field:'dcount', title:'下载次数',align: 'center'}
            ,{field:'watchcount', title:'观看次数',align: 'center'}
            ,{field:'videoFormat', title:'视频格式',align: 'center'}
            ,{field:'size', title:'视频大小',align: 'center'}
            ,{field:'videoPath',width:200, title:'预览视频',align: 'center',templet:'#videoPath', event: 'queryVideo'}
            ,{field:'imgPath',width:170, title:'封面',align: 'center',templet:'#imgURL'}
            ,{field:'userName', title:'上传者',align: 'center'}
            ,{field:'ischecked', title:'审核状态',align: 'center',templet:'#status'}
            ,{field:'checkDate', title:'审核时间',align: 'center'}
            ,{field:'notDes', title:'审核不通过原因',align: 'center'}
            ,{field:'videoLike', title:'点赞数',align: 'center'}
            ,{field:'dcount', title:'下载次数',align: 'center'}
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
                ,userName: $("#userName").val()
                ,ischecked: $('#ischecked').val()
                ,classz: $("#classz").val()
            }
        });
    }

    $.ajax({
        url: "/videoClassz/pager",
        data: {"page":1,"limit":100},
        type: "POST",
        dataType: "json",
        success: function (response) {
            classzIdList =response.rows;
            for (var i=0;i<response.rows.length;i++){

                $('#classzId').append("<option value="+response.rows[i].id+">"+response.rows[i].name+"</option>");

            }
            form.render();
        },error:function (response) {
            alert("接口请求异常")
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
            content: '/video/addUpdateVideo',
            success: function (layero, index) {
                height = index;
                // 向子页面传递参数
                var iframe = window['layui-layer-iframe' + index];
                data.classzIdList = classzIdList;
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
        var text =$("#notDes").val();
        if(text<=2){
            layer.close(index);
            return layer.msg("请输入原因", {icon: 5});
        }
        statusform(data,3);
        return false;
    });

    function statusform(data,stats) {
        data.field.ischecked=stats;
        axios.post('/video/updateStatus', Qs.stringify(data.field)).then(function (response) {
            layer.closeAll();
            layer.msg(response.data.message, {icon:response.data.code == 0?6:5});
            $('#reset').click();
            layer.close(index);
            return table.reload("idTest");
        }).catch(function (error) {
            layer.msg(error);
        });

    }

    $("#add").click(function () {
        var data={};
        openNews(data,"添加视频");
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
                    axios.post('/video/deletVideo', Qs.stringify(data)).then(function (response) {
                        reloads();
                        return layer.msg(response.data.message,{icon:response.data.code==0?6:5});
                    }).catch(function (error) {
                        layer.msg(error);
                    });
                }
            });
        }else if(obj.event === 'query'){
            var height;
            if(data!=null&&data!=undefined){
                layer.open({
                    type: 2,
                    title: '教学视频详情',
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    resize:false,
                    move: false,
                    area: ['65%',"60%"],
                    content: '/video/article',
                    success: function (layero, index) {
                        height =index;
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
            console.log(data);
            openNews(data,"更新视频");
        }else if(obj.event === 'queryVideo'){
            var height = index;
            layer.open({
                type: 2,
                title: '预览效果',
                fixed: false, //不固定
                maxmin: true,
                shadeClose: true,
                resize:false,
                move: false,
                area: ['65%',"60%"],
                content: '/video/PreviewVideo',
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
            if(data.ischecked==2){
                $("#statustext").html("冻结原因");
                $("#statusYse").addClass("layui-hide");
                $("#statusNo").val("冻结");
            }else if(data.ischecked==3){
                $("#statustext").html("审核不通过原因");
                $("#statusYse").removeClass("layui-hide");
                $("#statusNo").val("不通过");
            }
        }
    });

});