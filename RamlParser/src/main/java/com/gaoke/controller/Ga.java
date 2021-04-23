package com.gaoke.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/")
public class Ga {


    @GetMapping("/cases")
    @ResponseBody
    public String cases (@RequestParam("param") String param) {


        return "true";
    }
}