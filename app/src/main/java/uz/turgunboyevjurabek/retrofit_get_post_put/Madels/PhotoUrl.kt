package uz.turgunboyevjurabek.retrofit_get_post_put.Madels

import com.google.gson.annotations.SerializedName

data class PhotoUrl(
    @SerializedName("full")
    val full: String,
    @SerializedName("regular")
    val regular: String
)
