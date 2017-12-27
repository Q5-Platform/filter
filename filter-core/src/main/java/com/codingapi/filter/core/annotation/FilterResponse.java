package com.codingapi.filter.core.annotation;



import com.codingapi.filter.core.em.FilterType;

import java.lang.annotation.*;

/**
 *
 * DefaultResponse
 * 是指在springcloud机制下不需要通过filter-zuul对返回数据做拦截处理的controller
 *
 * create by lorne on 2017/12/7
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FilterResponse {


    FilterType type() default FilterType.defaultFilter;

}
