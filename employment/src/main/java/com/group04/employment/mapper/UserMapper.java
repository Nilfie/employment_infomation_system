package com.group04.employment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group04.employment.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
