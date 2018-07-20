package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.School;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface SchoolService extends IService<School> {

    Pager selectSchool(Pager pager,School school);

}
