package com.shop.integral.dao;

import com.shop.integral.entity.IntegralTransaction;
import com.shop.integral.mapper.IntegralTransactionMapper;
import org.apache.ibatis.annotations.Select;

public interface IntegralTransactionDao extends IntegralTransactionMapper {
    @Select("select * from integralTransaction where ordersId = #{ordersId}")
    IntegralTransaction selectByPrimaryKey(Integer ordersId);
}
