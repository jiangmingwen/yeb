package com.jay.server.service.impl;

import com.jay.server.pojo.MailLog;
import com.jay.server.mapper.MailLogMapper;
import com.jay.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
