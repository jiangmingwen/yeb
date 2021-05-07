package com.jay.server.service.impl;

import com.jay.server.pojo.Employee;
import com.jay.server.mapper.EmployeeMapper;
import com.jay.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
