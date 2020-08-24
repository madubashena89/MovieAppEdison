package top.stores.movieappedison.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import top.stores.movieappedison.R
import top.stores.movieappedison.networkServices.VolleyNetworkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        VolleyNetworkManager.downloadData(this)
    }
}