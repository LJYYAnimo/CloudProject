package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.CaseFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.CaseFileVo;
import com.staging.entity.vo.WorksVo;
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
public interface CaseFileMapper extends BaseMapper<CaseFile> {


    List<CaseFileVo> queryPageCase(@Param("pager")Pager pager, @Param("caseFileVo") CaseFileVo caseFileVo);

    int queryPageCount(@Param("caseFileVo") CaseFileVo caseFileVo);
}
