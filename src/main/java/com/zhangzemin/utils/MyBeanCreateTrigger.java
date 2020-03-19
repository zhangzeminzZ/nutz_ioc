package com.zhangzemin.utils;

import org.nutz.ioc.IocEventTrigger;

/**
 * @author zhangzemin
 * @date 2020/3/9 16:59
 */
public class MyBeanCreateTrigger implements IocEventTrigger {

    public void trigger(Object o) {
        System.err.println("对象被创建了");
    }
}
