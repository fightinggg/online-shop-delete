package com.shop.goods.entity;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGlobalIdIsNull() {
            addCriterion("global_id is null");
            return (Criteria) this;
        }

        public Criteria andGlobalIdIsNotNull() {
            addCriterion("global_id is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalIdEqualTo(Long value) {
            addCriterion("global_id =", value, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdNotEqualTo(Long value) {
            addCriterion("global_id <>", value, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdGreaterThan(Long value) {
            addCriterion("global_id >", value, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("global_id >=", value, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdLessThan(Long value) {
            addCriterion("global_id <", value, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdLessThanOrEqualTo(Long value) {
            addCriterion("global_id <=", value, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdIn(List<Long> values) {
            addCriterion("global_id in", values, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdNotIn(List<Long> values) {
            addCriterion("global_id not in", values, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdBetween(Long value1, Long value2) {
            addCriterion("global_id between", value1, value2, "globalId");
            return (Criteria) this;
        }

        public Criteria andGlobalIdNotBetween(Long value1, Long value2) {
            addCriterion("global_id not between", value1, value2, "globalId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andAllSizeIsNull() {
            addCriterion("all_size is null");
            return (Criteria) this;
        }

        public Criteria andAllSizeIsNotNull() {
            addCriterion("all_size is not null");
            return (Criteria) this;
        }

        public Criteria andAllSizeEqualTo(Integer value) {
            addCriterion("all_size =", value, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeNotEqualTo(Integer value) {
            addCriterion("all_size <>", value, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeGreaterThan(Integer value) {
            addCriterion("all_size >", value, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_size >=", value, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeLessThan(Integer value) {
            addCriterion("all_size <", value, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeLessThanOrEqualTo(Integer value) {
            addCriterion("all_size <=", value, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeIn(List<Integer> values) {
            addCriterion("all_size in", values, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeNotIn(List<Integer> values) {
            addCriterion("all_size not in", values, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeBetween(Integer value1, Integer value2) {
            addCriterion("all_size between", value1, value2, "allSize");
            return (Criteria) this;
        }

        public Criteria andAllSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("all_size not between", value1, value2, "allSize");
            return (Criteria) this;
        }

        public Criteria andMainurlIsNull() {
            addCriterion("mainURL is null");
            return (Criteria) this;
        }

        public Criteria andMainurlIsNotNull() {
            addCriterion("mainURL is not null");
            return (Criteria) this;
        }

        public Criteria andMainurlEqualTo(String value) {
            addCriterion("mainURL =", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotEqualTo(String value) {
            addCriterion("mainURL <>", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlGreaterThan(String value) {
            addCriterion("mainURL >", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlGreaterThanOrEqualTo(String value) {
            addCriterion("mainURL >=", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlLessThan(String value) {
            addCriterion("mainURL <", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlLessThanOrEqualTo(String value) {
            addCriterion("mainURL <=", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlLike(String value) {
            addCriterion("mainURL like", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotLike(String value) {
            addCriterion("mainURL not like", value, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlIn(List<String> values) {
            addCriterion("mainURL in", values, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotIn(List<String> values) {
            addCriterion("mainURL not in", values, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlBetween(String value1, String value2) {
            addCriterion("mainURL between", value1, value2, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainurlNotBetween(String value1, String value2) {
            addCriterion("mainURL not between", value1, value2, "mainurl");
            return (Criteria) this;
        }

        public Criteria andMainDescribeIsNull() {
            addCriterion("main_describe is null");
            return (Criteria) this;
        }

        public Criteria andMainDescribeIsNotNull() {
            addCriterion("main_describe is not null");
            return (Criteria) this;
        }

        public Criteria andMainDescribeEqualTo(String value) {
            addCriterion("main_describe =", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeNotEqualTo(String value) {
            addCriterion("main_describe <>", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeGreaterThan(String value) {
            addCriterion("main_describe >", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("main_describe >=", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeLessThan(String value) {
            addCriterion("main_describe <", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeLessThanOrEqualTo(String value) {
            addCriterion("main_describe <=", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeLike(String value) {
            addCriterion("main_describe like", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeNotLike(String value) {
            addCriterion("main_describe not like", value, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeIn(List<String> values) {
            addCriterion("main_describe in", values, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeNotIn(List<String> values) {
            addCriterion("main_describe not in", values, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeBetween(String value1, String value2) {
            addCriterion("main_describe between", value1, value2, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andMainDescribeNotBetween(String value1, String value2) {
            addCriterion("main_describe not between", value1, value2, "mainDescribe");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}