package uz.pdp.retrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.pdp.retrofit.databinding.ItemMovieBinding
import uz.pdp.retrofit.models.Movie

class MovieAdapter(var list: List<Movie>) : RecyclerView.Adapter<MovieAdapter.Vh>() {

    inner class Vh(var itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root) {

        fun onBind(movie: Movie) {
            itemMovieBinding.nameTv.text = movie.name
            Picasso.get().load(movie.imageurl).into(itemMovieBinding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
