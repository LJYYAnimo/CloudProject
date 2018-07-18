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

    var  frameindex= parent.layer.getFrameIndex(window.name);//当此页面被其他页面弹窗时，获取此页面元素

    var index = layedit.build('demo'); //建立编辑器

    upload.render({
    //                http://localhost:8080/LeiDianMap_war/thunderdroppoint/upload
           elem: '#uploadImg'
           ,url: '/news/addnewupload'
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
            var files = obj.pushFile();

            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function(index, file, result){

                $('#imgs').attr('src', result); //图片链接（base64


                //这里还可以做一些 append 文件列表 DOM 的操作

                //obj.upload(index, file); //对上传失败的单个文件重新上传，一般在某个事件中使用
                //delete files[index]; //删除列表中对应的文件，一般在某个事件中使用
            });


            }
            ,before: function(obj){

                //这里是把数据跟图片一起添加到后台
                this.data = {"title":$("#title").val(),"about":$("#about").val(),"dept":$("#dept").val(),"content":layedit.getContent(index)}
                // extra_data(input,data);


             },done: function(res, index, upload){ //上传后的回调
                if(res.code ==0){
                    layer.msg('添加成功', {
                        time: 0 //不自动关闭
                        ,btn: ['继续添加', '不了']
                        ,yes: function(index){
                            location.reload();
                        },btn2:function (index) {
                            parent.layer.close(frameindex);//此页面被其他页面iframe弹窗时，调用此方法进行关闭

                            //这里调用父页面的表格进行重载
                            window.parent.layui.table.reload('idTest', {
                                page: {
                                    curr: 1
                                }
                            });

                        }
                    });


                }else {
                    layer.msg("上传失败")
                }
            }
            ,error: function(index, upload){

           }
       });


    //添加图片的同时上传参数
    function extra_data(input,data){
        var item=[];
        $.each(data,function(k,v){
            item.push('<input type="hidden" name="'+k+'" value="'+v+'">');
        })
        $(input).after(item.join(''));
    }

});