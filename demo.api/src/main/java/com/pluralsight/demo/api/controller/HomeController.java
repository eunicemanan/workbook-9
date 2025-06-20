package com.pluralsight.demo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    /*    @GetMapping("/") // INSTEAD OF REQMAPPING*/
    public String index(@RequestParam(defaultValue = "Eunice") String name){
        return "Hello " + name;
    }
}
