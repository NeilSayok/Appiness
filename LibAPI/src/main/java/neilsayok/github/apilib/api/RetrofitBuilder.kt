package neilsayok.github.apilib.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitBuilder {



    companion object{

        private const val baseUrl = "http://demo2143341.mockable.io/"


        @Volatile
        private var retrofit: Retrofit? = null

        @Synchronized
        fun getRetrofitBuilder():Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }












}