
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
layui.use(['table','upload','form','layedit'], function(){
    var table = layui.table,
        upload = layui.upload,
        upload1 = layui.upload,
        upload2 = layui.upload,
        form = layui.form;
    var $ = layui.$;
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/software/adduploadImg' //富文本插入图片时的接口
            ,type: 'post' //默认post
        }
    });
    var index = layedit.build('demo'); //建立编辑器

    var  frameindex= parent.layer.getFrameIndex(window.name);//当此页面被其他页面弹窗时，获取此页面元素

    var path ='/software/addSoftwareUpload';
    console.log(value);

    if(value!=undefined&&value!=""){
        var indexs= layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });

            $('#imgs').attr('src', value.softwareImg); //图片链接（base64
            form.val('newsForm',{
                "id":value.id,
                "deletImg":value.softwareImg,
                "softwareName":value.softwareName,
                "softwareApply":value.softwareApply,
                "softwareModel":value.softwareModel,
                "deletfile32":value.software32,
                "deletfile64":value.software64
            });
            path ='/software/updateSoftware';
            // $("#softwareModel").val(value.softwareModel);
            $("#btnform").removeClass("layui-hide");//没有上传文件就监听并显示这个按钮
            $("#btn").addClass("layui-hide");//同时隐藏这个按钮
            layedit.setContent(index,value.softwareAbout);//把文章内容添加到富文本编辑器里

            var stls = value.software32.split('/');
            $('#software32text').text(stls[stls.length-1]);
            var zips = value.software64.split('/');
            $('#software64text').html(zips[zips.length-1]);
            layer.close(indexs);

    }

    var file32 =null;
    var file64 =null;

    $("#btnform").click(function () {//当upload.render没有被使用的时候就用这个提交表单数据

        var formdata1=new FormData();// 创建form对象
        formdata1.append('id',$("#ids").val());// 通过append向form对象添加数据,可以通过append继续添加数据
        formdata1.append('deletImg',$("#deletImg").val());
        formdata1.append('softwareName',$("#softwareName").val());
        formdata1.append('softwareModel',$("#softwareModel").val());
        formdata1.append('softwareApply',$("#softwareApply").val());
        formdata1.append('softwareAbout',layedit.getContent(index));
        formdata1.append('deletfile32',value.software32!=undefined?value.software32:null);
        formdata1.append('deletfile64',value.software64!=undefined?value.software64:null);
        if(file64!=null){
            formdata1.append('file64',file64,file64.name);
        }
        if(file32!=null){
            formdata1.append('file32',file32,file32.name);
        }


        $("#btnform").addClass("layui-hide");//提交后就暂时隐藏按钮
        var config = {
            headers: {'Content-Type': 'multipart/form-data'}
        }
        axios.post(path, formdata1,config).then(function (response) {
            tableReload();
            parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭
            parent.layer.msg(response.data.message, {
                time: 1000, icon:response.data.code==0?6:5
            });
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
                    ,"softwareName":$("#softwareName").val(),
                    "softwareModel":$("#softwareModel").val(),
                    "softwareApply":$("#softwareApply").val(),
                    "softwareAbout":layedit.getContent(index),
                    "file32":file32,
                    "file64":file64,
                    "deletfile32":value.software32!=undefined?value.software32:null,
                    "deletfile64":value.software64!=undefined?value.software64:null
                };
            $("#btn").addClass("layui-hide");//提交后就暂时隐藏按钮
             },done: function(res, indexs, upload){ //上传后的回调
                tableReload();
                parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭
                parent.layer.msg(res.message, {
                    time: 1000, icon:res.code==0?6:5
                });

            }
            ,error: function(index, upload){
            layer.msg("上传失败")
           }
       });

    upload1.render({
        elem: '#software32'
        ,url: path
        ,auto: false
        ,size: 71200
        ,title: '只能上传stl后缀的文件'
        ,field:'file32' //后台接收默认字段名
        //,multiple: test9
        ,accept: 'file '
        ,acceptMime:  '.zip,.rar'
        ,exts: 'zip|rar'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列
            var files = obj.pushFile();
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                $('#software32text').text(file.name);
                file32=file;
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
        elem: '#software64'
        ,url: path
        ,auto: false
        ,size: 71200
        ,title: '只能上传jpg,png,jpeg后缀的文件'
        ,field:'file64' //后台接收默认字段名
        ,accept: 'file '
        ,acceptMime:  '.zip,.rar'
        ,exts: 'zip|rar'
        ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //将每次选择的文件追加到文件队列

            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){
                // $("#ziptext").html(file.name)
                $('#software64text').html(file.name);
                file64=file;

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