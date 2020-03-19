var ioc = {
    bean1:{
        type:'com.zhangzemin.bean.Pet',
        args:['xiaobai']
    },
    bean2:{
        type:'com.zhangzemin.bean.Pet',
        fields:{
            name:"xiaohei",
            dead:true,
            age:11,
            friend:{
                type : 'com.zhangzemin.bean.Pet',
                fields : {name : 'XiaoBai'}
            }
        }
    },
    bean3:{
        type:'com.zhangzemin.bean.Pet',
        fields:{
            friend:{
                refer:'bean1'
            }
        }
    },
    bean4:{
        type:'com.zhangzemin.bean.Pet',
        fields:{
            myIoc:{
                refer:'$Ioc'
            }
        }
    },
    bean5:{
        type:'com.zhangzemin.bean.Pet',
        fields:{
            objectName:{
                refer:'$Name'
            }
        }
    },
    bean6:{
        type:'com.zhangzemin.bean.Pet',
        fields:{
            context:{
                refer:'$Context'
            },
            // env:{
            //     env:"JAVA_HOME"
            // }
            // env:{
            //     env:["JAVA_HOME","/bin/java"]
            // }
            // env:{
            //     env:["!JAVA_HOM","/bin/java"]
            // }
            env:{
                env:["!JAVA_HOM:/d/java/jdk","/bin/java"]
            },
            myName:{
                java:"com.zhangzemin.utils.Util.name"
            },
            myEmail:{
                java:'com.zhangzemin.utils.Util.getEmail("熟人")'
            },
            myAge:{
                java:'com.zhangzemin.utils.Util.getAge("22")'
            }
        }
    },
    bean7:{
        type:'com.zhangzemin.bean.Pet',
        fields:{
          age:22
        },
        events:{
            create:"com.zhangzemin.utils.MyBeanCreateTrigger",
            fetch:"fetchBean",
            depose:"com.zhangzemin.utils.MyBeanDeposeTrigger"
        }
    }
};