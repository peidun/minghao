package wang.peidun.mhstudio.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.peidun.mhstudio.entity.Photo;
import wang.peidun.mhstudio.service.IPhotoService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 16:50
 */
@Controller
@RequestMapping(value = "/download")
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @Value("${upload.file.path}")
    private String filePath;

    @RequestMapping(value = "")
    public String index() {
        return "download";
    }


    @RequestMapping(value = "/submit")
    public void download(String password, HttpServletResponse response) {
        Photo photo = photoService.getByPassword(password);
        if (photo == null) {
            //return ResponseEntity.ok("error");
        }

        String fileName = photo.getFileName();

        File file = new File(filePath, fileName);

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {
            //指明为下载
            response.setContentType("application/x-download");

            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            response.addHeader("Content-Length", String.valueOf(file.length()));

            //把输入流copy到输出流
            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
