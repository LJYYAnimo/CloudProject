layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var $ = layui.$;

    table.render({
        elem: '#xinkai'
        , url: '/city/pager'
        , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , contentType: "application/json"
        , method: 'post'
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
            , {field: 'cname', title: '市名称', align: 'center'}
            , {
                field: 'city_banner',
                title: '市横幅',
                event: 'catBanner',
                align: 'center',
                templet: '<div><a class="" href="{{ d.city_banner }}"  alt="{{ d.city_banner }}">' +
                '<img src="{{ d.city_banner }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>',
                style: 'cursor: pointer;'
            }
            , {
                field: 'city_logo',
                title: '市LOGO',
                align: 'center',
                event: 'catLogo',
                templet: '<div><a class="" href="{{ d.city_logo }}"  alt="{{ d.city_logo }}">' +
                '<img src="{{ d.city_logo }}" style="width: 150px;height: 50px" alt="40x20" class="img-rounded"></a></div>',
                style: 'cursor: pointer;'
            }
            , {field: 'province_name', title: '关联省', align: 'center'}
            , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
        ]]
        , id: 'idTest'
        , page: true,
        done: function (res, curr, count) {
            if (!$(".layui-table").is("tz-gallery")) {
                $(".layui-table").addClass("tz-gallery")
            }

            baguetteBox.run('.tz-gallery');

        }
    });

    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.msg('确定删除？', {
                time: 0 //不自动关闭
                , btn: ['删除', '取消']
                , yes: function (index) {
                    layer.close(index);
                    layer.msg("删除成功", {icon: 6});
                }
            });
        } else if (obj.event === 'query') {
            layer.msg("查看区域");
        }
    });

});