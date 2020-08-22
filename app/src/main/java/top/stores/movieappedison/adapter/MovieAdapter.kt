package top.stores.movieappedison.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import top.stores.movieappedison.databinding.ActivityCardBinding


class PromotionAdapter() : RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList : List<MovieEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivityCardBinding.inflate(layoutInflater)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}