package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.SdSchool;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-20
 */
public interface SdSchoolService extends IService<SdSchool> {

    Pager selectSdSchoolVoPager(Pager pager,SdSchool sdSchool);

}
