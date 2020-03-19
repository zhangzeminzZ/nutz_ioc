package com.zhangzemin.bean;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.IocContext;

import java.util.Calendar;

public class Pet {
    private String name;
    private Integer age;
    private Calendar birthday;
    private Boolean dead;
    private Pet friend;
    private Ioc myIoc;
    private String objectName;
    private IocContext context;
    private String env;
    private String myName;
    private String myAge;
    private String myEmail;
    public Pet(){}
    public Pet(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Pet getFriend() {
        return friend;
    }

    public void setFriend(Pet friend) {
        this.friend = friend;
    }

    public Ioc getMyIoc() {
        return myIoc;
    }

    public void setMyIoc(Ioc myIoc) {
        this.myIoc = myIoc;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public IocContext getContext() {
        return context;
    }

    public void setContext(IocContext context) {
        this.context = context;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAge() {
        return myAge;
    }

    public void setMyAge(String myAge) {
        this.myAge = myAge;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public void fetchBean(){
        System.err.println("对象被调用了");
    }

}
