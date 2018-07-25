package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.SdSchool;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.SdSchoolVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-20
 */
public interface SdSchoolMapper extends BaseMapper<SdSchool> {

    List<SdSchoolVo> selectSdSchoolVoPager(@Param("pager") Pager pager, @Param("sdSchool") SdSchool sdSchool);

    Long countSdSchoolVo(@Param("sdSchool") SdSchool sdSchool);
}
