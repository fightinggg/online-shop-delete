package com.shop.phone.dao;

import com.shop.phone.entity.PhoneTransaction;
import com.shop.phone.mapper.PhoneTransactionMapper;
import org.apache.ibatis.annotations.Select;

public interface PhoneTransactionDao extends PhoneTransactionMapper {

    @Select("select * from phoneTransaction where ordersId = #{id}")
    PhoneTransaction selectByPrimaryKey(Integer id);
}
