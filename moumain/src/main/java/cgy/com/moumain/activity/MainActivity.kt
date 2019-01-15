package cgy.com.moumain.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import cgy.com.common.activity.BaseActivity
import cgy.com.common.arouter.ARouterConstants
import cgy.com.common.bean.CommonBean
import cgy.com.moumain.R
import cgy.com.moumain.arouter.HelloService
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/main/main", extras = ARouterConstants.EXTRA_NEED_LOGIN)
class MainActivity : BaseActivity() {

    @Autowired
    @JvmField
    var helloService: HelloService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ARouter.getInstance().inject(this)

        tv_main.setOnClickListener {
            ARouter.getInstance().build("/one/one")
                    .withObject("obj", CommonBean("main", 1))
                    .navigation(this, 11)
        }

        tv_main2.setOnClickListener {
            helloService?.let { tv_main2.text = helloService!!.sayHellow("cgy") }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 22 && requestCode == 11) {
            data?.let {
                Toast.makeText(this, data.getStringExtra("resultStr"), Toast.LENGTH_SHORT).show()
            }
        }
    }

}
