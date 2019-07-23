package wang.peidun.mhstudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wang.peidun.mhstudio.dto.Response;
import wang.peidun.mhstudio.entity.Contact;
import wang.peidun.mhstudio.entity.User;
import wang.peidun.mhstudio.enums.MySessionAttribute;
import wang.peidun.mhstudio.enums.ResponseStatus;
import wang.peidun.mhstudio.service.IContactService;
import wang.peidun.mhstudio.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: wangpd
 * @Date: 2019-06-27 15:04
 */
@Controller
public class IndexController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUserService userService;

    @Autowired
    private IContactService contactService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/find")
    public String find() {
        return "find";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginout")
    public String loginOut() {
        HttpSession session = request.getSession();
        session.removeAttribute(MySessionAttribute.LOGIN_USER.getKey());
        return "redirect:/";
    }

    @RequestMapping(value = "/login/submit")
    public String loginSubmit(String username, String password, String from, Model model) {
        if (username != null && password != null) {
            username = username.trim();
            User user = userService.login(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute(MySessionAttribute.LOGIN_USER.getKey(), user);
                if (from != null && !from.equals("")) {
                    return "redirect:/" + from;
                } else {
                    return "redirect:/";
                }
            } else {
                model.addAttribute("message", "用户名或密码错误");
            }
        }
        model.addAttribute("from", from);
        return "login";
    }

    @RequestMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public Response contact(@RequestBody Contact contact) {
        contactService.save(contact);
        return new Response(ResponseStatus.OK);
    }
}
