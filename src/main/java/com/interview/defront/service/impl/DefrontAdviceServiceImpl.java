package com.interview.defront.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.interview.defront.domain.DefrontAdvice;
import com.interview.defront.domain.DefrontArticle;
import com.interview.defront.mapper.DefrontAdviceMapper;
import com.interview.defront.mapper.DefrontArticleMapper;
import com.interview.defront.service.DefrontAdviceService;
import com.interview.defront.service.DefrontArticleService;
import org.springframework.stereotype.Service;


@Service
public class DefrontAdviceServiceImpl extends ServiceImpl<DefrontAdviceMapper, DefrontAdvice> implements DefrontAdviceService {

}
