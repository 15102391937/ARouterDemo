package cgy.com.moumain.activity

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.CommonBean
import cgy.com.moumain.R
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
                    .withObject("obj", CommonBean("main", 1))
                    .navigation()
        }
    }

}
