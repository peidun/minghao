package wang.peidun.mhstudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wangpd
 * @Date: 2019-06-27 15:04
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/download")
    public String download() {
        return "download";
    }
}
