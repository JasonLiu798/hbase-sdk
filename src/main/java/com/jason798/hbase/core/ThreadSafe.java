package com.jason798.hbase.core;

import java.lang.annotation.*;


@Documented
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.CLASS)
public @interface ThreadSafe {
}
