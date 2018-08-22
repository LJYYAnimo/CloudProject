
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

        $("#worksTitle").val(value.worksTitle);
        $("#worksType").val(value.worksTypeidName);
        $("#worksIntegral").val(value.worksIntegral);
        $("#worksAbout").html(value.worksAbout);
        $("#imgs").attr("src",value.worksPhotoaddress);
        $("#stl").attr("href",value.stl);
        $("#worksAddress").attr("href",value.worksAddress);
        layer.close(index);
    },200);//这里加定时器是为了解决数据加载顺序错误，导致取不到value的值
});

