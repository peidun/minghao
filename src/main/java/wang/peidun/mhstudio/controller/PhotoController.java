package wang.peidun.mhstudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wang.peidun.mhstudio.entity.Photo;
import wang.peidun.mhstudio.service.IPhotoService;

/**
 * @Author: wangpd
 * @Date: 2019-07-10 16:50
 */
@Controller
@RequestMapping(value = "download")
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @Value("${mh.file-path}")
    private String filePath;

    @RequestMapping(value = "{id}")
    public ModelAndView download(ModelAndView model, @PathVariable("id") String id) {
        model.setViewName("download");
        Photo photo = photoService.getById(id);
        if (photo != null)
            model.addObject("mail", photo.getEmail());
        return model;
    }

    @RequestMapping(value = "download")
    public String download() {

        return "index";
    }
}
