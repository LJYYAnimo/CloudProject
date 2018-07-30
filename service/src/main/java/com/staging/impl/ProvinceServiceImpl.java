package com.staging.impl;

import com.staging.entity.Province;
import com.staging.mapper.ProvinceMapper;
import com.staging.service.ProvinceService;
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
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {


    @Override
    public Province selectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Province selectByProvinceName(String provinceName) {
        return baseMapper.selectByProvinceName(provinceName);
    }
}
