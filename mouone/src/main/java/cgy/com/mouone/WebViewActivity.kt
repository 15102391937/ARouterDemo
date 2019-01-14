package cgy.com.mouone

import android.os.Bundle
import cgy.com.common.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_webview.*

/**
 * Created by ChenGY on 2019-01-11.
 */
@Route(path = "/one/webview")
class WebViewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        wv.loadUrl(intent.getStringExtra("url"))
    }
}