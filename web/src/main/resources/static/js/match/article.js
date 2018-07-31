
var value;

function child(d) {
    value = null;
    if (d != null) {
        value = d;
    }
}


layui.use(['table','upload','form','laydate','element','layedit'], function(){
    var table = layui.table,
        upload = layui.upload,
        laydate = layui.laydate,
        form = layui.form;
    var $ = layui.$;
    var index = layer.load(1, {
        shade: [0.1,'#fff'] //0.1透明度的白色背景
    });
    setTimeout(function() {

        $("#title").val(value.title);
        $("#matchAbout").html(value.matchAbout);
        $("#matchBonus").val(value.matchBonus);
        $("#matchType").val(value.matchType);
        $("#commend").html(value.commend);
        $("#matchIntroduction").html(value.matchIntroduction);
        $("#matchRules").html(value.matchRules);
        laydate.render({
            elem: '#startTime'
            ,calendar: 'true'
            ,value: value.startTime
            ,done: function(value, date){

            }
        });
        //结束时间选择器
        laydate.render({
            elem: '#endTime'
            ,calendar: 'true'
            ,value: value.endTime
            ,done: function(value, date){

            }
        });
        layer.close(index);
    },200);//这里加定时器是为了解决数据加载顺序错误，导致取不到value的值
});

