package com.tr.dynamic.datasource.controller;

import com.tr.dynamic.datasource.config.DataSourceContextHolder;
import com.tr.dynamic.datasource.entity.User;
import com.tr.dynamic.datasource.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author taorun
 * @date 2022/12/16 15:12
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

//    @ApiOperation(value = "根据数据源查询", notes = "数据源：db1, db2")
//    @GetMapping("/{dataSource}/{id}")
//    public User findById(@PathVariable String dataSource, @PathVariable Integer id) {
//        return userService.findById(id);
//    }


    @ApiOperation(value = "根据id查询")
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

}
