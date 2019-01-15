package cgy.com.moumain.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService

/**
 * Created by ChenGY on 2019-01-14.
 */
// 实现DegradeService接口，并加上一个Path内容任意的注解即可
@Route(path = "/xxx/xxx")
class DegradeServiceImpl : DegradeService {
    override fun onLost(context: Context?, postcard: Postcard?) {
        Log.e("ARouter", "main的全局降级")
    }

    override fun init(context: Context?) {
        Log.e("ARouter", "位于 main 中的degrade初始化了")
    }

}