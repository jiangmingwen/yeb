package com.jay.server.service.impl;

import com.jay.server.pojo.Nation;
import com.jay.server.mapper.NationMapper;
import com.jay.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
