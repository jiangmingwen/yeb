package com.jay.server.controller;


import com.jay.server.pojo.Menu;
import com.jay.server.pojo.RespBean;
import com.jay.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
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
 * @author Jay
 * @since 2021-05-07
 */
@RestController
@RequestMapping("/api/system/cfg")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation("通过用户id查询菜单")
    @GetMapping("/menu")
    public RespBean  getMenuByAdminId(){
        List<Menu> menus =  menuService.getMenuByAdminId();
        return  RespBean.success(menus);
    }

}
