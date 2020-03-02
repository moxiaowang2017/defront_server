package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontMarkQuestion;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MarkQuestionMapper extends BaseMapper<DefrontMarkQuestion> {

    /**
     * 根据userId获取个人标注问题
     * @param userId
     * @param question
     * @return
     */
    IPage<DefrontMarkQuestion> queryByParam(Page<DefrontMarkQuestion> page, String userId, String question);

}
