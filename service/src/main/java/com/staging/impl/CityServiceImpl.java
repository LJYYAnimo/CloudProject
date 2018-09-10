package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.City;
import com.staging.entity.vo.CityVo;
import com.staging.mapper.CityMapper;
import com.staging.service.CityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Override
    public List<CityVo> queryPage(Pager pager) {
        return baseMapper.queryPage(pager);
    }

    @Override
    public City selectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public City selectByCityName(String cname) {
        return baseMapper.selectByCityName(cname);
    }
}
