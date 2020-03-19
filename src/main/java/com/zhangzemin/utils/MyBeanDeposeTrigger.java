package com.zhangzemin.utils;

import org.nutz.ioc.IocEventTrigger;

/**
 * @author zhangzemin
 * @date 2020/3/9 17:00
 */
public class MyBeanDeposeTrigger implements IocEventTrigger {

    public void trigger(Object o) {
        System.err.println("对象被销毁了");
    }
}
