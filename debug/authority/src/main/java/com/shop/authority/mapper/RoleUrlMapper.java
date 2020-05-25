package com.shop.authority.mapper;

import com.shop.authority.entity.RoleUrl;
import com.shop.authority.entity.RoleUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUrlMapper {
    int countByExample(RoleUrlExample example);

    int deleteByExample(RoleUrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleUrl record);

    int insertSelective(RoleUrl record);

    List<RoleUrl> selectByExample(RoleUrlExample example);

    RoleUrl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleUrl record, @Param("example") RoleUrlExample example);

    int updateByExample(@Param("record") RoleUrl record, @Param("example") RoleUrlExample example);

    int updateByPrimaryKeySelective(RoleUrl record);

    int updateByPrimaryKey(RoleUrl record);
}