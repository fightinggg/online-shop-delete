package com.shop.gateway.entity;

public class UserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role.id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role.global_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    private Long globalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role.user_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user_role.role_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role.id
     *
     * @return the value of tb_user_role.id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role.id
     *
     * @param id the value for tb_user_role.id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role.global_id
     *
     * @return the value of tb_user_role.global_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public Long getGlobalId() {
        return globalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role.global_id
     *
     * @param globalId the value for tb_user_role.global_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public void setGlobalId(Long globalId) {
        this.globalId = globalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role.user_id
     *
     * @return the value of tb_user_role.user_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role.user_id
     *
     * @param userId the value for tb_user_role.user_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user_role.role_id
     *
     * @return the value of tb_user_role.role_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user_role.role_id
     *
     * @param roleId the value for tb_user_role.role_id
     *
     * @mbggenerated Thu May 14 13:32:17 CST 2020
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}