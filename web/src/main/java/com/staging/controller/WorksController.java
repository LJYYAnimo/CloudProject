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
import com.staging.entity.News;
import com.staging.entity.Notice;
import com.staging.entity.User;
import com.staging.entity.Works;
import com.staging.entity.vo.LayEditMsg;
import com.staging.entity.vo.WorksVo;
import com.staging.service.WorksService;
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
@RequestMapping("/works")
public class WorksController {

    private final Logger logger = LoggerFactory.getLogger(WorksController.class);

    @Autowired
    private WorksService worksService;

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转作品管理的页面
     *
     */
    @GetMapping("page")
    public String page(){
        return "works/works";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:40
     * @Description:添加作品管理的页面
     *
     */
    @GetMapping("addUpdateWorks")
    public String addUpdateWorks(){
        return "works/addUpdateWorks";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看作品详情的页面跳转
     *
     */
    @GetMapping("article")
    public String Article(){
        return "works/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 预览3d文件效果
     *
     */
    @GetMapping("queryStl")
    public String queryStl(){
        return "works/STL";
    }

    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(Integer page, Integer limit, WorksVo worksVo){
        logger.info("进入作品分页查询:"+worksVo.toString());
        Pager p = new Pager(page,limit);
        p.setRows(worksService.queryPageWorks(p,worksVo));
        p.setTotal(Long.valueOf(worksService.queryPageCount(worksVo)));
        return p;
    }


    /**
     * @Author: 95DBC
     * @Date: 2018/8/3 10:18
     * @param fileImg 这个是来接收图片的
     * @param fileStl 这个是来接收3d文件的
     * @param fileZIP 这个是来接收zip压缩包的的
     * @Description:
     *
     */
    @PostMapping("addworksupload")
    @ApiOperation("添加作品")
    @ResponseBody
    public ServerResponse<Works> addnewupload(MultipartFile fileImg,MultipartFile fileStl,MultipartFile fileZIP, Works works, HttpServletRequest request){
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
                String pathImg = FileUtils.uploadPath(request,"imgWorks",user.getUserName()+"/");//把用户的图片存放到用户的imgWorks文件夹下
                String pathStl = FileUtils.uploadPath(request,"StlWorks",user.getUserName()+"/");//把用户的3d文件存放到用户的StlWorks文件夹下
                String pathZIP = FileUtils.uploadPath(request,"ZIPWorks",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPWorks文件夹下
                try {
                    String imgName = FileUtils.uploadFile(fileImg, pathImg);
                    works.setWorksPhotoaddress("/upload/"+user.getUserName()+"/imgWorks/"+imgName);

                    String stlName = FileUtils.uploadFile(fileStl, pathStl);
                    works.setStl("/upload/"+user.getUserName()+"/StlWorks/"+stlName);

                    String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                    works.setWorksAddress("/upload/"+user.getUserName()+"/ZIPWorks/"+zipName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("你上传的图片格式不正确");
                }
            }else {
                return ServerResponse.createByError("请上传正确的文件");
            }
            works.setUserId(user.getId());
            works.setWorksDate(Calendar.getInstance().getTime());
            works.setSchoolTypeid(6);
            works.setWorksAudit(1);
            worksService.insert(works);
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
    @PostMapping("updateWorks")
    @ApiOperation("更新作品")
    @ResponseBody
    public ServerResponse<Works> updateWorks(MultipartFile fileImg,MultipartFile fileStl,MultipartFile fileZIP, Works works,String deletImg,
                                             String deletfileStl ,String deletfileZIP ,HttpServletRequest request){
         User user = ShiroUtils.getUserSession(request);
         if(StringUtils.isEmpty(user)){
             return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
         }
        try {
            addImg(fileImg, works, deletImg, request, user);
            addStl(fileStl, works, deletfileStl, request, user);
            addZIP(fileZIP, works, deletfileZIP, request, user);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByError("上传错误");
        }
        worksService.updateById(works);
        return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
    }

    @PostMapping("deletWorks")
    @ApiOperation("删除作品")
    @ResponseBody
    public ServerResponse<Works> deletWorks(Works works){
        if(StringUtils.isEmpty(works.getWorksPhotoaddress())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个名为null文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/null下的文件夹
            works.setWorksPhotoaddress("null");
        }
        if(StringUtils.isEmpty(works.getStl())){
            works.setStl("null");
        }
        if(StringUtils.isEmpty(works.getWorksAddress())){
            works.setWorksAddress("null");

        }
        return works.deleteById()? DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+works.getWorksPhotoaddress())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+works.getStl())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+works.getWorksAddress())?
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET)
                :ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("updateStatus")
    @ApiOperation("冻结或激活作品")
    @ResponseBody
    public ServerResponse<Works> updateStatus(Works works){
        works.setAuditDate(Calendar.getInstance().getTime());
        return works.getWorksAudit()==2&&works.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_STATUS)
                :works.getWorksAudit()==3&&works.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                ServerResponse.createByError("操作失败");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============处理所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);//这句一个不要存在，不然还是处理不了时间转换
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    private void addZIP(MultipartFile fileZIP, Works works, String deletfileZIP, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileZIP)){
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if(MIMETypeEnum.RAR.getValue().equals(zip)||MIMETypeEnum.ZIP.getValue().equals(zip)){

                if(!StringUtils.isEmpty(deletfileZIP)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfileZIP);//删除原来图片
                }
                String pathZIP = FileUtils.uploadPath(request,"ZIPWorks",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPWorks文件夹下
                String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                works.setWorksAddress("/upload/"+user.getUserName()+"/ZIPWorks/"+zipName);
            }
        }
    }

    private void addStl(MultipartFile fileStl, Works works, String deletfileStl, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileStl)){
            String stl = FileUtils.getExtensionWithoutDot(fileStl.getOriginalFilename());
            if(MIMETypeEnum.STL.getValue().equals(stl)){

                if(!StringUtils.isEmpty(deletfileStl)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfileStl);//删除原来图片
                }
                String pathStl = FileUtils.uploadPath(request,"StlWorks",user.getUserName()+"/");//把用户的3d文件存放到用户的StlWorks文件夹下
                String stlName = FileUtils.uploadFile(fileStl, pathStl);
                works.setStl("/upload/"+user.getUserName()+"/StlWorks/"+stlName);
            }
        }
    }

    private void addImg(MultipartFile fileImg, Works works, String deletImg, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileImg)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            if(MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img)){
                if(!StringUtils.isEmpty(deletImg)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                }
                String pathImg = FileUtils.uploadPath(request,"imgWorks",user.getUserName()+"/");//把用户的图片存放到用户的imgWorks文件夹下
                String imgName = FileUtils.uploadFile(fileImg, pathImg);
                works.setWorksPhotoaddress("/upload/"+user.getUserName()+"/imgWorks/"+imgName);
            }
        }
    }
}

