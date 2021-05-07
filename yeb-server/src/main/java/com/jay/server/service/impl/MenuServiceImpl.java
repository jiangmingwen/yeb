package com.jay.server.service.impl;

import com.jay.server.pojo.Menu;
import com.jay.server.mapper.MenuMapper;
import com.jay.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jay
 * @since 2021-05-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
