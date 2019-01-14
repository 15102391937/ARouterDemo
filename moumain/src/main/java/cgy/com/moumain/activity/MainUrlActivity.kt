package cgy.com.moumain.activity

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.CommonBean
import cgy.com.moumain.R
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_url.*

@Route(path = "/main/url")
class MainUrlActivity : BaseActivity() {

    @Autowired
    @JvmField
    var key1: String? = ""
    @Autowired
    @JvmField
    var key2: Int = 0
    @Autowired(name = "key3")
    @JvmField
    var boy: Boolean = false
    @Autowired
    @JvmField
    var obj: CommonBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)
        ARouter.getInstance().inject(this)
        tv_url.text = "$key1-- - $key2-- - $boy-- - $obj"
    }
}
