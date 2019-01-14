package cgy.com.mouone.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.CommonBean
import cgy.com.mouone.R
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
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
            ARouter.getInstance().build("/one/webview2")
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation()
        }

        tv_one2.setOnClickListener {
            ARouter.getInstance().build("/main/obj2")
                    .withObject("obj", CommonBean("main", 1))
                    .navigation(this, object : NavigationCallback {
                        override fun onLost(postcard: Postcard?) {
                            Log.e("ARouter", "找不到了")
                        }

                        override fun onFound(postcard: Postcard?) {
                            Log.e("ARouter", "找到了")
                        }

                        override fun onInterrupt(postcard: Postcard?) {
                            Log.e("ARouter", "被拦截了")
                        }

                        override fun onArrival(postcard: Postcard?) {
                            Log.e("ARouter", "跳转完了")
                        }
                    })
        }

        tv_one3.setOnClickListener {
            setResult(22, Intent().apply {
                putExtra("resultStr", "oneResult")
            })
            finish()
        }
    }
}
