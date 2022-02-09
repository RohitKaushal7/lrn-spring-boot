package com.dev.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String getHome(){
        return "Hello something..";
    }

    @GetMapping(params = {"id"}, path = "/")
    public String getHome(@RequestParam("name") String name){
        if(name.length() > 0){
            return "Hello " + name;
        }
        return "Hello World";
    }
}
