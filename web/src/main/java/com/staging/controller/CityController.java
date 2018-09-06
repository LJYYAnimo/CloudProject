package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.entity.City;
import com.staging.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/city")
@Api(tags = "1.0", description = "省下市区管理", value = "省下市区管理")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("save")
    @ApiOperation(value = "市区添加")
    @ResponseBody
    public ServerResponse save(@RequestBody City city){
        if(cityService.insert(city)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    /**
     * @param city
     * @return
     */
    @PostMapping("delete")
    @ApiOperation(value = "市区删除")
    @ResponseBody
    public ServerResponse delete(@RequestBody City city){
//        int  result =  schoolService.selectCount(new EntityWrapper<School>().eq("school_type",schoolType.getId()));
//        if(result!=0){
//            return ServerResponse.createByError("该类型下还有学校不能删除");
//        }
//        schoolService.selectCount( new EntityWrapper<School>().eq("school_type", schoolType.getId()));
//        if(cityService.deleteById(schoolType.getId())){
//            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET);
//        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    /**
     * 更新市区的基本信息
     * @param city
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "市区更新")
    @ResponseBody
    public ServerResponse update(@RequestBody City city){
        if(cityService.updateAllColumnById(city)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    /**
     * 查询所有省下的市区
     * @param
     * @return
     */
    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(Integer page,Integer limit){
        Pager p = new Pager(page,limit);
        p.setRows(cityService.queryPage(p));
        p.setTotal(Long.valueOf(cityService.selectCount(new EntityWrapper<>())));
        return p;
    }


    @PostMapping("list")
    @ResponseBody
    public List<City> list(){
        return cityService.selectList(null);
    }

    @GetMapping("page")
    public String page(){
        return "city/city";
    }

}

