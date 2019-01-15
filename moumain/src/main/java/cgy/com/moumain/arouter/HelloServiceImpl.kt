package cgy.com.moumain.arouter

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created by ChenGY on 2019-01-15.
 */
// 实现声明好的服务接口，可通过byType或byName查找到
@Route(path = "/service/hello", name = "测试服务hello")
class HelloServiceImpl : HelloService {
    private var context: Context? = null

    override fun sayHellow(name: String): String {
        context?.let {
            Toast.makeText(context, "HelloServiceImpl:$name", Toast.LENGTH_SHORT).show()
        }
        return "HelloServiceImpl:$name"
    }

    override fun init(context: Context?) {
        Log.e("ARouter", "位于 one 中的 HelloServiceImpl 初始化了")
        this.context = context
    }
}

// 声明继承与OProvider的接口,其他组件通过byType或byName查找到该接口的具体实现类后，来调用具体服务
interface HelloService : IProvider {
    fun sayHellow(name: String): String
}


