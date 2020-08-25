package top.stores.movieappedison.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import top.stores.movieappedison.R
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

    companion object{
        fun newInstance(): MovieDetailsFragment = MovieDetailsFragment()
    }
}