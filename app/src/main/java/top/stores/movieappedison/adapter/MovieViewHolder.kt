package top.stores.movieappedison.adapter

import androidx.recyclerview.widget.RecyclerView
import top.stores.movieappedison.R
import top.stores.movieappedison.databinding.ActivityCardBinding

class MovieViewHolder(binding: ActivityCardBinding) :  RecyclerView.ViewHolder(binding.root) {

    var itemCardBinding: ActivityCardBinding? = null

    fun WeatherViewHolder(itemCardBinding: ActivityCardBinding) {
        //super(itemCardBinding.getRoot())
        this.itemCardBinding = itemCardBinding
    }





}