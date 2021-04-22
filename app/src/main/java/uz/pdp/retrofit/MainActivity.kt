package uz.pdp.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.pdp.retrofit.adapters.MovieAdapter
import uz.pdp.retrofit.databinding.ActivityMainBinding
import uz.pdp.retrofit.models.Movie
import uz.pdp.retrofit.retrofit.Common
import uz.pdp.retrofit.retrofit.RetrofitService

class MainActivity : AppCompatActivity() {

    lateinit var retrofitService: RetrofitService

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding

    lateinit var movieAdapter: MovieAdapter
    lateinit var list: ArrayList<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        movieAdapter = MovieAdapter(list)
        retrofitService = Common.retrofitService(this)
        retrofitService.getMovie().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                list.addAll(result)
                movieAdapter.notifyDataSetChanged()
            }, { error ->

            })

        binding.rv.adapter = movieAdapter
    }
}