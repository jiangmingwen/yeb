package com.jay.server.service.impl;

import com.jay.server.pojo.Admin;
import com.jay.server.pojo.Menu;
import com.jay.server.mapper.MenuMapper;
import com.jay.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jay
 * @since 2021-05-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuByAdminId() {

        return menuMapper.getMenuByAdminId(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

    }
}
