package com.staging.common;

import lombok.Data;

import java.util.List;

@Data
public class PagerLayui<T> {

    private Integer page;
    private Integer limit;

    private Integer code = 200;

    private String msg = "msg";

    private Integer total;

    private List<T> rows;

}
