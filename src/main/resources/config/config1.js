var ioc = {
    bean1: {
        name: 'XiaoBai',
        birthday: '2009-10-25 15:23:40'
    },
    bean2: {
        type: 'com.zhangzemin.bean.Pet',
        singleton: false,
        args: ['XiaoHei'],
        fields: {
            birthday: '2009-11-03 08:02:14',
            friend: {refer: 'bean1'}
        }
    }
};