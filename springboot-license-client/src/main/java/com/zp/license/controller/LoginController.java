package com.zp.license.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: license
 * @ClassName controller
 * @Description TODO
 * @date 2022/12/9 17:33
 * @Version 1.0
 */
@RestController
@Api(tags = "测试")
@RequestMapping("/text")
public class LoginController {


    @ApiOperation("登录")
    @GetMapping("/login")
    public Map<String, Object> test(@RequestParam(required = true) String loginName, @RequestParam(required = true) String password) {
        Map<String, Object> result = new HashMap<>(1);
        result.put("code", 200);
        result.put("mes", "登录成功");
        return result;

    }
}