package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.School;
import com.staging.mapper.SchoolMapper;
import com.staging.service.SchoolService;
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
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {


    @Override
    public Pager selectSchool(Pager pager, School school) {
        pager.setRows(baseMapper.selectSchool(pager,school));
        pager.setTotal(baseMapper.count(school));
        return pager;
    }
}
