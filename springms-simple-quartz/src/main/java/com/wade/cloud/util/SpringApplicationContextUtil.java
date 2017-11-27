package com.wade.cloud.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by tingyun on 2017/11/27.
 */
public class SpringApplicationContextUtil implements ApplicationContextAware {

    // 声明一个静态变量保存
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringApplicationContextUtil.applicationContext=applicationContext;
    }

    public static ApplicationContext getContext(){

        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

}
