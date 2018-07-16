package com.staging.common.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

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
 *
 * @Description :
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/7/12
 */
public enum MenuEnum implements IEnum {

    LI(1,"目录"),
    MENU(2,"菜单"),
    BUTTON(3,"按钮");

    private Integer value;

    private String des;

    MenuEnum(Integer value, String des) {
        this.value = value;
        this.des = des;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public String getDes() {
        return des;
    }
}
