package uz.turgunboyevjurabek.retrofit_get_post_put.Madels

import com.google.gson.annotations.SerializedName

data class UnsplashPhoto(
    @SerializedName("urls")
    val urls: UnsplashUrls
)