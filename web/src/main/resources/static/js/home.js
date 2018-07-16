var message;
layui.config({
    base: '/js/'
}).use(['app', 'message'], function () {
    var app = layui.app,
        $ = layui.jquery,
        layer = layui.layer,
        element = layui.element;
    //将message设置为全局以便子页面调用
    message = layui.message;
    //主入口
    app.set({
        type: 'iframe'
    }).init();
});
