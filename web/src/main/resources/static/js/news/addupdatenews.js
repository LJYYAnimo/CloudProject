
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
        form = layui.form;
    var $ = layui.$;
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/news/adduploadImg' //富文本插入图片时的接口
            ,type: 'post' //默认post
        }
    });
    var index = layedit.build('demo'); //建立编辑器

    var  frameindex= parent.layer.getFrameIndex(window.name);//当此页面被其他页面弹窗时，获取此页面元素

    var path ='/news/addnewupload';

        if(value!=""&&value!=undefined){
            var indexs= layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
                $('#imgs').attr('src', value.titleImg); //图片链接（base64
                form.val('newsForm',{
                    "id":value.id,
                    "deletImg":value.titleImg,
                    "title":value.title,
                    "about":value.about,
                    "dept":value.dept
                });
                path ='/news/updateNews';
                $("#btnform").removeClass("layui-hide");//没有上传文件就监听并显示这个按钮
                $("#btn").addClass("layui-hide");//同时隐藏这个按钮
                layedit.setContent(index,value.content);//把文章内容添加到富文本编辑器里
                layer.close(indexs);
        }


    $("#btnform").click(function () {//当upload.render没有被使用的时候就用这个提交表单数据
        var data = {"id":$("#ids").val(),
            "deletImg":value.titleImg,
            "title":$("#title").val(),
            "about":$("#about").val(),
            "dept":$("#dept").val(),
            "content":layedit.getContent(index)
        }
        $("#btnform").addClass("layui-hide");//提交后就暂时隐藏按钮
        axios.post(path, Qs.stringify(data)).then(function (response) {

            if(response.data.code==0){
                tableReload();
                parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭
                parent.layer.msg(response.data.message, {
                    time: 1000, icon:6
                });
            }else {
                parent.layer.msg(response.data.message, {
                    time: 1000, icon:5
                });
            }
        }).catch(function (error) {
            layer.msg(error);
        });
    });
    var files;
    upload.render({
           elem: '#uploadImg'
           ,url: path
           ,auto: false
           ,size: 5120
           ,title: '只能上传jpg,png,jpeg后缀的文件'
           ,field:'file' //后台接收默认字段名
           //,multiple: true
           ,bindAction: '#btn'
           ,acceptMime: 'image/jpg, image/png,image/jpeg'
           ,ext: 'jpg|png|jpeg'
            ,choose: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
                //将每次选择的文件追加到文件队列
                files = obj.pushFile();
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
                    ,"title":$("#title").val(),
                    "about":$("#about").val(),
                    "dept":$("#dept").val(),
                    "content":layedit.getContent(index)
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
                        time: 1000, icon:5
                    });
                }
            }
            ,error: function(index, upload){
            layer.msg("上传失败")
           }
       });
});
},200);