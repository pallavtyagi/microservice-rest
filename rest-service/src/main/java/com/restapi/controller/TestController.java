package com.restapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = {APPLICATION_JSON_VALUE})
public class TestController {


    //@PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/v1/names",produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<String>> imagesGet() {
        List<String> names = new ArrayList<>();
        String ROLE_READ="READ::";
        names.add(ROLE_READ+"Test1");
        names.add(ROLE_READ+"Test2");
        names.add(ROLE_READ+"Test3");
        names.add(ROLE_READ+"Test4");
        names.add(ROLE_READ+"Test5");
        names.add(ROLE_READ+"Test6");
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }

    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
    /*@RequestMapping(value = "/names",produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<String>> imagesGetAdmin() {
        List<String> names = new ArrayList<>();
        String ROLE_ADMIN="ADMIN::";
        names.add(ROLE_ADMIN+"Test1");
        names.add(ROLE_ADMIN+"Test2");
        names.add(ROLE_ADMIN+"Test3");
        names.add(ROLE_ADMIN+"Test4");
        names.add(ROLE_ADMIN+"Test5");
        names.add(ROLE_ADMIN+"Test6");
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }*/

}
