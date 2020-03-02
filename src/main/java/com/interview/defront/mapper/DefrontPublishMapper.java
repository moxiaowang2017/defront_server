package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.interview.defront.domain.DefrontPublish;
import com.interview.defront.domain.DefrontUser;
import com.interview.defront.dto.DefrontPublishDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface DefrontPublishMapper extends BaseMapper<DefrontPublish> {

//    List<DefrontPublishDto> findAllAndPage(Page<Map<String,Object>> page);
}
