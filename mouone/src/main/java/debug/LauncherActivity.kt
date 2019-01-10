package debug

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cgy.com.mouone.OneActivity

/**
 * Created by ChenGY on 2019-01-09.
 */
class LauncherActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, OneActivity::class.java).apply {
            putExtra("name", "avcd");
            putExtra("syscode", "023e2e12ed");
        }
        startActivity(intent)
        finish()
    }
}