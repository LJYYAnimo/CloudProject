package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.Works;
import com.staging.entity.vo.WorksVo;
import com.staging.mapper.WorksMapper;
import com.staging.service.WorksService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Service
public class WorksServiceImpl extends ServiceImpl<WorksMapper, Works> implements WorksService {

    @Autowired
    private WorksMapper worksMapper;

    @Override
    public List<WorksVo> queryPageWorks(Pager pager, WorksVo worksVo) {
        return worksMapper.queryPageWorks(pager,worksVo);
    }

    @Override
    public int queryPageCount(WorksVo worksVo) {
        return worksMapper.queryPageCount(worksVo);
    }
}
