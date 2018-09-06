package com.staging.controller;


import com.staging.common.Pager;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.common.validated.Groups;
import com.staging.entity.*;
import com.staging.entity.Entity;
import com.staging.entity.vo.EntityVo;
import com.staging.entity.vo.WorksVo;
import com.staging.service.EntityService;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/entity")
@Api(tags = "1.0", description = "积分物品管理", value = "积分物品管理")
public class EntityController {

    @Autowired
    private EntityService entityService;

    private final Logger logger = LoggerFactory.getLogger(EntityController.class);

    @GetMapping("page")
    public String page(){
        return "entity/entity";
    }


    @GetMapping("addUpdateEntity")
    public String addUpdateEntity(){
        return "entity/addUpdateEntity";
    }


    @GetMapping("article")
    public String Article(){
        return "entity/article";
    }

    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(Integer page, Integer limit, EntityVo entityVo){
        logger.info("进入作品分页查询:"+entityVo.toString());
        Pager p = new Pager(page,limit);
        p.setRows(entityService.queryPageEntity(p,entityVo));
        p.setTotal(Long.valueOf(entityService.queryPageCount(entityVo)));
        return p;
    }

    @PostMapping("addEntityUpload")
    @ApiOperation("添加物品")
    @ResponseBody
    public ServerResponse<Entity> addEntityUpload(MultipartFile file, Entity entity, HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        String fileName = file.getOriginalFilename();
        String value = FileUtils.getExtensionWithoutDot(fileName);
        if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){
            String path = FileUtils.uploadPath(request,"imgEntity",user.getUserName()+"/");//把用户的图片存放到adming用户的img下
            try {

                String imgName = FileUtils.uploadFile(file, path);
                entity.setEntityCover("/upload/"+user.getUserName()+"/imgEntity/"+imgName);
                entity.setCreatTime(Calendar.getInstance().getTime());
                entity.setUserId(user.getId());
                entity.setOpenOrNot(0);
                entity.insert();
                return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
            } catch (Exception e) {
                e.printStackTrace();
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+entity.getEntityCover());
                return ServerResponse.createByError("上传异常");
            }
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("updateEntity")
    @ApiOperation("更新物品")
    @ResponseBody
    public ServerResponse<Entity> updateEntity(MultipartFile file, Entity entity, String deletImg, HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        if(null!=file){
            String fileName = file.getOriginalFilename();
            String value = FileUtils.getExtensionWithoutDot(fileName);
            if(MIMETypeEnum.JPEG.getValue().equals(value) || MIMETypeEnum.JPG.getValue().equals(value)|| MIMETypeEnum.PNG.getValue().equals(value)){
                String path = FileUtils.uploadPath(request,"imgEntity",user.getUserName()+"/");//把用户的图片存放到adming用户的img下
                try {
                    if(path!=null){
                        if(!StringUtils.isEmpty(deletImg)){
                            DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                        }
                        String imgName = FileUtils.uploadFile(file, path);
                        entity.setEntityCover("/upload/"+user.getUserName()+"/imgEntity/"+imgName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+entity.getEntityCover());
                    return ServerResponse.createByError("上传异常");
                }
            }
        }

        return  entityService.updateById(entity)? ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE):ServerResponse.createByError(1,ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    @PostMapping("updateStatus")
    @ApiOperation(value = "冻结激活")
    @ResponseBody
    public ServerResponse updateStatus(@Validated(value = {Groups.Default.class, Groups.Update.class}) Entity entity){
        if(!StringUtils.isEmpty(entity)&&entityService.updateAllColumnById(entity)&&!StringUtils.isEmpty(entity.getOpenOrNot())){
            return entity.getOpenOrNot()==0?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                    entity.getOpenOrNot()==1?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_ACTIVATE):
                            ServerResponse.createBySuccess("操作失败");
        }
        return ServerResponse.createByError("操作失败");
    }

    @PostMapping("deletNew")
    @ApiOperation("删除物品")
    @ResponseBody
    public ServerResponse<String> deletNew(Entity entity){
        if(StringUtils.isEmpty(entity.getEntityCover())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个233文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/233下的文件夹
            entity.setEntityCover("233");
        }
        return entityService.deleteById(entity.getId())?
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+entity.getEntityCover())?
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

