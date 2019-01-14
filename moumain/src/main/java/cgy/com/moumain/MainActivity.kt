package cgy.com.moumain

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.OneBean
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/main/main")
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.setOnClickListener {
            ARouter.getInstance().build("/one/one")
                    .navigation()
        }
    }

}
