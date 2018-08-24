package com.staging.controller;

import com.staging.common.LayuiUploadMsg;
import com.staging.common.Pager;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.entity.CaseFile;
import com.staging.entity.User;
import com.staging.entity.Works;
import com.staging.entity.vo.CaseFileVo;
import com.staging.entity.vo.LayEditMsg;
import com.staging.service.CaseFileService;
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
@RequestMapping("/caseFile")
public class CaseFileController {

    private final Logger logger = LoggerFactory.getLogger(CaseFileController.class);

    @Autowired
    private CaseFileService caseFileService;

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:39
     * @Description:跳转课件管理的页面
     *
     */
    @GetMapping("page")
    public String page(){
        return "caseFile/caseFile";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:40
     * @Description:添加课件管理的页面
     *
     */
    @GetMapping("addUpdateCaseFile")
    public String addUpdateCaseFile(){
        return "caseFile/addUpdateCaseFile";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 14:29
     * @Description: 查看课件详情的页面跳转
     *
     */
    @GetMapping("article")
    public String Article(){
        return "caseFile/article";
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

            String path = FileUtils.uploadPath(request,"editorimgCase",user.getUserName()+"/");//把用户的图片存放到admin用户的editorimg文件夹下
            try {
                String file1 = FileUtils.uploadFile(file, path);
                layui.setCode(0);
                layui.setData(new LayEditMsg(request.getContextPath()+"\\upload\\"+user.getUserName()+"\\editorimgCase\\"+file1,file1));
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
    public Pager pager(Integer page, Integer limit, CaseFileVo caseFileVo){
        logger.info("进入作品分页查询:"+caseFileVo.toString());
        Pager p = new Pager(page,limit);
        p.setRows(caseFileService.queryPageCase(p,caseFileVo));
        p.setTotal(Long.valueOf(caseFileService.queryPageCount(caseFileVo)));
        return p;
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/10 10:18
     * @param fileImg 这个是来接收图片的
     * @param fileStl 这个是来接收3d文件的
     * @param fileZIP 这个是来接收zip压缩包的的
     * @Description:
     *
     */
    @PostMapping("addCaseupload")
    @ApiOperation("添加课件")
    @ResponseBody
    public ServerResponse<CaseFile> addnewupload(MultipartFile fileImg,MultipartFile fileStl,MultipartFile fileZIP, CaseFile caseFile, HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        if(!StringUtils.isEmpty(fileImg)&&!StringUtils.isEmpty(fileStl)&&!StringUtils.isEmpty(fileZIP)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            String stl = FileUtils.getExtensionWithoutDot(fileStl.getOriginalFilename());
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if((MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img))&&
                    MIMETypeEnum.STL.getValue().equals(stl)&&(MIMETypeEnum.RAR.getValue().equals(zip)||MIMETypeEnum.ZIP.getValue().equals(zip))){
                String pathImg = FileUtils.uploadPath(request,"imgCase",user.getUserName()+"/");//把用户的图片存放到用户的imgCase文件夹下
                String pathStl = FileUtils.uploadPath(request,"StlCase",user.getUserName()+"/");//把用户的3d文件存放到用户的StlCase文件夹下
                String pathZIP = FileUtils.uploadPath(request,"ZIPCase",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPCase文件夹下
                try {
                    String imgName = FileUtils.uploadFile(fileImg, pathImg);
                    caseFile.setImg("/upload/"+user.getUserName()+"/imgCase/"+imgName);

                    String stlName = FileUtils.uploadFile(fileStl, pathStl);
                    caseFile.setStl("/upload/"+user.getUserName()+"/StlCase/"+stlName);

                    String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                    caseFile.setFileadress("/upload/"+user.getUserName()+"/ZIPCase/"+zipName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("你上传的图片格式不正确");
                }
            }else {
                return ServerResponse.createByError("请上传正确的文件");
            }
            caseFile.setAuthorid(user.getId());
            caseFile.setCreatetime(Calendar.getInstance().getTime());

            caseFile.setCaseAudit(1);
            caseFileService.insert(caseFile);
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }

        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/3 10:18
     * @param fileImg 这个是来接收图片的
     * @param fileStl 这个是来接收3d文件的
     * @param fileZIP 这个是来接收zip压缩包的的
     * @param deletImg 这个是来接收更新前的图片路径的，每次更新需要把原来的文件删除
     * @param deletfileStl 这个是来接收更新前的3d文件路径的，每次更新需要把原来的文件删除
     * @param deletfileZIP 这个是来接收更新前的zip附件路径的，每次更新需要把原来的文件删除
     * @Description:
     *
     */
    @PostMapping("updateCase")
    @ApiOperation("更新课件")
    @ResponseBody
    public ServerResponse<CaseFile> updateCase(MultipartFile fileImg, MultipartFile fileStl, MultipartFile fileZIP, CaseFile caseFile, String deletImg,
                                             String deletfileStl , String deletfileZIP , HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        try {
            addImg(fileImg, caseFile, deletImg, request, user);
            addStl(fileStl, caseFile, deletfileStl, request, user);
            addZIP(fileZIP, caseFile, deletfileZIP, request, user);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByError("上传错误");
        }
        caseFile.setCaseAudit(1);
        caseFileService.updateById(caseFile);
        return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
    }

    @PostMapping("deletCaseFile")
    @ApiOperation("删除作品")
    @ResponseBody
    public ServerResponse<CaseFile> deletWorks(CaseFile caseFile){
        if(StringUtils.isEmpty(caseFile.getImg())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个名为null文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/null下的文件夹
            caseFile.setImg("null");
        }
        if(StringUtils.isEmpty(caseFile.getStl())){
            caseFile.setStl("null");
        }
        if(StringUtils.isEmpty(caseFile.getFileadress())){
            caseFile.setFileadress("null");
        }
        return caseFile.deleteById()? DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+caseFile.getImg())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+caseFile.getStl())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+caseFile.getFileadress())?
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET)
                :ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("updateStatus")
    @ApiOperation("冻结或激活作品")
    @ResponseBody
    public ServerResponse<CaseFile> updateStatus(CaseFile caseFile){
        caseFile.setAuditDate(Calendar.getInstance().getTime());
        return caseFile.getCaseAudit()==2&&caseFile.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_STATUS)
                :caseFile.getCaseAudit()==3&&caseFile.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                ServerResponse.createByError("操作失败");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============处理所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);//这句一个不要存在，不然还是处理不了时间转换
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    private void addZIP(MultipartFile fileZIP, CaseFile caseFile, String deletfileZIP, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileZIP)){
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if(MIMETypeEnum.RAR.getValue().equals(zip)||MIMETypeEnum.ZIP.getValue().equals(zip)){
                if(!StringUtils.isEmpty(deletfileZIP)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfileZIP);//删除原来图片
                }
                String pathZIP = FileUtils.uploadPath(request,"ZIPCase",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPCase文件夹下
                String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                caseFile.setFileadress("/upload/"+user.getUserName()+"/ZIPCase/"+zipName);
            }
        }
    }

    private void addStl(MultipartFile fileStl, CaseFile caseFile, String deletfileStl, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileStl)){
            String stl = FileUtils.getExtensionWithoutDot(fileStl.getOriginalFilename());
            if(MIMETypeEnum.STL.getValue().equals(stl)){

                if(!StringUtils.isEmpty(deletfileStl)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfileStl);//删除原来图片
                }
                String pathStl = FileUtils.uploadPath(request,"StlCase",user.getUserName()+"/");//把用户的3d文件存放到用户的StlCase文件夹下
                String stlName = FileUtils.uploadFile(fileStl, pathStl);
                caseFile.setStl("/upload/"+user.getUserName()+"/StlCase/"+stlName);
            }
        }
    }

    private void addImg(MultipartFile fileImg, CaseFile caseFile, String deletImg, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileImg)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            if(MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img)){
                if(!StringUtils.isEmpty(deletImg)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                }
                String pathImg = FileUtils.uploadPath(request,"imgCase",user.getUserName()+"/");//把用户的图片存放到用户的imgCase文件夹下
                String imgName = FileUtils.uploadFile(fileImg, pathImg);
                caseFile.setImg("/upload/"+user.getUserName()+"/imgCase/"+imgName);
            }
        }
    }

}

