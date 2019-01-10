package cgy.com.mouone

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.MainBean
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_one.*
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/one/one")
class OneActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        tv_one.setOnClickListener{
            ARouter.getInstance().build("/main/main")
                    .withString("key1", "moe")
//                    .withObject("key2", MainBean("one", 3))
                    .navigation()
        }
    }
}
