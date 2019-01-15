package cgy.com.moumain.arouter

import android.content.Context
import android.net.Uri
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PathReplaceService
import java.io.File

/**
 * Created by ChenGY on 2019-01-15.
 */
@Route(path = "/xxx/xxx") // 必须标明注解
class PathReplaceServiceImpl : PathReplaceService {
    override fun forString(path: String?): String {
        return "/one/one"
    }

    override fun forUri(uri: Uri?): Uri {
        return Uri.fromFile(File("arouter://m.aliyun.com/one/one"))
    }

    override fun init(context: Context?) {
        Log.e("ARouter", "位于 main 中的 PathReplaceServiceImpl 初始化了")
    }
}