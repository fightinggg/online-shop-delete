package com.shop.email.mapper;

import com.shop.email.entity.EmailTransaction;
import com.shop.email.entity.EmailTransactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailTransactionMapper {
    int countByExample(EmailTransactionExample example);

    int deleteByExample(EmailTransactionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailTransaction record);

    int insertSelective(EmailTransaction record);

    List<EmailTransaction> selectByExample(EmailTransactionExample example);

    int updateByExampleSelective(@Param("record") EmailTransaction record, @Param("example") EmailTransactionExample example);

    int updateByExample(@Param("record") EmailTransaction record, @Param("example") EmailTransactionExample example);
}