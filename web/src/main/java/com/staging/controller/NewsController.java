package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.LayuiUploadMsg;
import com.staging.common.Pager;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.FileUtils;
import com.staging.entity.News;
import com.staging.entity.vo.LayEditMsg;
import com.staging.impl.NewsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
@RequestMapping("/news")
@Api(tags = "1.0", description = "所有资讯", value = "所有资讯")
public class NewsController {

    private final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private NewsServiceImpl newsService;



    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转资讯管理的页面
     *
     */
    @GetMapping("page")
    public String page(){
        return "news/news";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:40
     * @Description:添加资讯管理的页面
     *
     */
    @GetMapping("addUpdateNews")
    public String addUpdateNews(){
        return "news/addUpdateNews";
    }

    /**
     *  TODO 资讯搜索后期可能会增加多个字段查询
     * 模糊搜索某个字段的所有资讯和查询所有资讯
     * @param
     * @return
     */
    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(Integer page, Integer limit, News news, EntityWrapper<News> entityWrapper){
        logger.info("进入资讯分页查询:"+news.toString());
        Pager p = new Pager(page,limit);
        if(!"".equals(news.getTitle())&&null!=news.getTitle()){
            entityWrapper.like("title",news.getTitle());
        }
        p.setRows(newsService.queryPageTitle(p,news));
        p.setTotal(Long.valueOf(newsService.selectCount(entityWrapper)));
        return p;
    }


    @PostMapping("adduploadImg")
    @ApiOperation("Layui富文本编辑器插入图片的接口")
    @ResponseBody
    public LayuiUploadMsg<LayEditMsg> adduploadImg(MultipartFile file, HttpServletRequest request){
        LayuiUploadMsg<LayEditMsg> layui = new LayuiUploadMsg<LayEditMsg>();
        String fileName = file.getOriginalFilename();
        String value = FileUtils.getExtensionWithoutDot(fileName);
        if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){

            String path = FileUtils.uploadPath(request,"editorimg","admin/");//把用户的图片存放到admin用户的editorimg文件夹下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                layui.setCode(0);
                layui.setData(new LayEditMsg(request.getContextPath()+"\\upload\\admin\\editorimg\\"+file1,file1));
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

    @PostMapping("addnewupload")
    @ApiOperation("添加资讯")
    @ResponseBody
    public ServerResponse<News> addnewupload(MultipartFile file,News news, HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        String value = FileUtils.getExtensionWithoutDot(fileName);
        if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){

            String path = FileUtils.uploadPath(request,"img","admin/");//把用户的图片存放到adming用户的img下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                System.out.println("/admin/img/"+file1);
                news.setTitleImg("/upload/admin/img/"+file1);
                news.setCreateTime(Calendar.getInstance().getTime());
                newsService.insert(news);
                return ServerResponse.createBySuccess("添加成功");
            } catch (IOException e) {
                e.printStackTrace();
                return ServerResponse.createByError("上传异常");
            }

        }
        return ServerResponse.createByError("上传失败");
    }

    @PostMapping("deletNew")
    @ApiOperation("删除资讯")
    @ResponseBody
    public ServerResponse<String> deletNew(@RequestBody News news){
        return newsService.deleteById(news.getId())?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }
}

