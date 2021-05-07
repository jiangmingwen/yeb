package com.jay.server.service.impl;

import com.jay.server.pojo.Department;
import com.jay.server.mapper.DepartmentMapper;
import com.jay.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
