package top.stores.movieappedison.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import top.stores.movieappedison.R
import top.stores.movieappedison.adapter.MovieAdapter
import top.stores.movieappedison.adapter.MovieViewHolder
import top.stores.movieappedison.databinding.ActivityMainBinding
import top.stores.movieappedison.databinding.FragmentHomeBinding
import top.stores.movieappedison.viewModels.MoviesViewModel

class HomeFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: MovieAdapter
    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : MoviesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        activity?.let {
            viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        }
        setUpAdapterWithList(binding.homeRecyclerview,viewModel)
        return binding.root

    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        binding.homeRecyclerview.adapter.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView


        }
    }
//    fun onCLick(v : View) {
//            val fragmentTrans = supportFragmentManager.beginTransaction()
//            fragmentTrans.replace(R.id.fragment_container, MovieDetailsFragment)
//            fragmentTrans.commit()
//
//    }

    fun setUpAdapterWithList(recyclerView: RecyclerView, viewModel: MoviesViewModel){
        adapter = MovieAdapter(activity?.applicationContext, viewModel.getMovies())
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd =true
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }

//        fun onCLick(v : View) {
//        startActivity(MovieDetailsFragment.newIntent(this))
//        finish()
//        }

    companion object{
        fun newInstance(): HomeFragment = HomeFragment()
    }
}