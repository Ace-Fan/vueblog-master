package com.wufan.vueblog.controller;


import com.wufan.vueblog.common.lang.Result;
import com.wufan.vueblog.entity.User;
import com.wufan.vueblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  用户前端控制器
 * </p>
 *
 * @author wufan
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        User user = userService.getById(1L);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {

        return Result.success(user);
    }
}
