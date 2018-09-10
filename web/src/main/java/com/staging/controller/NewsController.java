package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.LayuiUploadMsg;
import com.staging.common.Pager;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.entity.News;
import com.staging.entity.vo.LayEditMsg;
import com.staging.impl.NewsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/news")
@Api(tags = "1.0", description = "资讯管理", value = "资讯管理")
public class NewsController {

    private final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsServiceImpl newsService;









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
        p.setRows(newsService.queryPageTitle(p,news));
        p.setTotal(Long.valueOf(newsService.queryPageCount(news)));
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

            String path = FileUtils.uploadPath(request,"editorimgNews","admin/");//把用户的图片存放到admin用户的editorimg文件夹下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                layui.setCode(0);
                layui.setData(new LayEditMsg(request.getContextPath()+"\\upload\\admin\\editorimgNews\\"+file1,file1));
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
            String path = FileUtils.uploadPath(request,"imgNews","admin/");//把用户的图片存放到adming用户的img下
            try {
                String file1 = FileUtils.uploadFile(file, path);

                news.setTitleImg("/upload/admin/imgNews/"+file1);
                news.setCreateTime(Calendar.getInstance().getTime());

                newsService.insert(news);
                return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
            } catch (IOException e) {
                e.printStackTrace();
                return ServerResponse.createByError("上传异常");
            }
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/18 17:27
     * @param news 要更新的对象
     * @param file  上传的图片
     * @param deletImg  更新资讯的时候先删除原来的图片，这里存放着原来的图片的地址
     * @Description:
     *
     */
    @PostMapping("updateNews")
    @ApiOperation("更新资讯")
    @ResponseBody
    public ServerResponse<News> updateNews(MultipartFile file,News news,String deletImg, HttpServletRequest request){
        if(null!=file){
            String fileName = file.getOriginalFilename();
            String value = FileUtils.getExtensionWithoutDot(fileName);
            if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){
                String path = FileUtils.uploadPath(request,"imgNews","admin/");//把用户的图片存放到adming用户的img下
                try {
                    if(path!=null){
                        if(!StringUtils.isEmpty(deletImg)){
                            DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                        }
                        String file1 = FileUtils.uploadFile(file, path);
                        news.setTitleImg("/upload/admin/imgNews/"+file1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("上传异常");
                }
            }
        }
        news.setUpdateTime(Calendar.getInstance().getTime());
        return  newsService.updateById(news)? ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE):ServerResponse.createByError(1,ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    @PostMapping("deletNew")
    @ApiOperation("删除资讯")
    @ResponseBody
    public ServerResponse<String> deletNew(News news){
        if(StringUtils.isEmpty(news.getTitleImg())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个233文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/233下的文件夹
            news.setTitleImg("233");
        }
        return newsService.deleteById(news.getId())?
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+news.getTitleImg())?
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET)
                :ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}

