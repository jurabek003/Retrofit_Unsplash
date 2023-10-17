package uz.turgunboyevjurabek.retrofit_get_post_put

import android.app.AlertDialog
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.turgunboyevjurabek.retrofit_get_post_put.Adapter.Onclick
import uz.turgunboyevjurabek.retrofit_get_post_put.Adapter.RvAdapter
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.Position
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.UnsplashPhoto
import uz.turgunboyevjurabek.retrofit_get_post_put.Netvork.ApiClinet
import uz.turgunboyevjurabek.retrofit_get_post_put.Netvork.ApiClinet.ACCESS_KEY
import uz.turgunboyevjurabek.retrofit_get_post_put.Netvork.ApiServis
import uz.turgunboyevjurabek.retrofit_get_post_put.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.retrofit_get_post_put.databinding.DialogItemBinding
import uz.turgunboyevjurabek.retrofit_get_post_put.databinding.ItemRvBinding

class MainActivity : AppCompatActivity() {
   private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var apiServis: ApiServis
    lateinit var list:ArrayList<UnsplashPhoto>
    lateinit var rvAdapter: RvAdapter
    private val page:Int=1
    private val sort:String="popular"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fetchRandomPhoto()

    }

    // Unsplash API dan rasmlarni olish uchun funktsiya
    private  fun fetchRandomPhoto() {

        apiServis=ApiClinet.getSerVis(this)
        apiServis.getRandomPhoto(ACCESS_KEY, "small").enqueue(object :Callback<List<UnsplashPhoto>>{
            override fun onResponse(
                call: Call<List<UnsplashPhoto>>,
                response: Response<List<UnsplashPhoto>>,
            ) {
                if (response.isSuccessful){
                    Toast.makeText(this@MainActivity, "Response Successful", Toast.LENGTH_SHORT).show()

                    binding.activitySecond.visibility=View.GONE
                    list=ArrayList()
                    list.addAll(response.body()!!)
                    rvAdapter=RvAdapter(list,object :Onclick{
                        override fun imageClick(unsplashPhoto: UnsplashPhoto, position: Int) {
                            val dialogs=MaterialAlertDialogBuilder(this@MainActivity).create()
                            val dialogItemBinding=DialogItemBinding.inflate(layoutInflater)
                            dialogs.setView(dialogItemBinding.root)
                            dialogs.show()
                            dialogItemBinding.btnWallpaper.setOnClickListener{
                                val wallpaperThread = Thread {
                                    try {
                                        val wallpaperManager = WallpaperManager.getInstance(this@MainActivity)
                                        val bitmap =
                                            Glide.with(this@MainActivity)
                                                .asBitmap()
                                                .load(list[position].urls.regular)
                                                .submit()
                                                .get()

                                        runOnUiThread {
                                            if (bitmap != null) {
                                                wallpaperManager.setBitmap(bitmap)
                                                Toast.makeText(this@MainActivity, "Rasm o'rnadi", Toast.LENGTH_SHORT).show()
                                            } else {
                                                Toast.makeText(this@MainActivity, "Rasm bo'sh", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                    } catch (e: Exception) {
                                        runOnUiThread {
                                            Toast.makeText(this@MainActivity, "hatolik: ${e.message}", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                }
                                wallpaperThread.start()
                                dialogs.cancel()
                            }
                        }
                    })
                    rvAdapter.notifyDataSetChanged()
                    binding.rvAdapter.adapter=rvAdapter

                }else{
                    Toast.makeText(this@MainActivity, "no successfully", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<UnsplashPhoto>>, t: Throwable) {
                Log.d("@getRandomUnsplashPhoto", "onFailure: ${t.message}")
            }
        })

    }

}
