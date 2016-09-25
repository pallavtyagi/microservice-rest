package com.restapi.authservice.service;

import com.restapi.authservice.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pallav on 25/9/16.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
