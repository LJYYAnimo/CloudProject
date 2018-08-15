package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.CaseFile;
import com.baomidou.mybatisplus.service.IService;
import com.staging.entity.vo.CaseFileVo;
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
public interface CaseFileService extends IService<CaseFile> {

    List<CaseFileVo> queryPageCase(Pager pager,CaseFileVo caseFileVo);

    int queryPageCount(CaseFileVo caseFileVo);

}
