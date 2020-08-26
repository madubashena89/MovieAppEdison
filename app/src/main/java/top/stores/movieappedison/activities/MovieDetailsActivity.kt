package top.stores.movieappedison.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import top.stores.movieappedison.R
import top.stores.movieappedison.databinding.FragmentMovieDetailsBinding
import top.stores.movieappedison.viewModels.MoviesViewModel

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding : FragmentMovieDetailsBinding
    private lateinit var viewModel : MoviesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_movie_details)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_movie_details)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        setUpScreenWithIntent()

    }


    fun setUpScreenWithIntent(){
        var moviewList = viewModel.getMovies()
        binding.apply {
            tvMovieTitleDetails.text = Intent().extras?.getString("TITLE")
            tvRankingDetails.text = Intent().extras?.getString("RATING")
            tvReleaseDateDetails.text = Intent().extras?.getString("RELEASEDATE")
            tvOverviewDetails.text = Intent().extras?.getString("OVERVIEW")
            btnBackDetails.setOnClickListener {
                val intent = Intent(this@MovieDetailsActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }



    }
}