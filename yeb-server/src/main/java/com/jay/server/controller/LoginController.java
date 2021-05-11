package com.jay.server.controller;

import com.jay.server.pojo.Admin;
import com.jay.server.pojo.AdminLoginParam;
import com.jay.server.pojo.RespBean;
import com.jay.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Api(tags = "LoginController")
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation("登录之后返回token")
    @PostMapping("/unauth/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), adminLoginParam.getCode(), request);
    }

    @ApiOperation("获取当前登录的用户信息")
    @GetMapping("adminInfo")
    public RespBean getAdminInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String username = principal.getName();

        Admin admin = adminService.getAdminByUsername(username);
        admin.setPassword(null);
        admin.setRoles(adminService.getRoles(admin.getId()));
        return RespBean.success(admin);

    }

    @ApiOperation("退出登录，前端自己清除token")
    @PostMapping("/unauth//logout")
    public RespBean logout() {
        return RespBean.success("退出登录成功");
    }
}
