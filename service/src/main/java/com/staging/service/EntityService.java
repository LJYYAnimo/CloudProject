package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.Entity;
import com.baomidou.mybatisplus.service.IService;
import com.staging.entity.vo.EntityVo;
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
public interface EntityService extends IService<Entity> {


    List<EntityVo> queryPageEntity(Pager pager,EntityVo entityVo);

    int queryPageCount(EntityVo entityVo);
}
