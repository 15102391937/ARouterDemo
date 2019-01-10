package cgy.com.arouterdemo

import android.util.Log
import cgy.com.common.app.BaseApplication
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure

/**
 * Created by ChenGY on 2019-01-09.
 */
 class App : BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        initUmengSdk()
    }

    /**
     * 初始化友盟sdk
     */
    private fun initUmengSdk() {
        if (BuildConfig.DEBUG) {
            Log.e("umeng", "debug友盟不初始化")
        } else {
            Log.e("umeng", "release友盟初始化")
            UMConfigure.init(this, BuildConfig.UMENGAPP_KEY, BuildConfig.UMENGAPP_CHANNEL, UMConfigure.DEVICE_TYPE_PHONE, null)
            MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL)//普通统计场景类型
        }
    }
}

