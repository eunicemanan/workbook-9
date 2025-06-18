package com.pluralsight.demo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    /*    @GetMapping("/") // INSTEAD OF REQMAPPING*/
    public String index(){
        return "Hello World!";
    }
}
