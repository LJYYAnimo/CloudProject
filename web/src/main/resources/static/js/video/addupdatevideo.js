
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

    var path ='/video/addVideoupload';

    var indexs;
    if(value!=undefined&&value.id!= undefined&&value!=""){
        indexs= layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });

            $('#imgs').attr('src', value.imgPath); //图片链接（base64
            form.val('newsForm',{
                "id":value.id,
                "deletImg":value.imgPath,
                "title":value.title,
                "synopsis":value.synopsis,
                "deletfileVideo":value.videoPath

            });
            path ='/video/updateVideo';
            $("#btnform").removeClass("layui-hide");//没有上传文件就监听并显示这个按钮
            $("#btn").addClass("layui-hide");//同时隐藏这个按钮


            var vido = value.videoPath.split('/');
            $('#Videotext').html(vido[vido.length-1]);
            layer.close(indexs);

    }else {

    }
    if(value!=undefined&&value.classzIdList!=undefined) {
        for (var i = 0; i < value.classzIdList.length; i++) {

            $('#classzId').append("<option value=" + value.classzIdList[i].id + ">" + value.classzIdList[i].name + "</option>");

        }
        form.render();

        if(value.classzId!=undefined){

            $('#classzId').val(value.classzId);
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
    var fileVideo =null;

    $("#btnform").click(function () {//当upload.render没有被使用的时候就用这个提交表单数据
        indexs= layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
        var formdata1=new FormData();// 创建form对象
        formdata1.append('id',$("#ids").val());// 通过append向form对象添加数据,可以通过append继续添加数据
        formdata1.append('deletImg',$("#deletImg").val());
        formdata1.append('deletfileVideo',value.videoPath!=undefined?value.videoPath:null);
        formdata1.append('title',$("#title").val());
        formdata1.append('classzId',$("#classzId").val());
        formdata1.append('synopsis',$("#synopsis").val());



        if(fileVideo!=null){
            formdata1.append('fileVideo',fileVideo,fileVideo.name);
        }


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
            layer.close(indexs);
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
                    ,"deletImg":value.imgPath!=undefined?value.imgPath:null
                    ,"deletfileVideo":value.videoPath!=undefined?value.videoPath:null
                    ,"title":$("#title").val(),
                    "classzId":$("#classzId").val(),
                    "synopsis":$("#synopsis").val(),
                    "fileVideo":fileVideo
                };
            indexs= layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
            $("#btn").addClass("layui-hide");//提交后就暂时隐藏按钮
             },done: function(res, indexs, upload){ //上传后的回调
                tableReload();
                parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭
                parent.layer.msg(res.message, {
                    time: 1000, icon:res.code==0?6:5
                });
            }
            ,error: function(index, upload){
                layer.msg("上传失败");
           }
       });

    upload2.render({
        elem: '#videoPath'
        ,url: path
        ,auto: false
        ,size: 499999
        ,title: '只能上传 mp4,webm,ogg 后缀的文件'
        ,field:'fileVideo' //后台接收默认字段名
        ,accept: 'file '
        ,acceptMime:  '.mp4,.webm,ogg'
        // ,acceptMime:  'file/mp4, file/webm, file/ogg'
        ,exts: 'mp4|webm|ogg'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列

            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                $('#Videotext').html(file.name);
                fileVideo=file;

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
},300);