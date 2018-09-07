layui.use(['table', 'element', 'form','upload'], function () {
    var table = layui.table,
        element = layui.element,
        upload = layui.upload,
        upload1 = layui.upload,
        form = layui.form;
    var $ = layui.$;
    var path= null;


    function reloads() {
        table.reload('idTest', {
            page: {
                curr: 1
            }
        });
    }

    var name =$(".xinkai_frist").val();
    tableData(null,name);

    element.on('tab(docDemoTabBrief)', function(data){
        name =this.textContent;
        tableData(null,name);
    });


    function tableData(id,name){
        table.render({
            elem: '#xinkai'
            , url: '/sdSchool/pager'
            , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , method: 'post'
            , dataType: 'json'
            , where: {id:id,
                name:name,
                schoolName: $("#schoolName").val()
                ,auditStatus: $("#auditStatus").val()
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
                , {field: 'schoolName', title: '名称', align: 'center',width:170}
                , {field: 'detailedAddress', title: '地址', align: 'center',width:320}
                , {field: 'schoolLoge', title: 'LOGO',width:160, align: 'center',templet:'#sdSchoolLogo'}
                , {field: 'schoolCover', title: '封面',width:160, align: 'center',templet:'#sdSchoolCover'}
                , {field: 'schoolTypeName', title: '类型', align: 'center'}
                , {field: 'schoolAbout', title: '简介', align: 'center'}
                , {field: 'schoolCreattime', title: '创建时间', align: 'center',width:120}
                , {field: 'auditStatus', title: '状态', align: 'center',templet:'#sdSchoolStatus'}
                , {field: 'scDes', title: '审核未通过原因', align: 'center'}
                , {field: 'caozuo', width: 200, title: '操作', toolbar: '#barDemo', fixed: 'right'}
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
                schoolName: $("#schoolName").val()
                ,auditStatus: $("#auditStatus").val()
                ,name: name
            }
        });
    }

    /**
     * 学校添加弹出
     */
    $("#add").click(function () {
        path= '/sdSchool/save';
        $('#reset').click();
        fileLogo=null;
        fileImg=null;
        updateAdd();
    });

    function updateAdd(datas) {
        layer.open({
            type: 1,
            title: '添加学校',
            fixed: false, //不固定
            maxmin: true,
            shadeClose: true,
            resize:false,
            move: false,
            area: ['65%',"60%"],
            content: $('#addDiv'),
            success: function () {
                axios.post('/schoolType/list').then(function (response) {
                    if (response.data.code == 0) {
                        var data = response.data.data;
                        for (var i = 0; i < data.length; i++) {
                            $('#schoolTypeid').append("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                        }
                        $('#schoolTypeid').val(datas.schoolTypeid);
                        form.render();
                    }
                }).catch(function (error) {
                    layer.msg(error, {icon: 5});
                });
            },full:function () {
                // 向子页面传递参数
                $('.layui-layer-content').css({"height":$(window).height()*0.9});
            },restore :function () {
                $('.layui-layer-content').css({"height":$(window).height()*0.52});
            }
        });
    }

    //监听提交
    form.on('submit(statusYse)', function (data) {
        statusform(data,1);
        return false;
    });

    form.on('submit(statusNo)', function (data) {

        var text =$("#scDes").val();
        if(text<=2){
            return layer.msg("请输入原因", {icon: 5});
        }
        statusform(data,2);
        return false;
    });

    function statusform(data,stats) {
        data.field.auditStatus=stats;
        axios.post('/sdSchool/updateStatus', Qs.stringify(data.field)).then(function (response) {
            layer.closeAll();
            layer.msg(response.data.message,{icon:response.data.code == 0?6:5});
            $('#reset').click();
            reloads();
        }).catch(function (error) {
            layer.msg(error);
        });

    }

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                ,btn: ['删除', '取消']
                ,yes: function(index){
                    layer.close(index);
                    axios.post('/sdSchool/deletSchool', Qs.stringify(data)).then(function (response) {
                        reloads();
                        return layer.msg(response.data.message,{icon:response.data.code==0?6:5});
                    }).catch(function (error) {
                        layer.msg(error);
                    });
                }
            });
        } else if (obj.event === 'query') {
            layer.msg("查看用户");
        }else if(obj.event === 'update'){
            path= '/sdSchool/updateSchool';
            updateAdd(data);
            form.val('Form',{
                "id":data.id,
                "schoolName":data.schoolName,
                "detailedAddress":data.detailedAddress,
                "deletLoge":data.schoolLoge,
                "deletImg":data.schoolCover,
                "schoolAbout":data.schoolAbout
            });
            $('#imgs').attr('src',data.schoolLoge);
            $('#imgs1').attr('src',data.schoolCover);
        }else if(obj.event === 'status'){
            layer.open({
                type: 1,
                title: '审核',
                shadeClose: true,
                area: ['520px', '275px'],
                content: $('#StatusDiv')
            });
            $("#id").val(data.id);
            if(data.auditStatus==1){
                $("#statustext").html("冻结原因");
                $("#statusYse").addClass("layui-hide");
                $("#statusNo").val("冻结");
            }else if(data.auditStatus==2){
                $("#statustext").html("审核不通过原因");
                $("#statusYse").removeClass("layui-hide");
                $("#statusNo").val("不通过");
            }
        }
    });

    var fileLogo,fileImg;
    upload.render({
        elem: '#uploadImg'
        ,url: ""
        ,auto: false
        ,size: 5120
        ,title: '只能上传jpg,png,jpeg后缀的文件'
        ,field:'fileLogo' //后台接收默认字段名
        //,multiple: true
        ,acceptMime: 'image/jpg, image/png,image/jpeg'
        ,ext: 'jpg|png|jpeg'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列

            var files = obj.pushFile();
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                $('#imgs').attr('src', result); //图片链接（base64
                fileLogo=file;

            });
        }
        ,before: function(obj){


        },done: function(res, indexs, upload){ //上传后的回调

        }
        ,error: function(index, upload){
            layer.msg("上传失败");
        }
    });
    upload.render({
        elem: '#uploadImg1'
        ,url: ""
        ,auto: false
        ,size: 5120
        ,title: '只能上传jpg,png,jpeg后缀的文件'
        ,field:'fileImg' //后台接收默认字段名
        //,multiple: true
        ,acceptMime: 'image/jpg, image/png,image/jpeg'
        ,ext: 'jpg|png|jpeg'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列

            var files = obj.pushFile();
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                $('#imgs1').attr('src', result); //图片链接（base64
                fileImg=file;

            });
        }
        ,before: function(obj){


        },done: function(res, indexs, upload){ //上传后的回调

        }
        ,error: function(index, upload){
            layer.msg("上传失败");
        }
    });

    $("#open_BaiDuMap").click(function () {
        layer.open({
            type: 2,
            title: "百度地图",
            area: ['70%', '690px'],
            fixed: false, //不固定
            maxmin: true,
            content: 'https://map.baidu.com/'
        });
    })

    //监听提交
    form.on('submit(formDemo)',function(data){
        var datas = data.field;
        var formdata1=new FormData();// 创建form对象
        formdata1.append('id',datas.id);
        formdata1.append('schoolTypeid',datas.schoolTypeid);
        formdata1.append('schoolName',datas.schoolName);
        formdata1.append('detailedAddress',datas.detailedAddress);
        formdata1.append('schoolAbout',datas.schoolAbout);
        formdata1.append('deletImg',datas.deletImg);
        formdata1.append('deletLoge',datas.deletLoge);
        if(fileLogo!=null&&fileLogo!=undefined){
            formdata1.append('fileLogo',fileLogo,fileLogo.name);
        }
        if(fileImg!=null&&fileImg!=undefined){
            formdata1.append('fileImg',fileImg,fileImg.name);
        }
        axios.post(path,formdata1).then(function (response) {
            layer.closeAll();
            layer.msg(response.data.message,{icon:response.data.code == 0?6:5});
            fileLogo=null;
            fileImg=null;
            $('#reset').click();
            reloads();
        }).catch(function (error) {
            layer.msg(error,{icon:5});
        });
        return false;
    });

});