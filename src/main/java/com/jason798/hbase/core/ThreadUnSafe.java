package com.jason798.hbase.core;

import java.lang.annotation.*;

/**
 * ThreadSafe
 *
 * @author JasonLiu798
 * @since 1.0
 */
@Documented
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.CLASS)
public @interface ThreadUnSafe {
}
