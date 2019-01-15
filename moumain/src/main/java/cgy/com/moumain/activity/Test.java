package cgy.com.moumain.activity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;

import cgy.com.moumain.arouter.HelloService;

public class Test {
    @Autowired
    HelloService helloService;
    @Autowired(name = "/service/hello")
    HelloService helloService2;
    HelloService helloService3;
    HelloService helloService4;
    public Test() {
        ARouter.getInstance().inject(this);
    }
    public void testService() {
        // 1. 使用依赖注入的方式发现服务,通过注解标注字段,即可使用，无需主动获取
        // @Autowired注解中标注name之后，将会使用byName，不设置name属性，会默认使用byType
        helloService.sayHello("cgy");
        helloService2.sayHello("cgy");
        // 2. 使用依赖查找的方式发现服务，主动去发现服务并使用，下面两种方式分别是byName和byType
        helloService4 = (HelloService) ARouter.getInstance().build("/service/hello").navigation();
        helloService3 = ARouter.getInstance().navigation(HelloService.class);
        helloService3.sayHello("cgy");
        helloService4.sayHello("cgy");
    }
}