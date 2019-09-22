package cn.qianshu.mybatis.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class PageController {  
      
    @RequestMapping("/admin")
    @PreAuthorize("hasAuthority('R_ADMIN')")
    public String admin(Model model, String tt) {  
        return "admin";  
    }  
      
    @RequestMapping("/hello")  
    public String hello(Model model, String tt) {  
        return "hello";  
    } 
    
    @RequestMapping("/index")  
    public String index(Model model, String tt) {  
        return "index";  
    }
}
