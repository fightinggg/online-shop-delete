package com.shop.orders.entity;

public class Orders {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.id
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.buyerId
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    private Integer buyerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.goodsId
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    private Integer goodsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.addressid
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    private Integer addressid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.counts
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    private Integer counts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.state
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    private String state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.id
     *
     * @return the value of orders.id
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.id
     *
     * @param id the value for orders.id
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.buyerId
     *
     * @return the value of orders.buyerId
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public Integer getBuyerid() {
        return buyerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.buyerId
     *
     * @param buyerid the value for orders.buyerId
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.goodsId
     *
     * @return the value of orders.goodsId
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public Integer getGoodsid() {
        return goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.goodsId
     *
     * @param goodsid the value for orders.goodsId
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.addressid
     *
     * @return the value of orders.addressid
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public Integer getAddressid() {
        return addressid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.addressid
     *
     * @param addressid the value for orders.addressid
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.counts
     *
     * @return the value of orders.counts
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.counts
     *
     * @param counts the value for orders.counts
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.state
     *
     * @return the value of orders.state
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.state
     *
     * @param state the value for orders.state
     *
     * @mbggenerated Wed May 06 00:05:41 CST 2020
     */
    public void setState(String state) {
        this.state = state;
    }
}