package com.zhangzemin;

import com.zhangzemin.bean.Person;
import com.zhangzemin.bean.Pet;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.impl.ScopeContext;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.mvc.Mvcs;

import java.io.*;
import java.util.List;

/**
 * @author zhangzemin
 * @date 2020/3/9 13:48
 */
public class Test {

    /**
     * Hello Ioc
     */
    @org.junit.Test
    public void test1() {
        Ioc ioc = new NutIoc(new JsonLoader("config/config1.js"));
        Pet pet = ioc.get(Pet.class, "bean1");
        System.err.printf("%s - [%s]\n", pet.getName(), pet.getBirthday().getTimeZone().getID());

        //如果配置文件中声明了类型，则可不传入类型
        Pet xh = ioc.get(null, "bean2");
        System.err.printf("%s's friend is %s\n", xh.getName(), xh.getFriend().getName());

        //声明了 singleton: false，那么它每次获取，都会生成一个新的实例
        Pet p1 = ioc.get(null, "bean2");
        Pet p2 = ioc.get(null, "bean2");
        System.err.println(p1 == p2);
        ioc.depose();
    }

    /**
     * 你都可以注入什么？
     */
    @org.junit.Test
    public void test2() throws IOException {
        //向构造函数里注入参数
        //args 的值时一个数组，里面每一个元素都将对应构造函数的一个参数。当然，你 必须确保你得有这样的构造函数。
        //每个参数按照 JSON 的规定，是用半角逗号分隔的
        Ioc ioc = new NutIoc(new JsonLoader("config/config2.js"));
        Pet pet1 = ioc.get(null, "bean1");
        System.err.println(pet1.getName());


        //向属性注入参数
        Pet pet2 = ioc.get(null, "bean2");
        System.err.println(pet2.getName());


        //值可以不仅是字符串
        //布尔
        System.err.println(pet2.getDead());

        //数字
        System.err.println(pet2.getAge());

        //内部对象
        System.err.println(pet2.getFriend().getName());

        //引用
        Pet pet3 = ioc.get(null, "bean3");
        System.err.println(pet3.getFriend().getName());

        //容器自身
        //一种特殊的引用，大小写不敏感，值就是 Ioc 容器本身
        Pet pet4 = ioc.get(null, "bean4");
        Ioc myIoc = pet4.getMyIoc();
        myIoc.get(null, "bean3");
        System.err.println(pet3.getFriend().getName());

        //对象的名称
        Pet pet5 = ioc.get(null, "bean5");
        System.err.println(pet5.getObjectName());

        //容器上下文
        //一种特殊的引用，大小写不敏感，值就是当前容器的上下文环境接口 org.nutz.ioc.IocContext
        Pet pet6 = ioc.get(null, "bean6");
        System.err.println(pet6.getContext());

        //环境变量
        //获取JAVA_HOME变量值
        //System.err.println(pet6.getEnv());
        //获取JAVA_HOME下面的/bin/java的路径
        //System.err.println(pet6.getEnv());
        //当JAVA_HOME不存在时,就会输出 /bin/java
        //System.err.println(pet6.getEnv());
        //同时也支持默认值哦,用冒号分割
        System.err.println(pet6.getEnv());

        //Java调用
        System.err.println(pet6.getMyName());
        System.err.println(pet6.getAge());
        System.err.println(pet6.getMyEmail());
        ioc.depose();
    }

    /**
     * 事件监听
     */
    @org.junit.Test
    public void test3(){
        Ioc ioc = new NutIoc(new JsonLoader("config/config2.js"));
        //事件监听
        Pet pet7 = ioc.get(Pet.class, "bean7");
        System.err.println(pet7.getAge());
        ioc.depose();
    }

    /**
     * 规划properties文件
     */
    @org.junit.Test
    public void test4(){
        Ioc ioc = new NutIoc(new JsonLoader("config/config3.js"));
        NutDao dao = ioc.get(NutDao.class, "dao");
        List<Person> list = dao.query(Person.class, null);
        for (Person p : list
             ) {
            System.out.println(p);
        }
    }

}
