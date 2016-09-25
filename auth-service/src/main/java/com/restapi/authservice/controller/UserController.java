package com.restapi.authservice.controller;

import com.restapi.authservice.domain.User;
import com.restapi.authservice.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by pallav on 25/9/16.
 */

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
    	logger.info("===============");
    	logger.info("current user >>>>>>>>"+principal.getName());
    	logger.info("===============");
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
    	logger.info("===============");
    	logger.info("Request received for create new user.");
        userService.create(user);
        logger.info("Request for new user has been processed successfully.");
        logger.info("===============");
    }

}
