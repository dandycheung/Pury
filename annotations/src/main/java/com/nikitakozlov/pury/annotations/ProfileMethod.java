package com.nikitakozlov.pury.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Combination of {@link StartProfiling} and {@link StopProfiling}. If stage name is empty, then stage name from
 * method's name and class will be generated.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD })
public @interface ProfileMethod {
    /**
     * Profiler Name, used in results.
     */
    String profilerName() default "";

    /**
     * Name of stage to start. Used in results. If stage name is empty, then stage name from
     * method's name and class will be generated.
     */
    String stageName() default "";

    /**
     * Stage order must be bigger then order of current most nested active stage.
     * First profiling must starts with value 0.
     */
    int stageOrder() default 0;

    /**
     * Amount of runs to average. Result will be available only after all runs are stopped.
     */
    int runsCounter() default 1;

    /**
     * Set to false if you want to skip this annotation.
     */
    boolean enabled() default true;
}