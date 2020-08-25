package top.stores.movieappedison.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import top.stores.movieappedison.databinding.ActivityCardBinding
import top.stores.movieappedison.roomDB.MovieEntity

class MovieAdapter() : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList : List<MovieEntity>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityCardBinding.inflate(layoutInflater)
        return MovieViewHolder(binding)
    }

    override fun getItemCount() : Int{
        return movieList?.size!!
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemCardBinding?.apply {
            tvMoviesTitleCard.text = movieList?.get(position)?.title.toString()

        }
    }


}