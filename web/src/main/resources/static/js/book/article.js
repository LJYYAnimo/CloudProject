
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
        if(value.type ==0){
            $("#type").val("已出版");
        }else if(value.type ==1){
            $("#type").val("未出版");
        }

        if(value.bookType==0){
            $("#bookType").val("免费");
        }else if(value.bookType==1){
            $("#bookType").val("收费");
        }


        $("#des").html(value.des);
        $("#imgs").attr("src",value.img);
        $("#url").attr("href",value.url);
        layer.close(index);
    },200);//这里加定时器是为了解决数据加载顺序错误，导致取不到value的值
});

