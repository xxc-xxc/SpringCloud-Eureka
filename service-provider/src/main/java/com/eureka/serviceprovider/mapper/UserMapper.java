package com.eureka.serviceprovider.mapper;

import com.eureka.serviceprovider.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

}
