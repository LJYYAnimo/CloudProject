package com.staging.mapper;

import com.staging.entity.Address;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.City;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface AddressMapper extends BaseMapper<Address> {


    /**
     * 根据Id来查询名称
     * @param id
     * @return
     */
    Address selectById(Integer id);

    /**
     * 根据名称来查询Id
     * @param addressName
     * @return
     */
    Address selectByAddressName(String addressName);

}
