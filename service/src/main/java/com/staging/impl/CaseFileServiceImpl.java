package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.CaseFile;
import com.staging.entity.vo.CaseFileVo;
import com.staging.mapper.CaseFileMapper;
import com.staging.service.CaseFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class CaseFileServiceImpl extends ServiceImpl<CaseFileMapper, CaseFile> implements CaseFileService {

    @Autowired
    private CaseFileMapper caseFileMapper;

    @Override
    public List<CaseFileVo> queryPageCase(Pager pager, CaseFileVo caseFileVo) {
        return caseFileMapper.queryPageCase(pager,caseFileVo);
    }

    @Override
    public int queryPageCount(CaseFileVo caseFileVo) {
        return caseFileMapper.queryPageCount(caseFileVo);
    }
}
