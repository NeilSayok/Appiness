package neilsayok.github.apilib.api

import neilsayok.github.apilib.model.APIResponse
import retrofit2.Call
import retrofit2.http.GET

interface ResponseAPI {

    @GET("myHierarchy")
    fun getmyHierarchy(): Call<APIResponse>

}