package cgy.com.moumain.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import cgy.com.common.activity.BaseActivity
import cgy.com.common.arouter.ARouterConstants
import cgy.com.common.bean.CommonBean
import cgy.com.moumain.R
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/main/main", extras = ARouterConstants.EXTRA_NEED_LOGIN)
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.setOnClickListener {
            ARouter.getInstance().build("/one/one")
                    .withObject("obj", CommonBean("main", 1))
                    .navigation(this, 11)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 22 && requestCode == 11) {
            data?.let {
                Toast.makeText(this, "${data.getStringExtra("resultStr")}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
