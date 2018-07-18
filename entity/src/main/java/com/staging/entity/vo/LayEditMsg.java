package com.staging.entity.vo;

import com.staging.common.LayuiUploadMsg;
import lombok.Data;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * TODO layui富文本编辑器插入图片时返回的消息类
 *
 * @Description :
 * ---------------------------------
 * @Author : liB QQ:1245018781
 * @Date : 2018/7/16
 */
@Data
public class LayEditMsg {

    private String src;

    private String title;


    public LayEditMsg(){

    }

    public LayEditMsg(String src,String title){
        this.src=src;
        this.title=title;
    }

}
