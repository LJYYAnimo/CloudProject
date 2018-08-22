
var value;

function child(d) {
    value = null;
    if (d != null) {
        value = d;
    }
}


layui.use(['form'], function(){
    var index = layer.load(1, {
        shade: [0.1,'#fff'] //0.1透明度的白色背景
    });
    setTimeout(function() {


        $("#softwareName").val(value.softwareName);
        $("#softwareModel").val(value.softwareModel);
        $("#softwareApply").html(value.softwareApply);
        $("#softwareAbout").html(value.softwareAbout);
        $("#imgs").attr("src",value.softwareImg);
        $("#software32").attr("href",value.software32);
        $("#software64").attr("href",value.software64);
        layer.close(index);
    },200);//这里加定时器是为了解决数据加载顺序错误，导致取不到value的值
});

