/**
 * layui 渲染下拉框方法
 * id 为下拉框的id
 * data 需要渲染的数据
 * key 为option的value
 * value 为option显示的值
 */
function varaySelect(id,data){
    for(var i=0;i<data.length;i++){
        $("#"+id).append("<option value="+data[i].key+">"+data[i].value+"</option>");
    }
}