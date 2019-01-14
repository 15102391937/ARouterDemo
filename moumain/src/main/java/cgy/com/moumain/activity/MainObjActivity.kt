package cgy.com.moumain.activity

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import cgy.com.common.bean.CommonBean
import cgy.com.moumain.R
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_obj.*

@Route(path = "/main/obj")
class MainObjActivity : BaseActivity() {

    @Autowired
    @JvmField
    var obj: CommonBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obj)
        ARouter.getInstance().inject(this)
        tv_show.text = "$obj"
    }
}
