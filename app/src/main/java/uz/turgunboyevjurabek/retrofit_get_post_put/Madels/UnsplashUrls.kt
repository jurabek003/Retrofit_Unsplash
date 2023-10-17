package uz.turgunboyevjurabek.retrofit_get_post_put.Madels

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class UnsplashUrls(
    @SerializedName("full")
val full: String,
@SerializedName("raw")
val raw: String,
@SerializedName("regular")
val regular: String,
@SerializedName("small")
val small: String,
@SerializedName("thumb")
val thumb: String
)