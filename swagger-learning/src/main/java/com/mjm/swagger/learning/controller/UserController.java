package com.mjm.swagger.learning.controller;

import com.mjm.swagger.learning.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 一句话功能简述 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2019-07-04 15:48
 * @since
 */
@Api
@RestController
public class UserController {

    private List<User> userList = new ArrayList<>();


    @ApiOperation("查询用户信息")
    @GetMapping("/user/{id}")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "id", value = "主键", required = true)})
    public Object getUser(@PathVariable("id") Integer id) {
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @ApiOperation("新增用户信息")
    @PostMapping("/user/add")
    public Object getUser(@RequestBody @Valid User user) {
        userList.add(user);
        return user;
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/user/{id}")
    public Object updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        userList.add(user);
        return user;
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/user/{id}")
    public Object delUser(@PathVariable("id") Integer id) {
//        userList.remove();
        return id;
    }


}
