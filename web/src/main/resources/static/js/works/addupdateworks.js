
var value;

function child(d) {
    value = null;
    if (d != null) {
        value = d;
    }
}

function tableReload() {
    window.parent.layui.table.reload('idTest', {
        page: {
            curr: 1
        }
    });
}
setTimeout(function() {
layui.use(['table','upload','form'], function(){
    var table = layui.table,
        upload = layui.upload,
        upload1 = layui.upload,
        upload2 = layui.upload,
        form = layui.form;
    var $ = layui.$;


    var  frameindex= parent.layer.getFrameIndex(window.name);//当此页面被其他页面弹窗时，获取此页面元素

    var path ='/works/addworksupload';
    console.log(value);

    if(value!=""&&value.worksPhotoaddress!=undefined){
        var indexs= layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });

            $('#imgs').attr('src', value.worksPhotoaddress); //图片链接（base64
            form.val('newsForm',{
                "id":value.id,
                "deletImg":value.worksPhotoaddress,
                "worksTitle":value.worksTitle,
                "worksAbout":value.worksAbout,
                "deletfileStl":value.stl,
                "deletfileZIP":value.worksAddress
            });
            path ='/works/updateWorks';
            $("#worksIntegral").val(value.worksIntegral);
            $("#btnform").removeClass("layui-hide");//没有上传文件就监听并显示这个按钮
            $("#btn").addClass("layui-hide");//同时隐藏这个按钮

            var stls = value.stl.split('/');
            $('#stltext').text(stls[stls.length-1]);
            var zips = value.worksAddress.split('/');
            $('#ziptext').html(zips[zips.length-1]);
            layer.close(indexs);

    }
    if(value.worksTypeList!=undefined) {
        for (var i = 0; i < value.worksTypeList.length; i++) {

            $('#worksType').append("<option value=" + value.worksTypeList[i].id + ">" + value.worksTypeList[i].worksType + "</option>");

        }
        form.render();

        if(value.worksTypeid!=undefined){

            $('#worksType').val(value.worksTypeid);
            form.render();
        }




    }
    // $.ajax({
    //     url: "/worksType/pager",
    //     data: {"page":1,"limit":100},
    //     type: "POST",
    //     dataType: "json",
    //     success: function (response) {
    //
    //     },error:function (response) {
    //         alert("接口请求异常")
    //     }
    // });
    var fileStl =null;
    var fileZIP =null;

    $("#btnform").click(function () {//当upload.render没有被使用的时候就用这个提交表单数据

        var formdata1=new FormData();// 创建form对象
        formdata1.append('id',$("#ids").val());// 通过append向form对象添加数据,可以通过append继续添加数据
        formdata1.append('deletImg',$("#deletImg").val());
        formdata1.append('worksTitle',$("#worksTitle").val());
        formdata1.append('worksTypeid',$("#worksType").val());
        formdata1.append('worksAbout',$("#worksAbout").val());
        formdata1.append('worksIntegral',$("#worksIntegral").val());
        formdata1.append('deletfileStl',value.stl!=undefined?value.stl:null);
        formdata1.append('deletfileZIP',value.worksAddress!=undefined?value.worksAddress:null);
        formdata1.append('fileStl',fileStl,fileStl.name);
        formdata1.append('fileZIP',fileZIP,fileZIP.name);
        $("#btnform").addClass("layui-hide");//提交后就暂时隐藏按钮
        var config = {
            headers: {'Content-Type': 'multipart/form-data'}
        }
        axios.post(path, formdata1,config).then(function (response) {
            if(response.data.code==0){
                tableReload();
                parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭
                parent.layer.msg(response.data.message, {
                    time: 1000, icon:6
                });
            }else {
                parent.layer.msg(response.data.message, {
                    time: 2000, icon:5
                });
            }
        }).catch(function (error) {
            layer.msg(error);
        });
    });



    upload.render({
           elem: '#uploadImg'
           ,url: path
           ,auto: false
           ,size: 5120
           ,title: '只能上传jpg,png,jpeg后缀的文件'
           ,field:'fileImg' //后台接收默认字段名
           //,multiple: true
           ,bindAction: '#btn'
           ,acceptMime: 'image/jpg, image/png,image/jpeg'
           ,ext: 'jpg|png|jpeg'
            ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
                //将每次选择的文件追加到文件队列
            var files = obj.pushFile();
                //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
                obj.preview(function(index, file, result){
                    $('#imgs').attr('src', result); //图片链接（base64
                    $("#btn").removeClass("layui-hide");//上传了文件就监听并显示这个按钮
                    $("#btnform").addClass("layui-hide");//同时隐藏这个按钮

                });
            }
            ,before: function(obj){
                //这里是把数据跟图片一起添加到后台
                this.data = {"id":$("#ids").val()
                    ,"deletImg":$("#deletImg").val()
                    ,"worksTitle":$("#worksTitle").val(),
                    "worksTypeid":$("#worksType").val(),
                    "worksAbout":$("#worksAbout").val(),
                    "worksIntegral":$("#worksIntegral").val(),
                    "fileStl":fileStl,
                    "fileZIP":fileZIP,
                    "deletfileStl":value.stl!=undefined?value.stl:null,
                    "deletfileZIP":value.worksAddress!=undefined?value.worksAddress:null
                };
            $("#btn").addClass("layui-hide");//提交后就暂时隐藏按钮
             },done: function(res, indexs, upload){ //上传后的回调
                if(res.code==0){
                    tableReload();
                    parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭
                    parent.layer.msg(res.message, {
                        time: 1000, icon:6
                    });
                }else {
                    parent.layer.msg(res.message, {
                        time: 2000, icon:5
                    });
                }

            }
            ,error: function(index, upload){
            layer.msg("上传失败")
           }
       });

    upload1.render({
        elem: '#stl'
        ,url: path
        ,auto: false
        ,size: 51200
        ,title: '只能上传stl后缀的文件'
        ,field:'fileStl' //后台接收默认字段名
        //,multiple: test9
        ,accept: 'file '
        ,acceptMime: '.stl'
        ,exts: 'stl'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列
            var files = obj.pushFile();
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                $('#stltext').text(file.name);
                fileStl=file;
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
        }
        ,error: function(index, upload){
            layer.msg("上传失败")
        }
    });

    upload2.render({
        elem: '#worksAddress'
        ,url: path
        ,auto: false
        ,size: 71200
        ,title: '只能上传jpg,png,jpeg后缀的文件'
        ,field:'fileZIP' //后台接收默认字段名
        ,accept: 'file '
        ,acceptMime:  '.zip'
        ,exts: 'zip'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列

            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                // $("#ziptext").html(file.name)
                $('#ziptext').html(file.name);
                fileZIP=file;

            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
        }
        ,error: function(index, upload){
            layer.msg("上传失败")
        }
    });

});
},200);