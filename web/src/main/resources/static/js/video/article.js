
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
        $("#classzName").val(value.classzName);
        $("#synopsis").html(value.synopsis);
        $("#imgs").attr("src",value.imgPath);
        // var vido = value.videoPath.split('/');
        $('#videoPath').attr("download",value.title);
        $("#videoPath").attr("href",value.videoPath);
        layer.close(index);
    },200);//这里加定时器是为了解决数据加载顺序错误，导致取不到value的值
});

