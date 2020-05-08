package com.shop.email.mapper;

import com.shop.email.entity.Orders;
import com.shop.email.entity.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int countByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int deleteByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int insert(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int insertSelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    List<Orders> selectByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    Orders selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int updateByPrimaryKeySelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbggenerated Fri May 08 13:43:28 CST 2020
     */
    int updateByPrimaryKey(Orders record);
}