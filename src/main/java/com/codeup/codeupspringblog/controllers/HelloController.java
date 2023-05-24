package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
//    @GetMapping("/hello/{name1}/ and /{name2}")
//    @ResponseBody
//    public String sayHelloTwo(@PathVariable String name1,  @PathVariable String name2){
//        return name1 + " Says hello to " + name2 + "1";
//    }
//    @RequestMapping(path = "/hello/", method = RequestMethod.POST)
//    @ResponseBody
//    public String sayHelloTwo(@PathVariable String name1,  @PathVariable String name2) {
//        return name1 + " Says hello to " + name2 + "1";
//    }
}
