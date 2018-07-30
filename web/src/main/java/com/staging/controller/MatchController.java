package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.LayuiUploadMsg;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.FileUtils;
import com.staging.entity.Match;
import com.staging.entity.News;
import com.staging.entity.Notice;
import com.staging.entity.vo.LayEditMsg;
import com.staging.service.MatchService;
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
@Controller
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    /**
     * @Author: 95DBC
     * @Date: 2018/7/20 15:12
     * @Description:大赛管理的页面跳转
     *
     */
    @GetMapping("page")
    public String  page(){
        return "match/match";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看大赛详情的页面跳转
     *
     */
    @GetMapping("article")
    public String Article(){
        return "match/article";
    }

    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui , Match match, EntityWrapper<Match> entityWrapper){
        Page<Match> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        if(!StringUtils.isEmpty(match)){

        }
        pageEntity = matchService.selectPage(pageEntity,entityWrapper);
        pagerLayui.setRows(pageEntity.getRecords());
        pagerLayui.setTotal(pageEntity.getTotal());
        return pagerLayui;
    }

    @PostMapping("adduploadImg")
    @ApiOperation("Layui富文本编辑器插入图片的接口")
    @ResponseBody
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
    @ResponseBody
    public ServerResponse<Match> addMatch(Match match){
        try {
            match.setCreateTime(Calendar.getInstance().getTime());
            matchService.insert(match);
            return  ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }catch (Exception e){

        }
       return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============处理所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);//这句一个不要存在，不然还是处理不了时间转换
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}

