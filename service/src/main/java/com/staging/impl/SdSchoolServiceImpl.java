package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.SdSchool;
import com.staging.mapper.SdSchoolMapper;
import com.staging.service.SdSchoolService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-20
 */
@Service
public class SdSchoolServiceImpl extends ServiceImpl<SdSchoolMapper, SdSchool> implements SdSchoolService {



    @Override
    public Pager selectSdSchoolVoPager(Pager pager, SdSchool sdSchool) {
        pager.setRows(baseMapper.selectSdSchoolVoPager(pager, sdSchool));
        pager.setTotal(baseMapper.countSdSchoolVo(sdSchool));
        return pager;
    }
}
