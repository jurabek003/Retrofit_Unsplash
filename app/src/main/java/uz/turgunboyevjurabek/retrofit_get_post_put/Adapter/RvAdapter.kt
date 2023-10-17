package uz.turgunboyevjurabek.retrofit_get_post_put.Adapter

import android.util.Log
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.UnsplashPhoto
import uz.turgunboyevjurabek.retrofit_get_post_put.databinding.ItemRvBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class RvAdapter(val list: List<UnsplashPhoto>,val onclick: Onclick) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : ViewHolder(itemRvBinding.root) {
        fun onBind(unsplashPhoto: UnsplashPhoto, position: Int) {
            Log.e("tagg",unsplashPhoto.urls.regular)

                Glide.with(itemRvBinding.root.context)
                    .load(unsplashPhoto.urls.regular)
                    .into(itemRvBinding.itemImage)

                itemRvBinding.root.setOnClickListener{
                    onclick.imageClick(unsplashPhoto,position)
                }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvBinding.inflate(inflater, parent, false)
        return Vh(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

}

interface Onclick{
    fun imageClick(unsplashPhoto: UnsplashPhoto, position: Int)
}