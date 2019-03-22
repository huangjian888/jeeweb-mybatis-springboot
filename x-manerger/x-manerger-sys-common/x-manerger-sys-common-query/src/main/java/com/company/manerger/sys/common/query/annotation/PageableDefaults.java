package com.company.manerger.sys.common.query.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageableDefaults {

	/**
	 * The default-size the injected
	 * {@link org.springframework.data.domain.Pageable} should get if no
	 * corresponding parameter defined in request (default is 10).
	 */
	int value() default 10;

	int pageNumber() default 0;

	/**
	 * 默认的排序 格式为{"a=desc, a.b=desc"}
	 */
	String[] sort() default {};

}
