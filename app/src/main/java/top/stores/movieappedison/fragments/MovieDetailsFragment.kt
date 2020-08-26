package top.stores.movieappedison.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import top.stores.movieappedison.R
import top.stores.movieappedison.adapter.MovieAdapter
import top.stores.movieappedison.databinding.FragmentHomeBinding
import top.stores.movieappedison.databinding.FragmentMovieDetailsBinding
import top.stores.movieappedison.networkServices.VolleyNetworkManager
import top.stores.movieappedison.viewModels.MoviesViewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var binding : FragmentMovieDetailsBinding
    private lateinit var viewModel : MoviesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater,container,false)

        activity?.let {
            viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        }
        val bundle = arguments
        setUpScreen(bundle)

        return binding.root

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
       // setUpScreenWithIntent()
    }


    fun setUpScreen( bundle: Bundle?){
        //val movieList = viewModel.getMovies()
        val bundle = arguments
           binding.apply {
               tvMovieTitleDetails.text = bundle?.getString("TITLE")
               tvRankingDetails.text =  bundle?.getString("RATING")
               tvReleaseDateDetails.text =  bundle?.getString("RELEASEDATE")
               tvOverviewDetails.text =  bundle?.getString("OVERVIEW")
               btnBackDetails.setOnClickListener {
                   moveToFragment(HomeFragment.newInstance())

           }
               val posterURL = VolleyNetworkManager.IMAGE_CONSTANT + bundle?.getString("POSTERURL")
            Picasso.get()
                .load(Uri.parse(posterURL)) // internet path
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(binding.imageVIewDetails)
        }

    }


    fun setUpScreenWithIntent(){
        var moviewList = viewModel.getMovies()
        binding.apply {
            tvMovieTitleDetails.text = Intent().extras?.getString("TITLE")
            tvRankingDetails.text = Intent().extras?.getString("RATING")
            tvReleaseDateDetails.text = Intent().extras?.getString("RELEASEDATE")
            tvOverviewDetails.text = Intent().extras?.getString("OVERVIEW")
            btnBackDetails.setOnClickListener {

            }
        }
    }


    private fun moveToFragment(fragment : Fragment){
        val fragmentTrans = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }

    companion object{
        fun newInstance(): MovieDetailsFragment = MovieDetailsFragment()
        fun newIntent(context : Context) = Intent(context , MovieDetailsFragment::class.java)

    }
}