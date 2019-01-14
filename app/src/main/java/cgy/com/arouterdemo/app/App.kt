package cgy.com.arouterdemo.app

import android.util.Log
import cgy.com.arouterdemo.BuildConfig
import cgy.com.common.app.BaseApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure

/**
 * Created by ChenGY on 2019-01-09.
 */
 class App : BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        initARouter()
        initUmengSdk()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式，必须开启！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
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

