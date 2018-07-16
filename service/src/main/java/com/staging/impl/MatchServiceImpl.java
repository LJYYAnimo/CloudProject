package com.staging.impl;

import com.staging.entity.Match;
import com.staging.mapper.MatchMapper;
import com.staging.service.MatchService;
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
public class MatchServiceImpl extends ServiceImpl<MatchMapper, Match> implements MatchService {

}
