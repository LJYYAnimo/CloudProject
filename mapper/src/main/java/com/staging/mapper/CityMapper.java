package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.City;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.CityVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface CityMapper extends BaseMapper<City> {

    List<CityVo> queryPage(Pager pager);

    /**
     * 根据Id来查询名称
     * @param id
     * @return
     */
    City selectById(Integer id);

    /**
     * 根据名称来查询Id
     * @param cname
     * @return
     */
    City selectByCityName(String cname);

}
