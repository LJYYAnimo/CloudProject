package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.LayuiUploadMsg;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.entity.Notice;
import com.staging.entity.vo.LayEditMsg;
import com.staging.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * @Author: 95DBC
     * @Date: 2018/7/20 15:12
     * @Description:公告管理的页面跳转
     *
     */
    @GetMapping("page")
    public String  page(){
        return "notice/notice";
    }

    @GetMapping("addUpdateNotice")
    public String addUpdateNotice(){
        return "notice/addUpdateNotice";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看公告详情的页面跳转
     *
     */
    @GetMapping("article")
    public String Article(){
        return "notice/article";
    }


    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui ,Notice notice, EntityWrapper<Notice> entityWrapper){
        Page<Notice> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        if(!StringUtils.isEmpty(notice)){

        }
        pageEntity = noticeService.selectPage(pageEntity,entityWrapper);
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
            String path = FileUtils.uploadPath(request,"editorimgNotice","admin/");//把用户的图片存放到admin用户的editorimg文件夹下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                layui.setCode(0);
                layui.setData(new LayEditMsg(request.getContextPath()+"\\upload\\admin\\editorimgNotice\\"+file1,file1));
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

    @PostMapping("addNoticeupload")
    @ApiOperation("添加公告")
    @ResponseBody
    public ServerResponse<Notice> addnewupload(MultipartFile file, Notice notice, HttpServletRequest request){
        String fileName = file.getOriginalFilename();
        String value = FileUtils.getExtensionWithoutDot(fileName);
        if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){
            String path = FileUtils.uploadPath(request,"imgNotice","admin/");//把用户的图片存放到adming用户的img下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                notice.setTitleImg("/upload/admin/imgNotice/"+file1);
                notice.setCreateTime(Calendar.getInstance().getTime());
                noticeService.insert(notice);
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
     * @param notice 要更新的对象
     * @param file  上传的图片
     * @param deletImg  更新资讯的时候先删除原来的图片，这里存放着原来的图片的地址
     * @Description:
     *
     */
    @PostMapping("updateNotice")
    @ApiOperation("更新公告")
    @ResponseBody
    public ServerResponse<Notice> updateNotice(MultipartFile file,Notice notice,String deletImg, HttpServletRequest request){
        if(null!=file){
            String fileName = file.getOriginalFilename();
            String value = FileUtils.getExtensionWithoutDot(fileName);
            if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){
                String path = FileUtils.uploadPath(request,"imgNotice","admin/");//把用户的图片存放到adming用户的img下
                try {
                    if(path!=null){
                        if(!StringUtils.isEmpty(deletImg)){
                            DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                        }
                        String file1 = FileUtils.uploadFile(file, path);
                        notice.setTitleImg("/upload/admin/imgNotice/"+file1);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("上传异常");
                }
            }
        }
        notice.setUpdateTime(Calendar.getInstance().getTime());
        return  noticeService.updateById(notice)? ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE,notice):ServerResponse.createByError(1,ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    @PostMapping("deletNotice")
    @ApiOperation("删除公告")
    @ResponseBody
    public ServerResponse<String> deletNew(Notice notice){
        if(StringUtils.isEmpty(notice.getTitleImg())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个233文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/233下的文件夹
            notice.setTitleImg("233");
        }
        return notice.deleteById(notice.getId())?
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+notice.getTitleImg())?
                        ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):ServerResponse.createBySuccess("删除图片失败")
                :ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============处理所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);//这句一个不要存在，不然还是处理不了时间转换
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}

