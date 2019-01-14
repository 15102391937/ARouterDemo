package cgy.com.mouone.activity

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.CommonBean
import cgy.com.mouone.R
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_one.*

@Route(path = "/one/one")
class OneActivity : BaseActivity() {
    @Autowired
    @JvmField
    var obj: CommonBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        ARouter.getInstance().inject(this)

        tv_show.text = "$obj"

        tv_one.setOnClickListener {
            ARouter.getInstance().build("/one/webview")
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation()
        }

        tv_one2.setOnClickListener {
            ARouter.getInstance().build("/main/obj")
                    .withObject("obj", CommonBean("main", 1))
                    .navigation()
        }
    }
}
