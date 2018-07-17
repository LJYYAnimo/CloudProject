layui.use(['table', 'upload', 'form'], function () {
    var table = layui.table,
        upload = layui.upload,
        form = layui.form;
    var setting = {
        check: {
            enable: true,
            chkboxType: {
                Y: 'ps',
                N: 'ps'
            }
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeCheck: zTreeBeforeCheck, //用户点击单选框的回调函数
            onCheck: zTreeOnCheck,//获取获取单选框所有参数包括父节点
            beforeDblClick: zTreeBeforeMouseDown
        },
        view: {
            showIcon: false
        },
        edit: {
            enable: true
        }
    };

    var pagerLayui = {
        page: 1,
        limit: 100
    };

    var permission={
        "id":null,
        "name":null,
        "icon":null,
        "pId":null,
        "jurUrl":null,
        "jurType":null,
        "jurPer":null,
        "iconClass":null,
        "des":null
    };

    //用户点击单选框的回调函数
    function zTreeBeforeCheck(treeId, treeNode) {
        console.log("单选框点击事件");
    }

    //获取获取单选框所有参数包括父节点
    function zTreeOnCheck(event, treeId, treeNode) {
        console.log(treeNode.getParentNode());
    }

    function zTreeBeforeMouseDown(treeId, treeNode) {
        permission.id = treeNode.id;
        permission.name = treeNode.name;
        permission.icon = treeNode.icon;
        permission.pId = treeNode.pId;
        permission.jurUrl = treeNode.jurUrl;
        permission.jurType = treeNode.jurType;
        permission.jurPer = treeNode.jurPer;
        permission.iconClass = treeNode.iconClass;
        permission.des = treeNode.des;
        form.val('formDemo', permission);
        layer.open({
            type: 2,
            title: '菜单操作',
            area: ['1165px', '475px'],
            fixed: false, //不固定
            maxmin: true,
            content: $("#permissionEdit")
        });
    }

    axios.post('/permission/pager', Qs.stringify(pagerLayui)).then(function (response) {
        $.fn.zTree.init($("#treeDemo"), setting, response.data.rows);
    }).catch(function (error) {
        layer.msg(error);
    });
});