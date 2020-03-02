package com.interview.defront.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.interview.defront.domain.DefrontUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DefrontUserMapper extends BaseMapper<DefrontUser> {

    DefrontUser queryByOpenId(String weixinOpenid);
}
