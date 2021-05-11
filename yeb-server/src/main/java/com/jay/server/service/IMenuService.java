package com.jay.server.service;

import com.jay.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jay
 * @since 2021-05-07
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户id查询菜单
     * @return
     */
    List<Menu> getMenuByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenuWithRole();
}
