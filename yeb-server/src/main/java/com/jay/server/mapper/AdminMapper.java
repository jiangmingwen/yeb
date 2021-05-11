package com.jay.server.mapper;

import com.jay.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jay.server.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jay
 * @since 2021-05-07
 */
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 根据用户id查询角色
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
