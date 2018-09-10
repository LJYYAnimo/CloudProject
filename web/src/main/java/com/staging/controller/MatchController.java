package com.staging.controller;


import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.LayuiUploadMsg;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.FileUtils;
import com.staging.entity.Match;
import com.staging.entity.vo.LayEditMsg;
import com.staging.service.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@RestController
@RequestMapping("/match")
@Api(tags = "1.0", description = "大赛管理", value = "大赛管理")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("pager")
    @ApiOperation("分页查询")
    public PagerLayui pager(PagerLayui pagerLayui , Match match, EntityWrapper<Match> entityWrapper){
        Page<Match> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        if(!StringUtils.isEmpty(match)){
            if(!StringUtils.isEmpty(match.getTitle())){
                entityWrapper.like("title",match.getTitle(), SqlLike.DEFAULT);
            }
        }
        pageEntity = matchService.selectPage(pageEntity,entityWrapper);
        pagerLayui.setRows(pageEntity.getRecords());
        pagerLayui.setTotal(pageEntity.getTotal());
        return pagerLayui;
    }

    @PostMapping("adduploadImg")
    @ApiOperation("Layui富文本编辑器插入图片的接口")
    public LayuiUploadMsg<LayEditMsg> adduploadImg(MultipartFile file, HttpServletRequest request){
        LayuiUploadMsg<LayEditMsg> layui = new LayuiUploadMsg<LayEditMsg>();
        String fileName = file.getOriginalFilename();
        String value = FileUtils.getExtensionWithoutDot(fileName);
        if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){
            String path = FileUtils.uploadPath(request,"editorimgMatch","admin/");//把用户的图片存放到admin用户的editorimg文件夹下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                layui.setCode(0);
                layui.setData(new LayEditMsg(request.getContextPath()+"\\upload\\admin\\editorimgMatch\\"+file1,file1));
                return layui;
            } catch (IOException e) {
                e.printStackTrace();
                layui.setCode(1);
                layui.setMsg("上传错误");
                return layui;
            }
        }
        layui.setCode(1);
        layui.setMsg("你上传的图片格式不对");
        return layui;
    }

    @PostMapping("addMatch")
    @ApiOperation("添加大赛")
    public ServerResponse<Match> addMatch(Match match){
        try {
            match.setCreateTime(Calendar.getInstance().getTime());
            matchService.insert(match);
            return  ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }catch (Exception e){

        }
       return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("updateMatch")
    @ApiOperation("更新大赛信息")
    public ServerResponse<Match> updateMatch(Match match){
        try {
            match.setUpdateTime(Calendar.getInstance().getTime());
            matchService.updateById(match);
            return  ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
        }catch (Exception e){

        }
       return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    @PostMapping("deletMatch")
    @ApiOperation("更新大赛信息")
    public ServerResponse<Match> deletMatch(Match match){
        try {
            matchService.deleteById(match);
            return  ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET);
        }catch (Exception e){

        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}

