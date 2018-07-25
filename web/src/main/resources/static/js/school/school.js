layui.use(['table', 'element', 'form'], function () {
    var table = layui.table,
        element = layui.element,
        form = layui.form;
    var $ = layui.$;

    /**
     * 学校添加弹出
     */
    $("#add").click(function () {
        layer.open({
            type: 1,
            title: '添加学校',
            shadeClose: true,
            maxmin: true,
            area: ['900px', '450px'],
            content: $('#addDiv'),
            success:function () {
                axios.post('/schoolType/list').then(function (response) {
                    if(response.data.code == 0){
                        var data = response.data.data;
                        for(var i=0;i<data.length;i++){
                            $('#schoolTypeid').append("<option value="+data[i].id+">"+data[i].name+"</option>");
                        }
                        form.render();
                    }
                }).catch(function (error) {
                    layer.msg(error,{icon:5});
                });
            }
        });
    });

    tableData(null,$(".xinkai_frist").val());

    element.on('tab(docDemoTabBrief)', function(data){
        tableData(null,this.textContent);
    });

    function tableData(id,name){
        table.render({
            elem: '#xinkai'
            , url: '/sdSchool/pager'
            , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , method: 'post'
            , dataType: 'json'
            , where: {id:id,name:name}
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
                , {field: 'schoolName', title: '名称', align: 'center',width:170}
                , {field: 'detailedAddress', title: '地址', align: 'center',width:320}
                , {field: 'schoolLoge', title: 'LOGO',width:160, align: 'center',templet:'#sdSchoolLogo'}
                , {field: 'schoolCover', title: '封面',width:160, align: 'center',templet:'#sdSchoolCover'}
                , {field: 'schoolTypeName', title: '类型', align: 'center'}
                , {field: 'schoolAbout', title: '简介', align: 'center'}
                , {field: 'schoolCreattime', title: '创建时间', align: 'center',width:120}
                , {field: 'auditStatus', title: '状态', align: 'center',templet:'#sdSchoolStatus'}
                , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
            ]]
            , id: 'idTest'
            , page: true
            ,done: function(res, curr, count){
                if(!$(".layui-table").is("tz-gallery")){
                    $(".layui-table").addClass("tz-gallery")
                }

                baguetteBox.run('.tz-gallery');

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
                    layer.close(index);
                    layer.msg("删除成功", {icon: 6});
                }
            });
        } else if (obj.event === 'query') {
            layer.msg("查看用户");
        }
    });

    $("#open_BaiDuMap").click(function () {
        layer.open({
            type: 2,
            title: "百度地图",
            area: ['1000px', '690px'],
            fixed: false, //不固定
            maxmin: true,
            content: 'https://map.baidu.com/'
        });
    })

    //监听提交
    form.on('submit(formDemo)',function(data){
        axios.post('/sdSchool/save',Qs.stringify(data.field)).then(function (response) {
            if(response.data.code == 0){
                layer.closeAll();
                layer.msg(response.data.message,{icon:6});
                return $("#reset").click();
            }
            layer.msg(response.data.message,{icon:5});
        }).catch(function (error) {
            layer.msg(error,{icon:5});
        });
        return false;
    });

});