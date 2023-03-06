package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //新增
    @PostMapping("/save")
    public boolean save (@RequestBody User user){
        return UserService.save(user);
    }
    // 删除
    @GetMapping("/delete")
    public boolean delete (Integer id){
        return UserService.removeById(id);
    }
    // 查询(模糊 ，匹配)
    @PostMapping("/listP")
    public boolean listP (@RequestBody User user){
        LambdaQueryWrapper<User> LambdaQueryWrapper = new LambdaQueryWrapper();
        LambdaQueryWrapper.like(User::getName,user.getName());
        return UserService.saveOrUpdate(user);
    }

    // 修改
    @PostMapping("/mod")
    public boolean mod (@RequestBody User user){
        return UserService.updateById(user);
    }
    //    新增或者修改
    @PostMapping("/seveOrMod")
    public boolean seveOrMod (@RequestBody User user){
        return UserService.saveOrUpdate(user);
    }
    //分页
    @PostMapping("/listPage")
    public  List<User> listPage(){


        return  null;
    }

}
