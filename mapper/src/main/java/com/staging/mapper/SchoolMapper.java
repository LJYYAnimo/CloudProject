package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.School;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.SchoolTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface SchoolMapper extends BaseMapper<School> {

    List<SchoolTypeVo> selectSchool(@Param("pager") Pager pager, @Param("school") School school);

    Long count(@Param("school") School school);
}
