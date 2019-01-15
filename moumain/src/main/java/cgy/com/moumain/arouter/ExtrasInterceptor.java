package cgy.com.moumain.arouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import cgy.com.common.arouter.ARouterConstants;
import cgy.com.common.utils.StrNumUtil;

@Interceptor(priority = 9, name = "Extras拦截器")
public class ExtrasInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (StrNumUtil.has_intterupt) {
            switch (postcard.getExtra()) {
                case ARouterConstants.EXTRA_NEED_LOGIN:
                    callback.onInterrupt(new RuntimeException("EXTRA_NEED_LOGIN"));  // 觉得有问题，中断路由流程
                    Log.e("ARouter", "ExtrasInterceptor interrupt");
                    break;
                default:
                    callback.onContinue(postcard);  // 处理完成，交还控制权
                    Log.e("ARouter", "ExtrasInterceptor pass");
                    break;
            }
        } else {
            callback.onContinue(postcard);  // 处理完成，交还控制权
            Log.e("ARouter", "process: 1 pass");
        }
    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.e("ARouter", "位于 main 中的拦截器 extras 初始化了");
    }
}