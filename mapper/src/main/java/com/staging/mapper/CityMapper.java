package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.common.PagerLayui;
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

}
