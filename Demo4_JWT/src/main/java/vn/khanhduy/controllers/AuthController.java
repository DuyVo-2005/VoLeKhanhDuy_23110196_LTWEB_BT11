package vn.khanhduy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping("login")
    public String index() {
        return "login";   // trả về login.html (templates/login.html)
    }

    @GetMapping("user/profile")
    public String profile() {
        return "profile"; // trả về profile.html (templates/profile.html)
    }
}
