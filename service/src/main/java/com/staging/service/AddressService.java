package com.staging.service;

import com.staging.entity.Address;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface AddressService extends IService<Address> {

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
