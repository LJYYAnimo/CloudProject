package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.Works;
import com.baomidou.mybatisplus.service.IService;
import com.staging.entity.vo.WorksVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface WorksService extends IService<Works> {


    List<WorksVo> queryPageWorks(Pager pager, WorksVo worksVo);

    int queryPageCount( WorksVo worksVo);
}
