package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontArticle;
import com.interview.defront.mapper.DefrontArticleMapper;
import com.interview.defront.service.DefrontArticleService;
import org.springframework.stereotype.Service;


@Service
public class DefrontArticleServiceImpl extends ServiceImpl<DefrontArticleMapper, DefrontArticle> implements DefrontArticleService {

}
