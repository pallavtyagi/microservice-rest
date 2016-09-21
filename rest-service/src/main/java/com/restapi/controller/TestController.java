package com.restapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1", produces = {APPLICATION_JSON_VALUE})
public class TestController {


    @RequestMapping(value = "/names",produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<String>> imagesGet() {
        List<String> names = new ArrayList<String>();
        names.add("Test1");
        names.add("Test2");
        names.add("Test3");
        names.add("Test4");
        names.add("Test5");
        names.add("Test6");
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
}
