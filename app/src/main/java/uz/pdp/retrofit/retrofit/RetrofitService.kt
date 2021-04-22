package uz.pdp.retrofit.retrofit

import io.reactivex.Single
import retrofit2.http.GET
import uz.pdp.retrofit.models.Movie

interface RetrofitService {

    @GET("marvel")
    fun getMovie(): Single<List<Movie>>


}