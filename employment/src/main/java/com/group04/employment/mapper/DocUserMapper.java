package com.group04.employment.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group04.employment.document.DocUser;
import com.group04.employment.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocUserMapper extends BaseMapper<DocUser> {

    DocUser selectOne(QueryWrapper<User> queryWrapper);
}

