package com.gaoke.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/s")
public class PersonController {


    @GetMapping("/users")
    @ResponseBody
    public String usersList () {


        return "true";
    }
    @PostMapping("/users")
    @ResponseBody
    public String usersList1 () {


        return "true";
    }
    @PostMapping("/users2")
    public String usersList2 (@RequestParam("param") String param) {


        return "true";
    }
}