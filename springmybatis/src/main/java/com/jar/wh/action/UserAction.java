package com.jar.wh.action;

import com.jar.wh.pojo.User;
import com.jar.wh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @PostMapping("/add")
    @ResponseBody
    public String addUser(User user){
        String code = userService.addUser(user);
        return code;
    }

    @GetMapping("/index")
    public String index(Map map){
        map.put("msg", "world");
        return "index";
    }

    @GetMapping("/index2")
    public String index(Model model){
        model.addAttribute("msg","index2");
        return "index";
    }

    @GetMapping("/index3")
    public String index(HttpServletRequest request){
        request.setAttribute("msg", "index3");
        return "index";
    }

    @GetMapping("/index4")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("msg", "index4");
        return mav;
    }

}
