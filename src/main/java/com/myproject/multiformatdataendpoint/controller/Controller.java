package com.myproject.multiformatdataendpoint.controller;

import com.myproject.multiformatdataendpoint.Entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/user/format/json", produces = { MediaType.APPLICATION_JSON_VALUE })
    public User getUserJson(){
        return new User("json-val", 22, "Json-Planet");
    }

    @GetMapping(value = "/user/format/xml", produces = { MediaType.APPLICATION_XML_VALUE })
    public User getUserXml(){
        return new User("xml", 22, "xml-universe");
    }


    @PostMapping(value = "/user/format/json", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public User postUserJson(@RequestBody User user){
        System.out.println(user.getName() +"-" + user.getAge() +"-" + user.getLocation());
        return user;
    }


    @PostMapping(value = "/user/format/xml", consumes = { MediaType.APPLICATION_XML_VALUE })
    public User postUserXml(@RequestBody User user){
        System.out.println(user.getName() +"-" + user.getAge() +"-" + user.getLocation());
        return user;
    }

    //Consumes Both type of format
    @PostMapping(value = "/user", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public User postUser(@RequestBody User user){
        System.out.println(user.getName() +"-" + user.getAge() +"-" + user.getLocation());
        return user;
    }
}
