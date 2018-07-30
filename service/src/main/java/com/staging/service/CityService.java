package com.staging.service;

import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.entity.City;
import com.baomidou.mybatisplus.service.IService;
import com.staging.entity.vo.CityVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface CityService extends IService<City> {

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
