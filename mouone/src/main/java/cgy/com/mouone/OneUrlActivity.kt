package cgy.com.mouone

import android.os.Bundle
import android.util.Log
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.OneBean
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_one.*

@Route(path = "/one/url")
class OneUrlActivity : BaseActivity() {

    @Autowired
    @JvmField var key1: String? = ""
    @Autowired
    @JvmField var key2: Int = 0
    @Autowired(name = "key3")
    @JvmField var boy: Boolean = false
    @Autowired
    @JvmField var obj: OneBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        tv_one.setOnClickListener{
        }
        ARouter.getInstance().inject(this)
        Log.e("tag","$key1 --- $key2 --- $boy --- $obj")
    }
}
