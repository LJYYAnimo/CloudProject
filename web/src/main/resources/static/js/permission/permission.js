layui.use(['table', 'layer', 'form'], function () {
    var table = layui.table,
        layer = layui.layer,
        form = layui.form;

    var setting = {
        check: {
            enable: true
            // chkboxType: {
            //     Y: 'ps',
            //     N: 'ps'
            // }
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



    //用户点击单选框的回调函数
    function zTreeBeforeCheck(treeId, treeNode) {
        console.log("单选框点击事件");
    }

    //获取获取单选框所有参数包括父节点
    function zTreeOnCheck(event, treeId, treeNode) {
        console.log(treeNode.getParentNode());
    }

    function zTreeBeforeMouseDown(treeId, treeNode) {
        form.val('permissionForm',{
            "id":treeNode.id,
            "name":treeNode.name,
            "icon":treeNode.icon,
            "pId":treeNode.pId,
            "jurUrl":treeNode.jurUrl,
            "jurType":treeNode.jurType,
            "jurPer":treeNode.jurPer,
            "iconClass":treeNode.iconClass,
            "des":treeNode.des
        });
        layer.open({
            type: 1,
            title: '编辑菜单',
            shadeClose: true,
            area: ['333px', '475px'],
            maxmin: true,
            content: $('#permissionEdit')
        });
    }

    axios.post('/permission/pager', Qs.stringify(pagerLayui)).then(function (response) {
        console.log(response.data.rows);
        $.fn.zTree.init($("#treeDemo"), setting, response.data.rows);
    }).catch(function (error) {
        layer.msg(error);
    });

    //监听提交
    form.on('submit(formDemo)', function(data){
        axios.post('/permission/update', Qs.stringify(data.field)).then(function (response) {
            if(response.data.code==0){
                layer.msg(response.data.message,{icon:6});
                layer.closeAll();
                return location.reload();
            }
            layer.msg(response.data.message);
        }).catch(function (error) {
            layer.msg(error);
        });
        return false;
    });
});