
var value;

function child(d) {
    value = null;
    if (d != null) {
        value = d;
    }
}
setTimeout(function() {
    layui.use(['form'], function(){
        console.log(value.title);
        $("#title").val(value.title);
        $("#content").html(value.content)
    });
},100);
