package kz.islam.study.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/firstPage")
    public String firstPage() {
        return "people/firstPage";
    }
}
