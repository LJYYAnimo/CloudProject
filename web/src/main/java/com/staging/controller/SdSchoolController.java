package com.staging.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.Pager;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.entity.*;
import com.staging.service.SchoolTypeService;
import com.staging.service.SdSchoolService;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
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
 * @since 2018-07-20
 */
@Controller
@RequestMapping("/sdSchool")
@Api(tags = "1.0", description = "学校管理", value = "学校管理")
public class SdSchoolController {

    @Autowired
    private SdSchoolService sdSchoolService;

    @Autowired
    private SchoolTypeService schoolTypeService;

    public String page(){
        return "school/school";
    }

    @PostMapping("pager")
    @ResponseBody
    public Pager pager(Integer page,Integer limit, SchoolType schoolType,SdSchool sdSchool){
        EntityWrapper schoolTypeEntityWrapper = new EntityWrapper();
        //判断学校类型有没有传入
        if(!StringUtils.isEmpty(schoolType.getName())){
            schoolTypeEntityWrapper.eq("name",schoolType.getName());
        }
        SchoolType schoolTypeOne = schoolTypeService.selectOne(schoolTypeEntityWrapper);
        if(!StringUtils.isEmpty(schoolTypeOne)){
            sdSchool.setSchoolTypeid(schoolTypeOne.getId());
            return sdSchoolService.selectSdSchoolVoPager(new Pager(page,limit),sdSchool);
        }
        return null;
    }

    @PostMapping("save")
    @ApiOperation("添加学校")
    @ResponseBody
    public ServerResponse save(MultipartFile fileLogo,MultipartFile fileImg, SdSchool sdSchool,HttpServletRequest request){
        User user = ShiroUtils.getUserSession();
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        int result = sdSchoolService.selectCount(new EntityWrapper<SdSchool>().eq("school_name",sdSchool.getSchoolName()));
        if(result!=0){
            return ServerResponse.createByError("学校已存在");
        }
        if(!StringUtils.isEmpty(fileImg)){
            String fileName = fileImg.getOriginalFilename();
            String Img = FileUtils.getExtensionWithoutDot(fileName);
            if(MIMETypeEnum.JPEG.getValue().equals(Img) || MIMETypeEnum.JPG.getValue().equals(Img)|| MIMETypeEnum.PNG.getValue().equals(Img)){
                String path = FileUtils.uploadPath(null,"imgSchool",user.getUserName()+"/");//把用户的图片存放到adming用户的img下
                try {
                    String file1 = FileUtils.uploadFile(fileImg, path);

                    sdSchool.setSchoolCover("/upload/"+user.getUserName()+"/imgSchool/"+file1);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("上传异常");
                }
            }
        }
       if(!StringUtils.isEmpty(fileLogo)){
           String fileLoge = fileLogo.getOriginalFilename();
           String Logo = FileUtils.getExtensionWithoutDot(fileLoge);
           if(MIMETypeEnum.JPEG.getValue().equals(Logo) || MIMETypeEnum.JPG.getValue().equals(Logo)|| MIMETypeEnum.PNG.getValue().equals(Logo)){
               String path = FileUtils.uploadPath(null,"imgSchoolLoge",user.getUserName()+"/");//把用户的图片存放到adming用户的img下
               try {
                   String file1 = FileUtils.uploadFile(fileLogo, path);

                   sdSchool.setSchoolLoge("/upload/"+user.getUserName()+"/imgSchoolLoge/"+file1);
               } catch (IOException e) {
                   e.printStackTrace();
                   return ServerResponse.createByError("上传异常");
               }
           }
       }
        sdSchool.setSchoolCreattime(Calendar.getInstance().getTime());
        return sdSchoolService.insert(sdSchool)?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE):ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("updateSchool")
    @ApiOperation("更新学校")
    @ResponseBody
    public ServerResponse updateSchool(MultipartFile fileLogo,MultipartFile fileImg, SdSchool sdSchool,String deletImg ,String deletLoge, HttpServletRequest request){
        User user = ShiroUtils.getUserSession();
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        int result = sdSchoolService.selectCount(new EntityWrapper<SdSchool>().eq("school_name",sdSchool.getSchoolName()));

        if(result!=0){
            int result1 = sdSchoolService.selectCount(new EntityWrapper<SdSchool>().eq("school_name",sdSchool.getSchoolName()).eq("id",sdSchool.getId()));
            if(result1==result){

            }else {
                return ServerResponse.createByError("学校已存在");
            }
        }
        if(!StringUtils.isEmpty(fileImg)){
            String fileName = fileImg.getOriginalFilename();
            String Img = FileUtils.getExtensionWithoutDot(fileName);
            if(MIMETypeEnum.JPEG.getValue().equals(Img) || MIMETypeEnum.JPG.getValue().equals(Img)|| MIMETypeEnum.PNG.getValue().equals(Img)){
                String path = FileUtils.uploadPath(null,"imgSchool",user.getUserName()+"/");//把用户的图片存放到adming用户的img下
                try {
                    if(!StringUtils.isEmpty(deletImg)){
                        DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                    }
                    String file1 = FileUtils.uploadFile(fileImg, path);

                    sdSchool.setSchoolCover("/upload/"+user.getUserName()+"/imgSchool/"+file1);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("上传异常");
                }
            }
        }
        if(!StringUtils.isEmpty(fileLogo)){
            String fileLoge = fileLogo.getOriginalFilename();
            String Logo = FileUtils.getExtensionWithoutDot(fileLoge);
            if(MIMETypeEnum.JPEG.getValue().equals(Logo) || MIMETypeEnum.JPG.getValue().equals(Logo)|| MIMETypeEnum.PNG.getValue().equals(Logo)){
                String path = FileUtils.uploadPath(null,"imgSchoolLoge",user.getUserName()+"/");//把用户的图片存放到adming用户的img下
                try {
                    if(!StringUtils.isEmpty(deletLoge)){
                        DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletLoge);//删除原来图片
                    }
                    String file1 = FileUtils.uploadFile(fileLogo, path);

                    sdSchool.setSchoolLoge("/upload/"+user.getUserName()+"/imgSchoolLoge/"+file1);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("上传异常");
                }
            }
        }
        sdSchool.setSchoolCreattime(Calendar.getInstance().getTime());
        return sdSchoolService.updateById(sdSchool)?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE):ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    @PostMapping("updateStatus")
    @ApiOperation("冻结或激活作品")
    @ResponseBody
    public ServerResponse<CaseFile> updateStatus(SdSchool sdSchool){

        return sdSchool.getAuditStatus()==1&&sdSchool.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_STATUS)
                :sdSchool.getAuditStatus()==2&&sdSchool.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                ServerResponse.createByError("操作失败");
    }

    @PostMapping("deletSchool")
    @ApiOperation("删除物品")
    @ResponseBody
    public ServerResponse<String> deletSchool(SdSchool sdSchool){
        if(StringUtils.isEmpty(sdSchool.getSchoolCover())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个233文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/233下的文件夹
            sdSchool.setSchoolCover("233");
        }
        if(StringUtils.isEmpty(sdSchool.getSchoolLoge())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个233文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/233下的文件夹
            sdSchool.setSchoolLoge("233");
        }
        return sdSchoolService.deleteById(sdSchool.getId())?
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+sdSchool.getSchoolCover())&&
                        DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+sdSchool.getSchoolLoge())?
                        ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):
                        ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET)
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

