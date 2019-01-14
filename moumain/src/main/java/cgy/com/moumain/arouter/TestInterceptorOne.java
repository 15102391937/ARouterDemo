package cgy.com.moumain.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import cgy.com.common.utils.StrNumUtil;

// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(priority = 1, name = "拦截器1")
public class TestInterceptorOne implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (StrNumUtil.has_intterupt &&StrNumUtil.getRandomBoolean()) {
            callback.onInterrupt(new RuntimeException("我觉得有点异常"));  // 觉得有问题，中断路由流程
            Log.e("tag", "process: 1 interrupt");
        } else {
            callback.onContinue(postcard);  // 处理完成，交还控制权
            Log.e("tag", "process: 1 pass");
        }
    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.e("tag", "位于 main 中的拦截器1初始化了");
    }
}