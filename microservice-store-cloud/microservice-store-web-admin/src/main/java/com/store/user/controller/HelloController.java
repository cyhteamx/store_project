package com.store.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/in/{name}")
    public String available(@PathVariable String name) {
        return "Spring in Action "+name;
    }

    @RequestMapping(value = "/on/{name}")
    public String checkedOut(@PathVariable String name) {
        return "Spring Boot in Action book "+name;
    }

}
