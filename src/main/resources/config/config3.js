var ioc = {
    // 读取配置文件
    conf : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["databases.properties"]
        }
    },
    // 数据源
    dataSource : {
        type :"org.apache.commons.dbcp.BasicDataSource",
        events : {
            depose :"close"
        },
        fields : {
            driverClassName : {java :"$conf.get('db.driver')"},
            url             : {java :"$conf.get('db.url')"},
            username        : {java :"$conf.get('db.username')"},
            password        : {java :"$conf.get('db.password')"},
            initialSize     : 10,
            maxActive       : 100,
            testOnReturn    : true,
            //validationQueryTimeout : 5,
            validationQuery : "select 1"
        }
    },
    // Dao
    dao : {
        type :'org.nutz.dao.impl.NutDao',
        args : [ {refer :"dataSource"}]
    }
};