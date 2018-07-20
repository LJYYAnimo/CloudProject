layui.use(['table', 'element', 'form'], function () {
    var table = layui.table,
        element = layui.element,
        form = layui.form;
    var $ = layui.$;

    tableData($(".xinkai_frist").val());

    element.on('tab(docDemoTabBrief)', function(data){
        tableData(this.textContent);
    });

    function tableData(value){
        table.render({
            elem: '#xinkai'
            , url: '/user/pager'
            , cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , method: 'post'
            ,dataType:'json'
            ,where:{name:value}
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
                , {field: 'userName', title: '账号', align: 'center'}
                , {field: 'creatTime', title: '创建时间', align: 'center'}
                , {field: 'email', title: '邮箱', align: 'center'}
                , {field: 'grade', title: '年级', align: 'center'}
                , {field: 'phone', title: '手机号码', align: 'center'}
                , {field: 'school', title: '学校', align: 'center'}
                , {field: 'sex', title: '性别', align: 'center'}
                , {field: 'brithday', title: '生日', align: 'center'}
                , {field: 'realName', title: '姓名', align: 'center'}
                , {field: 'des', title: '个性签名', align: 'center'}
                , {field: 'province', title: '省', align: 'center'}
                , {field: 'city', title: '市', align: 'center'}
                , {field: 'county', title: '县', align: 'center'}
                , {field: 'betterAddress', title: '详细地址', align: 'center'}
                , {field: 'caozuo', width: 150, title: '操作', toolbar: '#barDemo', fixed: 'right'}
            ]]
            , id: 'idTest'
            , page: true
        });
    }

});