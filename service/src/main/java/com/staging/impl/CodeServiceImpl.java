package com.staging.impl;

import com.staging.entity.Code;
import com.staging.mapper.CodeMapper;
import com.staging.service.CodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

}
