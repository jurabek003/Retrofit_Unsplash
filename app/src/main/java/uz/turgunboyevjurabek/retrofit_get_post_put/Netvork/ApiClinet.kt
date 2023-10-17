package uz.turgunboyevjurabek.retrofit_get_post_put.Netvork

import android.content.Context
import com.readystatesoftware.chuck.BuildConfig
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.turgunboyevjurabek.retrofit_get_post_put.Madels.UnsplashPhoto

object  ApiClinet {

         const val BASE_URL = "https://api.unsplash.com/"
         const val ACCESS_KEY = "q7K362IVgvSBZsmkLLGSGUZCVDIe-tLq1NRq1IqaTsw" // Unsplash API kalitim

    fun getApiPhoto(context: Context):Retrofit{
        val logging=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
       val client=OkHttpClient.Builder()
           .addInterceptor(logging)
           .addInterceptor(Interceptor { chain:Interceptor.Chain ->
               val request=chain.request().newBuilder()
                   .addHeader("Autohorization","Clinet-ID" + ACCESS_KEY)
                   .build()
               chain.proceed(request)
           })
           .build()



        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    fun getSerVis(context: Context):ApiServis{
        return getApiPhoto(context).create(ApiServis::class.java)
    }

















//    fun getRetrofit(context: Context): Retrofit {
//
//        val logging=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
//       val client=OkHttpClient.Builder()
//           .addInterceptor(logging)
//           .addInterceptor(Interceptor { chain:Interceptor.Chain ->
//               val request=chain.request().newBuilder()
//                   .addHeader("Autohorization","Clinet-ID" + BuildConfig.A)
//                   .build()
//               chain.proceed(request)
//           })
//           .build()
//
//        return Retrofit.Builder()
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//    fun getRetrofitServis(context: Context):ApiServis{
//        return getRetrofit(context).create(ApiServis::class.java)
//    }


}




