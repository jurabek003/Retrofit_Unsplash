package uz.turgunboyevjurabek.retrofit_get_post_put.Netvork

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.Photo
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.UnsplashPhoto
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.UnsplashUrls
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.User
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.UserX

interface ApiServis {

    @GET("photos/")
     fun getRandomPhoto(
        @Query("client_id") accessKey: String,
        @Query("query") query: String,
    ): Call<List<UnsplashPhoto>>
}