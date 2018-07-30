package com.staging.impl;

import com.staging.entity.Address;
import com.staging.mapper.AddressMapper;
import com.staging.service.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Override
    public Address selectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Address selectByAddressName(String addressName) {
        return baseMapper.selectByAddressName(addressName);
    }
}
