package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontQuestion;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QuestionMapper extends BaseMapper<DefrontQuestion> {

    /**
     * 根据问题类型和查询问题
     * @param type
     * @param question
     * @return
     */
    IPage<DefrontQuestion> queryByParam(Page<DefrontQuestion> page, Integer type, String question);

    /**
     * 根据问题类型和查询问题(未标注)
     * @param type
     * @param question
     * @return
     */
    IPage<DefrontQuestion> queryByParamNoMark(Page<DefrontQuestion> page, Integer type, String question,String userId);


}
