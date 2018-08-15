
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

        $("#title").val(value.title);
        $("#typeName").val(value.typeName);
        $("#caseFileIntegral").val(value.caseFileIntegral);
        $("#about").html(value.about);
        $("#des").html(value.des);
        $("#imgs").attr("src",value.img);
        $("#stl").attr("href",value.stl);
        $("#fileadress").attr("href",value.fileadress);
        layer.close(index);
    },200);//这里加定时器是为了解决数据加载顺序错误，导致取不到value的值
});

