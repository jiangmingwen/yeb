package com.jay.server.controller;

import com.jay.server.pojo.AdminLoginParam;
import com.jay.server.pojo.RespBean;
import com.jay.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation("登录之后返回token")
    @PostMapping("/login")
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }
}
