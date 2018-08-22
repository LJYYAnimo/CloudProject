package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.LayuiUploadMsg;
import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.entity.*;
import com.staging.entity.vo.LayEditMsg;
import com.staging.service.SoftwareService;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/software")
public class SoftwareController {

    private final Logger logger = LoggerFactory.getLogger(SoftwareController.class);

    @Autowired
    private SoftwareService softwareService;


    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:39
     * @Description:跳转课件管理的页面
     *
     */
    @GetMapping("page")
    public String page(){
        return "software/software";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:40
     * @Description:添加课件管理的页面
     *
     */
    @GetMapping("addUpdateSoftware")
    public String addUpdateSoftware(){
        return "software/addUpdateSoftware";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 14:29
     * @Description: 查看课件详情的页面跳转
     *
     */
    @GetMapping("article")
    public String Article(){
        return "software/article";
    }

    @PostMapping("adduploadImg")
    @ApiOperation("Layui富文本编辑器插入图片的接口")
    @ResponseBody
    public LayuiUploadMsg<LayEditMsg> adduploadImg(MultipartFile file, HttpServletRequest request){
        LayuiUploadMsg<LayEditMsg> layui = new LayuiUploadMsg<LayEditMsg>();
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            layui.setCode(1);
            layui.setMsg("你的登入信息已过期，请重新刷新页面重新登入");
            return layui;
        }
        String fileName = file.getOriginalFilename();
        String value = FileUtils.getExtensionWithoutDot(fileName);
        if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){

            String path = FileUtils.uploadPath(request,"editorimgSoftware",user.getUserName()+"/");//把用户的图片存放到admin用户的editorimg文件夹下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                layui.setCode(0);
                layui.setData(new LayEditMsg(request.getContextPath()+"\\upload\\"+user.getUserName()+"\\editorimgSoftware\\"+file1,file1));
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


    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui , Software software, EntityWrapper<Software> softwareEntityWrapper){
        Page<Software> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        if(!StringUtils.isEmpty(software)){
            if(!StringUtils.isEmpty(software.getSoftwareName())){
                softwareEntityWrapper.eq("software_name",software.getSoftwareName());
            }
            if(!StringUtils.isEmpty(software.getSoftwareModel())){
                softwareEntityWrapper.eq("software_model",software.getSoftwareModel());
            }
            if(!StringUtils.isEmpty(software.getSoftwareAudit())){
                softwareEntityWrapper.eq("software_audit",software.getSoftwareAudit());
            }
        }
        pageEntity = softwareService.selectPage(pageEntity,softwareEntityWrapper);
        pagerLayui.setRows(pageEntity.getRecords());
        pagerLayui.setTotal(pageEntity.getTotal());
        return pagerLayui;
    }

    @PostMapping("addSoftwareUpload")
    @ApiOperation("添加课件")
    @ResponseBody
    public ServerResponse<Software> addnewupload(MultipartFile fileImg, MultipartFile file32, MultipartFile file64, Software software, HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        if(!StringUtils.isEmpty(fileImg)&&!StringUtils.isEmpty(file32)&&!StringUtils.isEmpty(file64)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            String zip32 = FileUtils.getExtensionWithoutDot(file32.getOriginalFilename());
            String zip64 = FileUtils.getExtensionWithoutDot(file64.getOriginalFilename());
            if((MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img))&&
                    (MIMETypeEnum.RAR.getValue().equals(zip32)||MIMETypeEnum.ZIP.getValue().equals(zip32))&&
                    (MIMETypeEnum.RAR.getValue().equals(zip64)||MIMETypeEnum.ZIP.getValue().equals(zip64))){
                String pathImg = FileUtils.uploadPath(request,"imgSoftware",user.getUserName()+"/");//把用户的图片存放到用户的imgCase文件夹下
                String pathStl = FileUtils.uploadPath(request,"ZIPSoftware32",user.getUserName()+"/");//把用户的3d文件存放到用户的StlCase文件夹下
                String pathZIP = FileUtils.uploadPath(request,"ZIPSoftware64",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPCase文件夹下
                try {
                    String imgName = FileUtils.uploadFile(fileImg, pathImg);
                    software.setSoftwareImg("/upload/"+user.getUserName()+"/imgSoftware/"+imgName);

                    String zipName32 = FileUtils.uploadFile(file32, pathStl);
                    software.setSoftware32("/upload/"+user.getUserName()+"/ZIPSoftware32/"+zipName32);

                    String zipName64 = FileUtils.uploadFile(file64, pathZIP);
                    software.setSoftware64("/upload/"+user.getUserName()+"/ZIPSoftware64/"+zipName64);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("你上传的图片格式不正确");
                }
            }else {
                return ServerResponse.createByError("请上传正确的文件");
            }

            software.setCreatTime(Calendar.getInstance().getTime());
            software.setSchoolId(3);
            software.setSoftwareAudit(1);
            softwareService.insert(software);
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }

        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("updateSoftware")
    @ApiOperation("更新课件")
    @ResponseBody
    public ServerResponse<Software> updateCase(MultipartFile fileImg, MultipartFile file32, MultipartFile file64, Software software, String deletImg,
                                               String deletfile32 , String deletfile64 , HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        try {
            updateImg(fileImg, software, deletImg, request, user);
            updateZip32(file32, software, deletfile32, request, user);
            updateZip64(file64, software, deletfile64, request, user);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByError("上传错误");
        }
        software.setSoftwareAudit(1);
        software.setUpdateCreatTime(Calendar.getInstance().getTime());
        softwareService.updateById(software);
        return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
    }

    private void updateImg(MultipartFile fileImg, Software software, String deletImg, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileImg)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            if(MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img)){
                if(!StringUtils.isEmpty(deletImg)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                }
                String pathImg = FileUtils.uploadPath(request,"imgSoftware",user.getUserName()+"/");//把用户的图片存放到用户的imgCase文件夹下
                String imgName = FileUtils.uploadFile(fileImg, pathImg);
                software.setSoftwareImg("/upload/"+user.getUserName()+"/imgSoftware/"+imgName);
            }
        }
    }

    private void updateZip32(MultipartFile fileZIP, Software software, String deletfile32, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileZIP)){
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if(MIMETypeEnum.ZIP.getValue().equals(zip)){

                if(!StringUtils.isEmpty(deletfile32)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfile32);//删除原来图片
                }
                String pathZIP = FileUtils.uploadPath(request,"ZIPSoftware32",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPCase文件夹下
                String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                software.setSoftware32("/upload/"+user.getUserName()+"/ZIPSoftware32/"+zipName);
            }
        }
    }

    private void updateZip64(MultipartFile fileZIP, Software software, String deletfile64, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileZIP)){
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if(MIMETypeEnum.ZIP.getValue().equals(zip)){

                if(!StringUtils.isEmpty(deletfile64)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfile64);//删除原来图片
                }
                String pathZIP = FileUtils.uploadPath(request,"ZIPSoftware64",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPCase文件夹下
                String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                software.setSoftware64("/upload/"+user.getUserName()+"/ZIPSoftware64/"+zipName);
            }
        }
    }

    @PostMapping("deletSoftware")
    @ApiOperation("删除作品")
    @ResponseBody
    public ServerResponse<Software> deletWorks(Software software){
        if(StringUtils.isEmpty(software.getSoftwareImg())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个名为null文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/null下的文件夹
            software.setSoftwareImg("null");
        }
        if(StringUtils.isEmpty(software.getSoftware32())){
            software.setSoftware32("null");
        }
        if(StringUtils.isEmpty(software.getSoftware64())){
            software.setSoftware64("null");
        }
        return software.deleteById()? DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+software.getSoftwareImg())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+software.getSoftware32())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+software.getSoftware64())?
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET)
                :ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("updateStatus")
    @ApiOperation("冻结或激活作品")
    @ResponseBody
    public ServerResponse<Software> updateStatus(Software software){
        software.setAuditTime(Calendar.getInstance().getTime());
        return software.getSoftwareAudit()==2&&software.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_STATUS)
                :software.getSoftwareAudit()==3&&software.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                ServerResponse.createByError("操作失败");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============处理所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);//这句一个不要存在，不然还是处理不了时间转换
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}

