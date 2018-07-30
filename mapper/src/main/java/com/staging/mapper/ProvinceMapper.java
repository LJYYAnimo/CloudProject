package com.staging.mapper;

import com.staging.entity.Province;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface ProvinceMapper extends BaseMapper<Province> {

    /**
     * 根据Id来查询名称
     * @param id
     * @return
     */
    Province selectById(Integer id);

    /**
     * 根据名称来查询Id
     * @param provinceName
     * @return
     */
    Province selectByProvinceName(String provinceName);

}
