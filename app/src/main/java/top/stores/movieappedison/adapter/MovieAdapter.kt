package top.stores.movieappedison.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import top.stores.movieappedison.R
import top.stores.movieappedison.roomDB.MovieEntity

class MovieAdapter(private val context: Context?, private val movieList: List<MovieEntity>?) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_card, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return movieList?.size!!
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.movieTitleTv.text = movieList?.get(index)?.title
        viewHolder.movieRatingTV.text = movieList?.get(index)?.voteAverage.toString()
        viewHolder.movieRelaseDateTv.text =  movieList?.get(index)?.releaseDate
        viewHolder.overViewHome.text =  movieList?.get(index)?.overview

//        viewHolder.movieImage.text =  messages?.get(index)?.message
//        viewHolder.btnSeeMore.setOnClickListener {
//
//        }

    }


    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        var movieTitleTv: TextView = itemView.findViewById(R.id.tv_movies_title_card) as TextView
        var movieRatingTV: TextView = itemView.findViewById(R.id.tv_movies_rating) as TextView
        var movieRelaseDateTv: TextView = itemView.findViewById(R.id.tv_release_date) as TextView
        var overViewHome: TextView = itemView.findViewById(R.id.over_view_home) as TextView

        var movieImage: ImageView = itemView.findViewById(R.id.movies_card_image_view) as ImageView
        var btnSeeMore: Button = itemView.findViewById(R.id.btn_see_more) as Button



    }


}