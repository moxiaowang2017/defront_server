package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontPersonalQuestion;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PersonalQuestionMapper extends BaseMapper<DefrontPersonalQuestion> {

    /**
     * 根据userId获取个人常见问题
     * @param userId
     * @param question
     * @return
     */
    IPage<DefrontPersonalQuestion> queryByParam(Page<DefrontPersonalQuestion> page, String userId, String question);

}
