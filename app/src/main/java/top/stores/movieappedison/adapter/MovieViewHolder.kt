package top.stores.movieappedison.adapter

import androidx.recyclerview.widget.RecyclerView
import top.stores.movieappedison.R
import top.stores.movieappedison.databinding.ActivityCardBinding

class MovieViewHolder(binding: ActivityCardBinding) :  RecyclerView.ViewHolder(binding.root) {

    var itemCardBinding: ItemCardBinding? = null

    fun WeatherViewHolder(itemCardBinding: ItemCardBinding) {
        super(itemCardBinding.getRoot())
        this.itemCardBinding = itemCardBinding
    }




}