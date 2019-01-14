package cgy.com.mouone

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_one.*

@Route(path = "/one/one")
class OneActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        ARouter.getInstance().inject(this)

        tv_one.setOnClickListener{
            ARouter.getInstance().build("/one/webview")
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation()
        }
    }
}
