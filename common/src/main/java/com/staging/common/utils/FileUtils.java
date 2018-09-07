package com.staging.common.utils;

import com.staging.common.constant.FileConstants;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * 文件工具类，如获取WEB-INF目录根路径，获取classpath根路径，文件后缀判断等
 */
public class FileUtils {

    /**
     * 获取classpath根路径
     * @return classpath根路径
     */
    public static String getClasspath() {
        return FileUtils.class.getResource("/").getPath();
    }

    /**
     * 获取WEB-INF根路径
     * @return WEB-INF根路径
     */
    public static String getWEBINFPath() {
        String classPath = getClasspath();
        return classPath.substring(0, classPath.length() - ("classes".length() + 1));
    }

    /**
     * 通过指定的配置文件路径读取配置文件，如果是在web.xml文件中配置路径，则有两种形式，
     * 第一种形式为classpath:/autoload.properties
     * 第二种形式为/WEB-INF/config/autoload.properties
     * @param configLocation 配置文件的存放位置
     * @return 配置文件的路径
     */
    public static String getResourcePath(String configLocation) {
        String resourcePath = null;
        if (configLocation.contains(FileConstants.CLASSPATH)) {
            resourcePath = getClasspath() + configLocation.substring(FileConstants.CLASSPATH.length());
        } else if (configLocation.contains(FileConstants.WEB_INF)) {
            resourcePath = getWEBINFPath() + configLocation.substring(FileConstants.WEB_INF.length());
        }
        return resourcePath;
    }

    /**
     * 在网站根路径下创建文件上传的目录，可以是多级目录
     * @param request HttpServletRequest对象
     * @param dirs 在网站根目录下要创建的用于文件上传的目录，如static/uploads
     * @return
     */
//    public static String uploadPath(HttpServletRequest request, String dirs) {
////        String rootPath = WebUtils.getRootPath(request);
//        File uploadDir = null;
//        try {
//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            String rootPath = path.getAbsolutePath()+"static/images/upload/";
//            uploadDir = new File(rootPath, dirs);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return uploadDir.getAbsolutePath();
//    }
    /**
     * @Author: 95DBC
     * @Date: 2018/7/16 15:04
     * @param paths 动态拼接的后缀路径
     * @Description:
     *
     */
    public static String uploadPath(HttpServletRequest request, String dirs,String paths) {
        File uploadDir = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            String rootPath = path.getAbsolutePath()+"/static/upload/"+paths;
            uploadDir = new File(rootPath, dirs);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return uploadDir.getAbsolutePath();
    }

    /**
     * 获取指定文件名的后缀
     * @param fileName 完整的文件名称
     * @return 文件后缀，包括.符号，如.png
     */
    public static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 获取指定文件名的后缀，不包括.符号
     * @param filename 完事的文件名
     * @return 文件后缀，不包括.符号，如png
     */
    public static String getExtensionWithoutDot(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    /**
     * 判断给定的文件名是否符合指定的文件后缀
     * @param fileName 完整的文件名
     * @param extensions 需要比对文的件后缀，文件后缀包括.符号，多个文件后缀用英文半角,隔开
     * @return 如果文件名符合给定的后缀，则返回true，否则返回false
     */
    public static boolean checkExtension(String fileName, String extensions) {
        String[] exts = extensions.split(",");
        for (String ext : exts) {
            if (fileName.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取src根目录下的bpmn目录路径
     * @return
     */
    public static String getBPMNDir() {
        return getClasspath() + "/bpmn/";
    }

    /**
     * 获取指定文件名的不包括后缀部分的文件名，只一个.后缀的情况
     * @param filename 指定的文件名
     * @return 去除后缀的文件名
     */
    public static String getFileNameWithoutExt(String filename) {
        return filename.substring(0, filename.lastIndexOf("."));
    }

    /**
     * 获取指定文件名的不包括后缀部分的文件名，后缀可指定
     * @param filename 指定的文件名
     * @param extension 指定的后缀
     * @return 去除后缀的文件名
     */
    public static String getFileNameWithoutExt(String filename, String extension) {
        return filename.substring(0, filename.indexOf(extension));
    }

    /**
     * 通过比较文件的最后修改时间来判断一个文件是否比另外一个文件更新
     * @param filename 判断是否为新文件的文件路径
     * @param otherFilename 用来比较的文件的路径
     * @return 如果用来判断是否为新文件的文件对应的最后修改时间比用于比较的文件的最后修改时间大，则返回true，否则返回false
     */
    public static boolean isNew(String filename, String otherFilename) {
        return isNew(new File(filename), new File(otherFilename));
    }

    /**
     * 通过比较文件的最后修改时间来判断一个文件是否比另外一个文件更新
     * @param file 判断是否为新文件的文件对象
     * @param otherFile 用来比较的文件对象
     * @return 如果用来判断是否为新文件的文件对应的最后修改时间比用于比较的文件的最后修改时间大，则返回true，否则返回false
     */
    public static boolean isNew(File file, File otherFile) {
        return file.lastModified() > otherFile.lastModified();
    }


    /**
     * 判断指定目录中是否存在指定名称的文件
     * @param dir 指定的目录
     * @param name 文件名
     * @return 如果存在返回true，否则返回false
     */
    public static boolean exist(String dir, String name) {
        return new File(dir, name).exists();
    }

    /**
     * 删除指定目录及目录下的所有文件和目录
     * @param srcDir 需要删除的目录
     */
    public static void deleteFiles(String srcDir) {
        File file = new File(srcDir);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            System.out.println("子目录:"+files);
            if (files != null && files.length > 0) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        deleteFiles(f.getAbsolutePath());
                    } else {
                        f.delete();
                    }
                }
            }
        }
        file.delete();
    }

    /**
     * 文件上传
     * @param file
     * @param path
     * @return
     * @throws IOException
     */
    public static String uploadFile(MultipartFile file, String path) throws IOException {
        String exts = FileUtils.getExtensionWithoutDot(file.getOriginalFilename());
        String fileName = new Date().getTime()+"."+exts;//已当前时间戳来命名文件
        File tempFile = new File(path, fileName);
        if (!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdir();
        }
        if (tempFile.exists()){
            tempFile.delete();
        }
        tempFile.createNewFile();
        file.transferTo(tempFile);
        return tempFile.getName();
    }
    public static void export(Workbook workbook, String fileName){
        File file = new File(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
