package wang.peidun.mhstudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wang.peidun.mhstudio.entity.User;
import wang.peidun.mhstudio.service.IUserSercice;

/**
 * @Author: wangpd
 * @Date: 2019-06-27 15:04
 */
@Controller
public class IndexController {

    @Autowired
    private IUserSercice userSercice;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login/submit")
    public String loginSubmit(String username, String password) {
        if (username != null && password == null) {
            username = username.trim();
            User user = userSercice.login(username, password);
            if (user == null) {

            }
        }
        return "login";
    }
}
