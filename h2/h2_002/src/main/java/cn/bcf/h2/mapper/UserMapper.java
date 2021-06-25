package cn.bcf.h2.mapper;


import cn.bcf.h2.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserEntity> selectAll();
}
