package com.staging.impl;

import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.entity.News;
import com.staging.mapper.NewsMapper;
import com.staging.service.NewsService;
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
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> queryPage(Pager pager) {
        return newsMapper.queryPage(pager);
    }

    @Override
    public List<News> queryPageTitle(Pager pager, News news) {
        return newsMapper.queryPageTitle(pager,news);
    }
}
