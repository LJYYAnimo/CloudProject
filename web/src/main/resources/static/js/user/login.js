layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;
    form.on('submit(formDemo)', function (data) {
        $.ajax({
            url: "/user/login",
            data: JSON.stringify(data.field),
            type: "POST",
            contentType: "application/json",
            success: function (response) {
                if (response.code == 0) {
                    layer.msg(response.message, {icon: 6});
                    window.location.href = "/user/home";
                } else {
                    layer.msg(response.message, {icon: 5})
                }
            }, error: function (response) {
                layer.msg("接口请求异常");
            }
        });
        return false;
    });
});