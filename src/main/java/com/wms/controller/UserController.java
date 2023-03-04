package com.wms.controller;


import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wms
 * @since 2023-03-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserService UserService;

    @GetMapping("list")
    public List<User> list(){
        return  UserService.list();
    }

}
