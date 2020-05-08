package com.shop.email.dao;

import com.shop.email.entity.EmailTransaction;
import com.shop.email.mapper.EmailTransactionMapper;
import org.apache.ibatis.annotations.Select;

public interface EmailTransactionDao extends EmailTransactionMapper {
    @Select("select * from emailTransaction where ordersId = #{id}")
    EmailTransaction selectByPrimaryKey(Integer id);
}
