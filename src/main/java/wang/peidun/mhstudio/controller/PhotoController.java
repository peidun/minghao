package wang.peidun.mhstudio.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wang.peidun.mhstudio.dto.Response;
import wang.peidun.mhstudio.entity.Photo;
import wang.peidun.mhstudio.entity.User;
import wang.peidun.mhstudio.enums.MySessionAttribute;
import wang.peidun.mhstudio.enums.ResponseStatus;
import wang.peidun.mhstudio.service.IPhotoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 16:50
 */
@Controller
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @Value("${upload.file.path}")
    private String filePath;

    @RequestMapping(value = "/download")
    public String index() {
        return "download";
    }


    @RequestMapping(value = "/download/submit")
    public String download(String password, HttpServletResponse response, Model model) {
        Photo photo = photoService.getByPassword(password);
        if (photo == null) {
            model.addAttribute("message", "下载码错误");
            return "download";
        }

        String fileName = photo.getFileName();

        File file = new File(filePath, photo.getPath());

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream outputStream = response.getOutputStream()) {
            //指明为下载
            response.setContentType("application/x-download");

            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            response.addHeader("Content-Length", String.valueOf(file.length()));

            byte[] buffer = new byte[1024];
            int i = inputStream.read(buffer);
            while (i != -1) {
                outputStream.write(buffer, 0, i);
                i = inputStream.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(MySessionAttribute.LOGIN_USER.getKey());
        if (user == null) {
            model.addAttribute("from", "upload");
            return "login";
        }
        return "upload";
    }

    @RequestMapping(value = "/upload/submit")
    @ResponseBody
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return new Response(ResponseStatus.UPLOAD_FAIL);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 文件存储路径
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileName;

        File dest = new File(filePath, newFileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);

            Photo photo = new Photo();
            photo.setFileName(fileName);
            photo.setPath(newFileName);
            photo.setPassword(UUID.randomUUID().toString().replaceAll("-", ""));
            photo.setStatus(0);
            photo.setUploadTime(new Date());
            photoService.save(photo);

            return new Response(ResponseStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response(ResponseStatus.UPLOAD_FAIL);
    }
}
