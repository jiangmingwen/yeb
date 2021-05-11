package com.jay.server.mapper;

import com.jay.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jay
 * @since 2021-05-07
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户id获取菜单
     * @param id
     * @return
     */
    List<Menu> getMenuByAdminId(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenuWithRole();
}
