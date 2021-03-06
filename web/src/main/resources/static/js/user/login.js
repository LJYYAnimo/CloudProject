layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;
    form.on('submit(formDemo)', function (data) {
        $.ajax({
            url: "/user/login",
            data: data.field,
            type: "POST",
            success: function (response) {
                if (response.code == 0) {
                    layer.msg("登录成功", {icon: 6});
                    window.location.href = "/admin/home";
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