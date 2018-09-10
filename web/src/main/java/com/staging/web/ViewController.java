package com.staging.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.ServerResponse;
import com.staging.entity.*;
import com.staging.entity.vo.RolePermissionVo;
import com.staging.service.*;
import com.staging.shiro.config.constant.ShiroConstant;
import com.staging.shiro.config.utils.ShiroUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class ViewController {

    /**
     * 角色Service
     */
    @Autowired
    private RoleService roleService;

    /**
     * 权限Service
     */
    @Autowired
    private PermissionService permissionService;

    /**
     * 角色权限Service
     */
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 用户角色Service
     */
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private SchoolTypeService schoolTypeService;

    /**
     * 用户类型Service
     */
    @Autowired
    private UserTypeService userTypeService;


    @GetMapping("home")
    public String home(ModelMap map){
        map.addAttribute("permissionVo",getPermission().getData());
        return "home";
    }

    @GetMapping("/book/page")
    public String bookPage(){
        return "book/book";
    }

    @GetMapping("/book/addUpdateBook")
    public String addUpdateVideo(){
        return "book/addUpdateBook";
    }


    @GetMapping("/book/article")
    public String bookArticle(){
        return "book/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:39
     * @Description:跳转课件管理的页面
     *
     */
    @GetMapping("/caseFile/page")
    public String caseFilePage(){
        return "caseFile/caseFile";
    }


    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:40
     * @Description:添加课件管理的页面
     *
     */
    @GetMapping("/caseFile/addUpdateCaseFile")
    public String addUpdateCaseFile(){
        return "caseFile/addUpdateCaseFile";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 14:29
     * @Description: 查看课件详情的页面跳转
     *
     */
    @GetMapping("/caseFile/article")
    public String caseFileArticle(){
        return "caseFile/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转课件类型管理页面
     *
     */
    @GetMapping("/caseType/page")
    public String caseTypePage(){
        return "caseType/caseType";
    }

    @GetMapping("/city/page")
    public String cityPage(){
        return "city/city";
    }

    @GetMapping("/entity/page")
    public String entityPage(){
        return "entity/entity";
    }

    @GetMapping("/entity/addUpdateEntity")
    public String entityAddUpdateEntity(){
        return "entity/addUpdateEntity";
    }

    @GetMapping("/entity/article")
    public String entityArticle(){
        return "entity/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/20 15:12
     * @Description:大赛管理的页面跳转
     *
     */
    @GetMapping("/match/page")
    public String matchPage(){
        return "match/match";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看大赛详情的页面跳转
     *
     */
    @GetMapping("/match/article")
    public String matchArticle(){
        return "match/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转资讯管理的页面
     *
     */
    @GetMapping("/news/page")
    public String newsPage(){
        return "news/news";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:40
     * @Description:添加资讯管理的页面
     *
     */
    @GetMapping("/news/addUpdateNews")
    public String newsAddUpdateNews(){
        return "news/addUpdateNews";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看资讯详情的页面跳转
     *
     */
    @GetMapping("/news/article")
    public String newsArticle(){
        return "news/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/20 15:12
     * @Description:公告管理的页面跳转
     *
     */
    @GetMapping("/notice/page")
    public String noticePage(){
        return "notice/notice";
    }

    @GetMapping("/notice/addUpdateNotice")
    public String noticeAddUpdateNotice(){
        return "notice/addUpdateNotice";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看公告详情的页面跳转
     *
     */
    @GetMapping("/notice/article")
    public String noticeArticle(){
        return "notice/article";
    }


    @GetMapping("/province/page")
    public String provincePage(){
        return "province/province";
    }

    @GetMapping("/role/page")
    public String rolePage(){
        return "role/role";
    }

    @GetMapping("/schoolType/page")
    public String schoolPage(){
        return "school/schoolType";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:39
     * @Description:跳转软件管理的页面
     *
     */
    @GetMapping("/software/page")
    public String softwarePage(){
        return "software/software";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:40
     * @Description:添加软件管理的页面
     *
     */
    @GetMapping("/software/addUpdateSoftware")
    public String softwareAddUpdateSoftware(){
        return "software/addUpdateSoftware";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 14:29
     * @Description: 查看软件详情的页面跳转
     *
     */
    @GetMapping("/software/article")
    public String softwareArticle(){
        return "software/article";
    }

    @GetMapping("/userType/page")
    public String userTypePage(){
        return "user/userType";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转课件类型管理页面
     *
     */
    @GetMapping("/videoClassz/page")
    public String videoClasszPage(){
        return "videoClassz/videoClassz";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:39
     * @Description:教学视频的管理
     *
     */
    @GetMapping("/video/page")
    public String videoPage(){
        return "video/video";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/11 16:40
     * @Description:添加视频的页面
     *
     */
    @GetMapping("/video/addUpdateVideo")
    public String videoAddUpdateVideo(){
        return "video/addUpdateVideo";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/8/19 14:29
     * @Description: 查看课视频的页面跳转
     *
     */
    @GetMapping("/video/article")
    public String videoArticle(){
        return "video/article";
    }

    @GetMapping("/video/PreviewVideo")
    public String videoPreviewVideo(){
        return "video/PreviewVideo";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转作品管理的页面
     *
     */
    @GetMapping("/works/page")
    public String worksPage(){
        return "works/works";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:40
     * @Description:添加作品管理的页面
     *
     */
    @GetMapping("/works/addUpdateWorks")
    public String worksAddUpdateWorks(){
        return "works/addUpdateWorks";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 查看作品详情的页面跳转
     *
     */
    @GetMapping("/works/article")
    public String worksArticle(){
        return "works/article";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/19 14:29
     * @Description: 预览3d文件效果
     *
     */
    @GetMapping("/works/queryStl")
    public String worksQueryStl(){
        return "works/STL";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转作品管理的页面
     *
     */
    @GetMapping("/worksType/page")
    public String worksTypePage(){
        return "worksType/worksType";
    }


    /**
     * 权限地址
     *
     * @return
     */
    @GetMapping("/permission/page")
    public String permissionPage(ModelMap map) {
        List<Permission> list = permissionService.selectList(new EntityWrapper<Permission>().eq("p_id", 0));
        map.addAttribute("permissionList", list);
        return "permission/permission";
    }

    @GetMapping("/school/page")
    public String schoolPage(ModelMap map){
        map.addAttribute("schoolTypes",schoolTypeService.selectList(new EntityWrapper<>()));
        return "school/school";
    }

    @GetMapping("/user/page")
    public String userPage(ModelMap map){
        map.addAttribute("userTypeList",userTypeService.selectList(new EntityWrapper<>()));
        return "user/user";
    }

    private ServerResponse getPermission(){
        Session session = ShiroUtils.getSession();
        User user = (User) session.getAttribute(ShiroConstant.USER);
        UserRole userRole = userRoleService.selectOne(new EntityWrapper<UserRole>().eq("uid",user.getId()));
        Role role = null;
        if(!StringUtils.isEmpty(userRole)){
            role= roleService.selectById(userRole.getRid());
        }
        //如果当前登录用户没有赋予角色 则Return
        if(StringUtils.isEmpty(role)&!user.getUserName().equals(ShiroConstant.ROLE)){
            return null;
        }
        RolePermissionVo permissionVo = new RolePermissionVo();
        //如果该用户的账号等于自己设定的常量账号
        if(user.getUserName().equals(ShiroConstant.ROLE )||role.getRole().equals(ShiroConstant.MAXROLE)) {
            permissionVo.setRoles(roleService.selectList(new EntityWrapper<>()));
            permissionVo.setPermissionVoList(ShiroUtils.getPermissionVo(permissionService.selectList(new EntityWrapper<>())));
            return ServerResponse.createBySuccess(permissionVo);
        }else {
            //这里只考虑了一个用户的情况下 如果多用户需要改sql
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            permissionVo.setRoles(roles);
            List<RolePermission> list = rolePermissionService.selectList(new EntityWrapper<RolePermission>().eq("rid", role.getId()));
            List<Permission> permissions = new ArrayList<>();
            for (RolePermission rolePermission : list) {
                permissions.add(permissionService.selectById(rolePermission.getPid()));
            }
            permissionVo.setPermissionVoList(ShiroUtils.getPermissionVo(permissions));
            return ServerResponse.createBySuccess(permissionVo);
        }
    }

}
