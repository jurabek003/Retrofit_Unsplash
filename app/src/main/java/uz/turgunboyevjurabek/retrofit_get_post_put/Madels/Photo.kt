package uz.turgunboyevjurabek.retrofit_get_post_put.Madels
//
import com.google.gson.annotations.SerializedName


data class Photo(
     @SerializedName("id")
     val id:String,
     @SerializedName("width")
     val width:String,
     @SerializedName("height")
     val height:String,
     @SerializedName("color")
     val color:String,
     @SerializedName("alt_description")
     val description:String,
     @SerializedName("urls")
     val url:PhotoUrl,
     @SerializedName("user")
     val user:User,
     @SerializedName("likes")
     val likes:String,
     @SerializedName("sponsorship")
     val sponsorship:Sponsorship,
     @SerializedName("exif")
     val exif:Exif,



)