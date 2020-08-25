package top.stores.movieappedison.adapter

import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import top.stores.movieappedison.R
import top.stores.movieappedison.activities.MainActivity
import top.stores.movieappedison.databinding.ActivityCardBinding
import top.stores.movieappedison.fragments.MovieDetailsFragment

class MovieViewHolder(binding: ActivityCardBinding) :  RecyclerView.ViewHolder(binding.root) {

    var itemCardBinding: ActivityCardBinding? = null

    fun MovieViewHolder(itemCardBinding: ActivityCardBinding) {
        //super(itemCardBinding.getRoot())
        this.itemCardBinding = itemCardBinding
    }

//    fun onCLick(v : View) {
//        startActivity(MovieDetailsFragment.newIntent(this))
//        finish()
//    }
}