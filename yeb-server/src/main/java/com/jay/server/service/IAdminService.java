package com.jay.server.service;

import com.jay.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jay.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jay
 * @since 2021-05-07
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登录成功之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password,String code, HttpServletRequest request);

    /**
     * 根据用户名获取admin信息
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);
}
