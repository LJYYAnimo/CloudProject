package com.staging.service;

import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.entity.News;
import com.baomidou.mybatisplus.service.IService;
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
public interface NewsService extends IService<News> {

    List<News> queryPage(Pager pager);

    List<News> queryPageTitle(Pager pager,News news);
}
