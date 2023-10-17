package uz.turgunboyevjurabek.retrofit_get_post_put.Madels


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("color")
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("exif")
    val exif: Exif,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("links")
    val links: Links,
    @SerializedName("location")
    val location: Location,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("user")
    val user: UserX,
    @SerializedName("views")
    val views: Int,
    @SerializedName("width")
    val width: Int
)