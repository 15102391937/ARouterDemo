package cgy.com.common.activity

import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by ChenGY on 2019-01-11.
 */
class SchameFilterActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri = intent.data
        ARouter.getInstance().build(uri).navigation()
        finish()
    }
}