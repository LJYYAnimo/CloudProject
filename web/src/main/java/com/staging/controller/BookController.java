package com.staging.controller;


import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.enums.MIMETypeEnum;
import com.staging.common.utils.DeleteFileUtil;
import com.staging.common.utils.FileUtils;
import com.staging.entity.Book;
import com.staging.entity.User;
import com.staging.entity.Video;
import com.staging.entity.vo.BookVo;
import com.staging.entity.vo.VideoVo;
import com.staging.service.BookService;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.Api;
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
 *  书籍管理前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/book")
@Api(tags = "1.0", description = "书籍管理", value = "书籍管理")
public class BookController {

    @Autowired
    private BookService bookService;

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("page")
    public String page(){
        return "book/book";
    }


    @GetMapping("addUpdateBook")
    public String addUpdateVideo(){
        return "book/addUpdateBook";
    }


    @GetMapping("article")
    public String Article(){
        return "book/article";
    }


    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(Integer page, Integer limit, BookVo bookVo){
        logger.info("进入书籍分页查询:"+bookVo.toString());
        Pager p = new Pager(page,limit);
        p.setRows(bookService.queryPageBook(p,bookVo));
        p.setTotal(Long.valueOf(bookService.queryPageCount(bookVo)));
        return p;
    }

    @PostMapping("addBookUpload")
    @ApiOperation("添加书籍")
    @ResponseBody
    public ServerResponse<Book> addnewupload(MultipartFile fileImg,MultipartFile fileZIP, Book book, HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        if(!StringUtils.isEmpty(fileImg)&&!StringUtils.isEmpty(fileZIP)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if((MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img))&&
                    (MIMETypeEnum.RAR.getValue().equals(zip)||MIMETypeEnum.ZIP.getValue().equals(zip))){
                String pathImg = FileUtils.uploadPath(request,"imgBook",user.getUserName()+"/");//把用户的图片存放到用户的imgBook文件夹下
                String pathZIP = FileUtils.uploadPath(request,"ZIPBook",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPBook文件夹下
                try {
                    String imgName = FileUtils.uploadFile(fileImg, pathImg);
                    book.setImg("/upload/"+user.getUserName()+"/imgBook/"+imgName);
                    String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                    book.setUrl("/upload/"+user.getUserName()+"/ZIPBook/"+zipName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createByError("你上传的图片格式不正确");
                }
            }else {
                return ServerResponse.createByError("请上传正确的文件");
            }
            book.setUserId(user.getId());
            book.setCreateTime(Calendar.getInstance().getTime());
            book.setBookAudit(1);
            bookService.insert(book);
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }

        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("updateBook")
    @ApiOperation("更新书籍")
    @ResponseBody
    public ServerResponse<Book> updateCase(MultipartFile fileImg, MultipartFile fileZIP, Book book, String deletImg,
                                               String deletfileZIP , HttpServletRequest request){
        User user = ShiroUtils.getUserSession(request);
        if(StringUtils.isEmpty(user)){
            return ServerResponse.createByError("你的登入信息已过期请刷新页面重写登入");
        }
        try {
            addImg(fileImg, book, deletImg, request, user);
            addZIP(fileZIP, book, deletfileZIP, request, user);
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByError("上传错误");
        }
        book.setBookAudit(1);
        book.setUpdateTime(Calendar.getInstance().getTime());
        bookService.updateById(book);
        return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
    }

    @PostMapping("deletBook")
    @ApiOperation("删除书籍")
    @ResponseBody
    public ServerResponse<Book> deletWorks(Book book){
        if(StringUtils.isEmpty(book.getImg())){
            //如果图片路径为空就让DeleteFileUtil.delete删除一个名为null文件夹，这样就不会出现只删除/static/下的所有文件，而是删除/static/null下的文件夹
            book.setImg("null");
        }
        if(StringUtils.isEmpty(book.getUrl())){
            book.setUrl("null");
        }
        return book.deleteById()? DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+book.getImg())&&
                DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+book.getUrl())?
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):
                ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET)
                :ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("updateStatus")
    @ApiOperation("冻结或激活书籍")
    @ResponseBody
    public ServerResponse<Book> updateStatus(Book book){
        book.setAuditTime(Calendar.getInstance().getTime());
        return book.getBookAudit()==2&&book.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_STATUS)
                :book.getBookAudit()==3&&book.updateById()?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                ServerResponse.createByError("操作失败");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============处理所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);//这句一个不要存在，不然还是处理不了时间转换
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    private void addZIP(MultipartFile fileZIP, Book book, String deletfileZIP, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileZIP)){
            String zip = FileUtils.getExtensionWithoutDot(fileZIP.getOriginalFilename());
            if(MIMETypeEnum.RAR.getValue().equals(zip)||MIMETypeEnum.ZIP.getValue().equals(zip)){
                if(!StringUtils.isEmpty(deletfileZIP)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletfileZIP);//删除原来图片
                }
                String pathZIP = FileUtils.uploadPath(request,"ZIPBook",user.getUserName()+"/");//把用户的zip附件存放到用户的ZIPBook文件夹下
                String zipName = FileUtils.uploadFile(fileZIP, pathZIP);
                book.setUrl("/upload/"+user.getUserName()+"/ZIPBook/"+zipName);
            }
        }
    }

    private void addImg(MultipartFile fileImg, Book book, String deletImg, HttpServletRequest request, User user) throws IOException {
        if(!StringUtils.isEmpty(fileImg)){
            String img = FileUtils.getExtensionWithoutDot(fileImg.getOriginalFilename());
            if(MIMETypeEnum.JPEG.getValue().equals(img) || MIMETypeEnum.JPG.getValue().equals(img)|| MIMETypeEnum.PNG.getValue().equals(img)){
                if(!StringUtils.isEmpty(deletImg)){
                    DeleteFileUtil.delete(FileUtils.getClasspath()+"static"+deletImg);//删除原来图片
                }
                String pathImg = FileUtils.uploadPath(request,"imgBook",user.getUserName()+"/");//把用户的图片存放到用户的imgBook文件夹下
                String imgName = FileUtils.uploadFile(fileImg, pathImg);
                book.setImg("/upload/"+user.getUserName()+"/imgBook/"+imgName);
            }
        }
    }
}

