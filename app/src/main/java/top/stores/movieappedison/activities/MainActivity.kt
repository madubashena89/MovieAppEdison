package top.stores.movieappedison.activities

import android.os.Bundle
import android.provider.Settings.Secure
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import top.stores.movieappedison.R
import top.stores.movieappedison.adapter.MovieAdapter
import top.stores.movieappedison.databinding.ActivityMainBinding
import top.stores.movieappedison.fragments.HomeFragment
import top.stores.movieappedison.viewModels.MoviesViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var movieAdapter : MovieAdapter
    private  var viewModel : MoviesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
//        viewModel = ViewModelProvider(this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(this)).get<MoviesViewModel>(MoviesViewModel::class.java
//        )
/*        val android_id = Secure.getString(
            this.contentResolver,
            Secure.ANDROID_ID
        )
        Log.d("AndroidID", "$android_id")*/
        //VolleyNetworkManager.downloadData(this)

        moveToFragment(HomeFragment.newInstance())

    }

    private fun moveToFragment(fragment : Fragment){
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }

    private fun swapFragment(frag : Fragment){
        viewModel?.swapFragment(frag)
    }
}