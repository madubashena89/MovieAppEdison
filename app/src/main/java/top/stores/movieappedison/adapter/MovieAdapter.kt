package top.stores.movieappedison.adapter

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import top.stores.movieappedison.R
import top.stores.movieappedison.fragments.MovieDetailsFragment
import top.stores.movieappedison.networkServices.VolleyNetworkManager
import top.stores.movieappedison.roomDB.MovieEntity


class MovieAdapter(private val context: Context?, private val movieList: List<MovieEntity>?) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, index: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_card, viewGroup, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return movieList?.size!!
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.movieTitleTv.text = movieList?.get(position)?.title
        viewHolder.movieRatingTV.text = movieList?.get(position)?.voteAverage.toString()
        viewHolder.movieRelaseDateTv.text =  movieList?.get(position)?.releaseDate
        viewHolder.overViewHome.text =  movieList?.get(position)?.overview


        val imageUrl = VolleyNetworkManager.IMAGE_CONSTANT+ movieList?.get(position)?.backdropPath
        Picasso.get()
            .load(Uri.parse(imageUrl)) // internet path
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round)
            .into(viewHolder.movieImage)

//        viewHolder.movieImage.text =  messages?.get(index)?.message
        viewHolder.btnSeeMore.setOnClickListener {
            val movieDetailsFragment = MovieDetailsFragment()
            val bundle = Bundle()
            bundle.putInt("POSITION", position)
            bundle.putString("TITLE", movieList?.get(position)?.title)
            bundle.putString("RATING", movieList?.get(position)?.voteAverage.toString())
            bundle.putString("RELEASEDATE", movieList?.get(position)?.releaseDate)
            bundle.putString("OVERVIEW", movieList?.get(position)?.overview)
            bundle.putString("POSTERURL", movieList?.get(position)?.posterPath)
            movieDetailsFragment.arguments = bundle
            moveToFragment(movieDetailsFragment)
        }

    }


    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        var movieTitleTv: TextView = itemView.findViewById(R.id.tv_movies_title_card) as TextView
        var movieRatingTV: TextView = itemView.findViewById(R.id.tv_movies_rating) as TextView
        var movieRelaseDateTv: TextView = itemView.findViewById(R.id.tv_release_date) as TextView
        var overViewHome: TextView = itemView.findViewById(R.id.over_view_home) as TextView

        var movieImage: ImageView = itemView.findViewById(R.id.movies_card_image_view) as ImageView
        var btnSeeMore: Button = itemView.findViewById(R.id.btn_see_more) as Button

    }


    private fun moveToFragment(fragment : Fragment){
        val fragmentTrans = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }


}