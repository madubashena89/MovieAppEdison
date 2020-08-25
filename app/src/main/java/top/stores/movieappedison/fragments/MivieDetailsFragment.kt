package top.stores.movieappedison.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import top.stores.movieappedison.R
import top.stores.movieappedison.adapter.MovieAdapter
import top.stores.movieappedison.adapter.MovieViewHolder
import top.stores.movieappedison.databinding.FragmentHomeBinding
import top.stores.movieappedison.viewModels.MoviesViewModel

class MivieDetailsFragment : Fragment() {

    private lateinit var binding :
    private lateinit var viewModel : MoviesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_home, container, false)

        activity?.let {
            viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
            binding.homeRecyclerview.adapter = MovieAdapter()
        }

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        home_recyclerview.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MovieAdapter()

        }
    }

    companion object{
        fun newInstance(): HomeFragment = HomeFragment()
    }
}