package pl.borowik.akademia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(){

        return "login-form";
    }

//    @GetMapping
//    public String hello(){

//        return "hello";
//    }


}
