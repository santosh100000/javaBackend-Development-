package com.example.L06springbootmvcdemo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/web")
public class WebController {

    @GetMapping("/hello")
    public String getWebPage(){
        return "web hello";
    }
    @GetMapping("/static")
    public String getStaticMenu(){
        //return "static-menu.html";
        //return "menu-with-js.html";
     return  " menu-with-js.html";
    }
}
