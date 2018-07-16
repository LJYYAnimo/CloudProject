layui.use(['table','upload','form'], function(){
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;


    upload.render({
    //                http://localhost:8080/LeiDianMap_war/thunderdroppoint/upload
           elem: '#uploadImg'
           ,url: '/news/upload'
           ,auto: false
           ,title: '只能上传xlsx后缀的文件'
           ,field:'file' //后台接收默认字段名
           //,multiple: true
           ,bindAction: '#btn'
           ,acceptMime: 'image/jpg, image/png,image/jpeg'
           ,ext: 'jpg|png|jpeg'
            ,error: function(res){
           //上传完毕回调



             }
           ,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
    // //                    预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
    //            obj.preview(function(index, file, result){
    //
    //                // $("#fileName").val(file.name);
    //                console.log(file)
    //
    //            });

            obj.preview(function(index, file, result){
                $('#uploadImg').attr('src', result); //图片链接（base64

            });
           } ,error: function(index, upload){
               //当上传失败时，你可以生成一个“重新上传”的按钮，点击该按钮时，执行 upload() 方法即可实现重新上传
           }
       });

});