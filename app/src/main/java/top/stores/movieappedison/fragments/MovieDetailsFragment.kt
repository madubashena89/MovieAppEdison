package top.stores.movieappedison.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import top.stores.movieappedison.R
import top.stores.movieappedison.adapter.MovieAdapter
import top.stores.movieappedison.databinding.FragmentMovieDetailsBinding
import top.stores.movieappedison.viewModels.MoviesViewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var binding : FragmentMovieDetailsBinding
    private lateinit var viewModel : MoviesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_home, container, false)



    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

    }


    fun setUpScreen( viewModel: MoviesViewModel){
        val movieList = viewModel.getMovies()
        movieList?.forEach {
            val imageUrl = it.posterPath
           binding.apply {
               tvMovieTitleDetails.text = it.title
               tvRankingDetails.text = it.voteAverage.toString()
               tvReleaseDateDetails.text = it.releaseDate
               tvOverviewDetails.text = it.overview
               btnBackDetails.setOnClickListener {

               }
           }
            Picasso.get()
                .load(Uri.parse(imageUrl)) // internet path
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(binding.imageVIewDetails)
        }

    }


    companion object{
        fun newInstance(): MovieDetailsFragment = MovieDetailsFragment()
        fun newIntent(context : Context) = Intent(context , MovieDetailsFragment::class.java)

    }
}